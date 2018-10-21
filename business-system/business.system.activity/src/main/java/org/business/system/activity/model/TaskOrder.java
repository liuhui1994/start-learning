package org.business.system.activity.model;

import java.math.BigDecimal;

import javax.persistence.Table;

/**
 * 任务订单
 * @author liuhui
 *
 */
@Table(name="t_system_task_order")
public class TaskOrder {
	
	private Long id;
	
	private BigDecimal money;  //任务奖励
	
	private BigDecimal price; //佣金
	
	private String orderDesc; //订单描述
	
	private Long userId; //用户id
	
	private Long taskId;//任务id
	
	private String remark;//备注

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	
	

}
