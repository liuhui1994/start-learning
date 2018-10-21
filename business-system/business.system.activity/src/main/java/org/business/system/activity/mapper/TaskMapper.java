package org.business.system.activity.mapper;

import java.util.List;

import org.business.system.activity.model.Task;
import org.business.system.activity.model.dto.TaskDto;
import org.business.system.common.configuration.BaseMapper;

public interface TaskMapper extends BaseMapper<Task> {
	
	public List<TaskDto> selectTaskByTaskDao(TaskDto taskDao); 

}
