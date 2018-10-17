package org.business.system.activity.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.business.system.activity.em.ActivityPrizeType;
import org.business.system.activity.em.ActivityState;
import org.business.system.activity.mapper.ActivityMapper;
import org.business.system.activity.mapper.ActivityRuleMapper;
import org.business.system.activity.mapper.ActivityStatisticsMapper;
import org.business.system.activity.mapper.RuleMapper;
import org.business.system.activity.model.Activity;
import org.business.system.activity.model.ActivityClaimStatistics;
import org.business.system.activity.model.ActivityRule;
import org.business.system.activity.model.Rule;
import org.business.system.activity.model.dto.ActivityAwardDto;
import org.business.system.activity.service.ActivityService;
import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.SecurityValidateService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.util.RandomUtils;
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
    
    @Autowired
    private ActivityStatisticsMapper activityStatisticsMapper;
   
    @Autowired
    private SecurityValidateService  securityValidateService;

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
        return activityMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void activityAward(ActivityAwardDto activityAwardDto) {
    	Long activityId = activityAwardDto.getActivityId();
    	Long userId = securityValidateService.getUserIdByUserIdEnc(activityAwardDto.getUserIdEnc());
    	//活动常规校验
    	Activity activity = activityMapper.selectByPrimaryKey(activityId);

    	activityValidate(activity);
    	
    	ActivityAwardDto acsDto = null;
        Example example = new Example(ActivityRule.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("activityId", activityId);
        List<ActivityRule> activeityRuleList = activityRuleMapper.selectByExample(example);
        if (activeityRuleList != null && !activeityRuleList.isEmpty()) {
            for (ActivityRule activeityRule : activeityRuleList) {
            	Long ruleId = activeityRule.getRuleId();
            	ActivityAwardDto aaDao = new ActivityAwardDto();
            	aaDao.setActivityId(activityId);
            	aaDao.setRuleId(ruleId);
            	aaDao.setUserId(userId);
                Rule  rule = ruleMapper.selectByPrimaryKey(ruleId);
                ActivityPrizeType awardType = rule.getAwardType();
                switch (rule.getLimitType()) {
				case DAY:break;
				case HOUR:break;
				case MOTNTH:break;
				case NONE:break;
				case WEEK:break;
				default:break;
				}
                acsDto = activityLimitTypeValidate(aaDao,rule);
               
              //活动预算校验
                BigDecimal budget = activity.getBudget();
               if(budget!=null && budget.compareTo(new BigDecimal("0.00"))>0) {
            	   
               }
                
              //新增或编辑活动统计记录
                
              //新增奖品领取记录
                
              //派奖
            }
        }
        
    }
    
    private ActivityAwardDto activityLimitTypeValidate(ActivityAwardDto activityAwardDto,Rule rule) {   
    	ActivityAwardDto aaDao= new ActivityAwardDto();
    	Example example = new Example(ActivityClaimStatistics.class);
    	Criteria criteria = example.createCriteria();
    	if(!ObjectUtils.isEmpty(activityAwardDto.getActivityId())) {
    		criteria.andEqualTo("activityId", activityAwardDto.getActivityId());	
    	}
    	if(!ObjectUtils.isEmpty(activityAwardDto.getRuleId())) {
    		criteria.andEqualTo("ruleId", activityAwardDto.getRuleId());	
    	}
    	if(!ObjectUtils.isEmpty(activityAwardDto.getUserId())) {
    		criteria.andEqualTo("userId", activityAwardDto.getUserId());	
    	}
    	if(!ObjectUtils.isEmpty(activityAwardDto.getCreateDateEnd())) {
        	criteria.andLessThanOrEqualTo("createDate", activityAwardDto.getCreateDateEnd());
    	}
    	if(!ObjectUtils.isEmpty(activityAwardDto.getCreateDateStart())) {
        	criteria.andGreaterThanOrEqualTo("createDate", activityAwardDto.getCreateDateStart());

    	}
    	List<ActivityClaimStatistics> statisticsList = activityStatisticsMapper.selectByExample(example);
    	if(statisticsList!=null && statisticsList.size()>1) {
    		//数据异常
    		throw new CommonErrorException("00","服务器异常");
    	}
    	String prize = null;
    	if(statisticsList==null) {
    		//无数据
    		int radom = RandomUtils.generateRangeNumber(1, 100);
     		BigDecimal odds = rule.getTheOdds();
     		if(new BigDecimal(radom).compareTo(odds)<=0) {
     			prize = rule.getPrize();
     			aaDao.setPrize(prize);
     			aaDao.setCode("200");
     		}
    		return aaDao;
    	}
    	ActivityClaimStatistics acs = statisticsList.get(0);
 
    	 if(acs !=null) {
         	Long limitCount = rule.getLimitCount();
         	Long compareCount =0L;
         	 switch (rule.getLimitType()) {
				  case DAY: compareCount = acs.getClaimNumByDay(); break;
				  case HOUR: compareCount = acs.getClaimNumByHour(); break;
				  case MOTNTH: compareCount = null; break;
				  case NONE: compareCount = 0L; break;
				  case WEEK:compareCount = acs.getClaimNumByWeek(); break;
				  default:break;
				}
         	if(compareCount == null || compareCount < limitCount) {
         		//获取奖励金额
         		int radom = RandomUtils.generateRangeNumber(1, 100);
         		BigDecimal odds = rule.getTheOdds();
         		if(new BigDecimal(radom).compareTo(odds)<=0) {
         			prize = rule.getPrize();
         			aaDao.setPrize(prize);
         			aaDao.setCode("200");
         			aaDao.setActivityClaimStatistics(acs);
         		}
         	}else {
         		throw new CommonErrorException("14","领取次数限制");
         	}
         }
    	return aaDao;
    	
    }
    

    
    /**
     * 活动校验
     * @param activityId
     */
    private void activityValidate(Activity activity) {
    	if(activity == null || BooleanType.FALSE != activity.getStatus()) {
    		 throw new CommonErrorException("10", "活动不存在");
    	}
    	if(ActivityState.USE != activity.getActivityState() ) {
    		 throw new CommonErrorException("11", "活动未启用");
    	}
    	Date limitStartDate = activity.getLimitDateStart();
    	Date limitEndDate = activity.getLimitDateEnd();
    	if(limitEndDate!=null && limitEndDate.getTime()<new Date().getTime()) {
    		 throw new CommonErrorException("12", "活动已过期");
    	}
    	
    	if(limitStartDate!=null && limitStartDate.getTime()>new Date().getTime()) {
   		     throw new CommonErrorException("13", "活动未开始");
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
        if(ActivityState.USE == oldActivity.getActivityState()) {
        	 throw new CommonErrorException("14", "活动使用中,请暂停后编辑");
        }
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
        if (!ObjectUtils.isEmpty(limitDateEnd)) {
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
        List<ActivityRule> list = new ArrayList<ActivityRule>();
        for (Long id : ruleId) {
            Rule rule = ruleMapper.selectByPrimaryKey(id);
            if (rule == null) {
                throw new CommonErrorException("05", "绑定规则不能为空");
            }
            ActivityRule activeityRule = new ActivityRule();
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
