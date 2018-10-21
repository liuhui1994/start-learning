package org.business.system.activity.service;

import java.util.List;

import org.business.system.activity.model.Task;
import org.business.system.activity.model.dto.TaskDto;
import org.business.system.common.base.service.BaseService;

public interface TaskService  extends BaseService<Task, Long>{
	
	/**
	 * 获取任务列表
	 * @param task
	 * @return
	 */
	public List<Task>  taskList(Task task);
	
	
	public List<TaskDto>  selectTaskByTaskDao(TaskDto taskDao); 
	
	
	public TaskDto getTaskDtoById(Long id);
	
}
