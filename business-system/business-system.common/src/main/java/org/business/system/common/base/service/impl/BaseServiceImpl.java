package org.business.system.common.base.service.impl;

import java.util.List;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.configuration.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

//@Service
public class BaseServiceImpl<T,PK> implements BaseService<T, PK> {
	
	@Autowired
	private BaseMapper<T> mapper;
	

    /**
     * 根据id查询数据
     * 
     * @param id
     * @return
     */
    public T queryById(PK pk) {
       return mapper.selectByPrimaryKey(pk);
    }

    /**
     * 查询所有数据
     * 
     * @return
     */
    public List<T> queryAll() {
        return mapper.select(null);
    }

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     * 
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return mapper.selectOne(record);
    }

    /**
     * 根据条件查询数据列表
     * 
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return mapper.select(record);
    }

    /**
     * 分页查询
     * 
     * @param page
     * @param rows
     * @param record
     * @return
     */
    public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) {
        // 设置分页条件
//        PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhere(record);
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer save(T record) {
         return mapper.insert(record);
        }

    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer saveSelective(T record) {
        return mapper.insertSelective(record);
    }

    /**
     * 修改数据，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer update(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     * 
     * @param record
     * @return
     */
    public Integer updateSelective(T record) {
       return mapper.updateByPrimaryKeySelective(record);
    }


	public void setMapper(BaseMapper<T> mapper) {
		this.mapper = mapper;
	}

}
