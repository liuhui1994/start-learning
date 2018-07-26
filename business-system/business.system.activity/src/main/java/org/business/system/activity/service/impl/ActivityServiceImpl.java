package org.business.system.activity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.business.system.activity.em.ActivityState;
import org.business.system.activity.mapper.ActivityMapper;
import org.business.system.activity.mapper.ActivityRuleMapper;
import org.business.system.activity.mapper.RuleMapper;
import org.business.system.activity.model.ActiveityRule;
import org.business.system.activity.model.Activity;
import org.business.system.activity.model.Rule;
import org.business.system.activity.service.ActivityService;
import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long> implements ActivityService, DefaultService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private ActivityRuleMapper activityRuleMapper;

    @Override
    public Activity getActivityById(Long id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    /**
     * 生成查询的example
     *
     * @param userModel
     * @return
     */
    private Example createaExample(Activity activity) {
        Example example = new Example(Activity.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", BooleanType.FALSE);
        if (activity != null && activity.getActivityType() != null) {
            criteria.andEqualTo("activityType", activity.getActivityType());
        }
        if (activity != null && activity.getActivityState() != null) {
            criteria.andEqualTo("activityState", activity.getActivityState());
        }
        return example;
    }

    @Override
    public List<Activity> getActivityList(Activity activity) {
        Example example = createaExample(activity);
        activityAward();
        return activityMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void activityAward() {
        Example example = new Example(ActiveityRule.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activityId", 1L);
        List<ActiveityRule> activeityRuleList = activityRuleMapper.selectByExample(example);
        if (activeityRuleList != null && !activeityRuleList.isEmpty()) {
            for (ActiveityRule activeityRule : activeityRuleList) {
                Long ruleId = activeityRule.getRuleId();
                System.out.println(ruleMapper.selectByPrimaryKey(ruleId));
            }
        }
    }

    @Override
    @Transactional
    public Activity insertActivity(Activity activity) {
        if (activity == null) {
            throw new CommonErrorException("01", "上送对象不合法");
        }
        if (activity.getActivityType() == null) {
            throw new CommonErrorException("02", "活动类型不能为空");
        }
        if (activity.getActivityName() == null) {
            throw new CommonErrorException("03", "活动名称不能为空");
        }
        if (activity.getBudget() == null) {
            activity.setBudget(new BigDecimal("0.00"));
        }
        activity.setActivityState(ActivityState.USE);
        insertEntity(activity);
        int success = activityMapper.insertUseGeneratedKeys(activity);
        if (success <= 0) {
            throw new CommonErrorException("00", "新增失败");
        }
        return activity;
    }

    @Override
    @Transactional
    public Activity updateActivity(Activity activity) {
        if (activity == null || activity.getId() == null) {
            throw new CommonErrorException("01", "上送对象不合法");
        }
        Long activityId = activity.getId();
        Activity oldActivity = activityMapper.selectByPrimaryKey(activityId);
        String activityName = activity.getActivityName();
        Date limitDateStart = activity.getLimitDateStart();
        Date limitDateEnd = activity.getLimitDateEnd();
        String limitTimeArea = activity.getLimitTimeArea();
        String activityNo = activity.getActivityNo();
        String remark = activity.getRemark();
        if (!ObjectUtils.isEmpty(activityName)) {
            oldActivity.setActivityName(activityName);
        }
        if (!ObjectUtils.isEmpty(limitDateStart)) {
            oldActivity.setLimitDateStart(limitDateStart);
        }
        if (!ObjectUtils.isEmpty(limitTimeArea)) {
            oldActivity.setLimitTimeArea(limitTimeArea);
        }
        if (ObjectUtils.isEmpty(limitDateEnd)) {
            oldActivity.setLimitDateEnd(limitDateEnd);
        }
        if (!ObjectUtils.isEmpty(activityNo)) {
            oldActivity.setActivityNo(activityNo);
        }
        if (!ObjectUtils.isEmpty(remark)) {
            oldActivity.setRemark(remark);
        }
        updateEntity(activity);
        int success = activityMapper.updateByPrimaryKeySelective(oldActivity);
        if (success <= 0) {
            throw new CommonErrorException("00", "编辑失败");
        }
        return oldActivity;
    }


    @Override
    @Transactional
    public int bindRule(Long activityId, List<Long> ruleId) {
        Activity activity = activityMapper.selectByPrimaryKey(activityId);
        if (activity == null) {
            throw new CommonErrorException("01", "上送数据不合法");
        }
        if (ObjectUtils.isEmpty(ruleId)) {
            throw new CommonErrorException("05", "绑定规则不能为空");
        }
        List<ActiveityRule> list = new ArrayList<ActiveityRule>();
        for (Long id : ruleId) {
            Rule rule = ruleMapper.selectByPrimaryKey(id);
            if (rule == null) {
                throw new CommonErrorException("05", "绑定规则不能为空");
            }
            ActiveityRule activeityRule = new ActiveityRule();
            activeityRule.setActivityId(activityId);
            activeityRule.setRuleId(id);
            list.add(activeityRule);
        }
        int success = activityRuleMapper.insertList(list);
        if (success <= 0) {
            throw new CommonErrorException("00", "新增失败");
        }
        return success;
    }

}
