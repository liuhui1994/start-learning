package org.business.system.activity.service.impl;

import java.util.List;

import org.business.system.activity.mapper.ActivityMapper;
import org.business.system.activity.mapper.ActivityRuleMapper;
import org.business.system.activity.mapper.RuleMapper;
import org.business.system.activity.model.ActiveityRule;
import org.business.system.activity.model.Activity;
import org.business.system.activity.service.ActivityService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long> implements ActivityService {
	
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
	 * @param userModel
	 * @return
	 */
	private Example createaExample(Activity activity){
		Example example = new Example(Activity.class);
        Criteria criteria = example.createCriteria();
		criteria.andEqualTo("status", BooleanType.FALSE);
		if(activity!=null && activity.getActivityType()!=null){
			criteria.andEqualTo("activityType", activity.getActivityType());
		}
		if(activity!=null && activity.getActivityState()!=null){
			criteria.andEqualTo("activityState", activity.getActivityState());
		}
		return example;
	}
	@Override
	public List<Activity> getActivityList(Activity activity) {
		Example example = createaExample(activity);
		return activityMapper.selectByExample(example);
	}

	@Override
	public void activityAward() {
		Example example = new Example(ActiveityRule.class);
		Criteria criteria = example.createCriteria();
	    criteria.andEqualTo("activityId", 1L);
		List<ActiveityRule> activeityRuleList = activityRuleMapper.selectByExample(example);
		if(activeityRuleList!=null && !activeityRuleList.isEmpty()){
			for (ActiveityRule activeityRule : activeityRuleList) {
				Long ruleId = activeityRule.getRuleId();
				System.out.println(ruleMapper.selectByPrimaryKey(ruleId));
			}
		}
	}

}
