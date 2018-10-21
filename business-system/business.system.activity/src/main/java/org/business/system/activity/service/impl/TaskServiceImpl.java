package org.business.system.activity.service.impl;

import java.util.List;
import org.business.system.activity.mapper.TaskMapper;
import org.business.system.activity.model.Task;
import org.business.system.activity.model.dto.TaskDto;
import org.business.system.activity.service.TaskService;
import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.util.ReflectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, Long> implements TaskService, DefaultService {
	
	@Autowired
	private TaskMapper  taskMapper;
	
	

	@Override
	public List<Task> taskList(Task task) {
		Example example = createaExample(task);
		return taskMapper.selectByExample(example);
	}
	
	
	
	 /**
     * 生成查询的example
     *
     * @param userModel
     * @return
     */
    private Example createaExample(Task task) {
        Example example = new Example(Task.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status", BooleanType.FALSE);

        return example;
    }



	@Override
	public List<TaskDto> selectTaskByTaskDao(TaskDto taskDao) {
		return taskMapper.selectTaskByTaskDao(taskDao);
	}



	@Override
	public TaskDto getTaskDtoById(Long id) {
		TaskDto taskDto = new TaskDto();
		ReflectionUtil.copyProperties(taskMapper.selectByPrimaryKey(id), taskDto);
		return taskDto;
	}

   
}
