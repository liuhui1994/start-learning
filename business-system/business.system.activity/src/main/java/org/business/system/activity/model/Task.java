package org.business.system.activity.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;

import org.business.system.activity.em.TaskChannel;
import org.business.system.activity.em.TaskStatus;
import org.business.system.activity.em.TaskType;
import org.business.system.common.base.model.Entity;
/**
 * 任务相关信息基础类
 * @author liuhui
 *
 */
@Table(name="t_system_task")
public class Task  extends Entity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private  Long id;
	
	private String taskTitle;   //任务标题
	
	private String taskDesc;   //任务描述
	
	private BigDecimal  taskMoney;  //任务赏金
	
	private BigDecimal memberTaskMoney;  //任务会员赏金
	
	private BigDecimal money; //任务赏金
	
	private String taskUrl; //任务url
	
	private String taskResource; //任务资源
	
	private String remark;
	
	private TaskChannel taskChannel;  //任务渠道
	
	private TaskType taskType;  //任务类型
	
	private TaskStatus taskStatus; //任务状态
	
	private String taskNo; //任务对外编号
	
	//任务场景

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public BigDecimal getTaskMoney() {
		return taskMoney;
	}

	public void setTaskMoney(BigDecimal taskMoney) {
		this.taskMoney = taskMoney;
	}

	public BigDecimal getMemberTaskMoney() {
		return memberTaskMoney;
	}

	public void setMemberTaskMoney(BigDecimal memberTaskMoney) {
		this.memberTaskMoney = memberTaskMoney;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getTaskUrl() {
		return taskUrl;
	}

	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}

	public String getTaskResource() {
		return taskResource;
	}

	public void setTaskResource(String taskResource) {
		this.taskResource = taskResource;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public TaskChannel getTaskChannel() {
		return taskChannel;
	}

	public void setTaskChannel(TaskChannel taskChannel) {
		this.taskChannel = taskChannel;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}
	
	
	
	
	

}
