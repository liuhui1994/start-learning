package org.business.system.newstart.service.impl;

import java.util.List;

import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.newstart.mapper.AddressMapper;
import org.business.system.newstart.model.Address;
import org.business.system.newstart.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService,DefaultService{
	

	
	@Autowired
     private AddressMapper addressMapper;

	
	
	/**
	 * 生成查询的example
	 * @param userModel
	 * @return
	 */
	private Example createaExample(Address address){
		Example example = new Example(Address.class);
        Criteria criteria = example.createCriteria();
        if(!ObjectUtils.isEmpty(address.getUserId())){
        	criteria.andGreaterThanOrEqualTo("userId", address.getUserId());
        }
		criteria.andEqualTo("status", BooleanType.FALSE);
		return example;
	}


	@Override
	public List<Address> getAddressList(Address address) {		
		return addressMapper.selectByExample(createaExample(address));
	}


	@Override
	public Address insertAddress(Address address) {
		 Long userId = address.getUserId();		
		 String province =address.getProvince();		
		 String city = address.getCity();		
		 String area = address.getArea();		
		 String street = address.getStreet();		
		 String phone = address.getPhone();		
		 String contact = address.getContact();
		 if(ObjectUtils.isEmpty(userId)) {
			 throw new CommonErrorException("01", "用户信息不能为空");
		 }
		 if(ObjectUtils.isEmpty(province)) {
			 throw new CommonErrorException("02", "省份不能为空");
		 }
		 if(ObjectUtils.isEmpty(city)) {
			 throw new CommonErrorException("03", "城市不能为空");
		 }
		 if(ObjectUtils.isEmpty(area)) {
			 throw new CommonErrorException("04", "区域不能为空");
		 }
		 if(ObjectUtils.isEmpty(street)) {
			 throw new CommonErrorException("05", "街道地址不能为空");
		 }
		 if(ObjectUtils.isEmpty(phone)) {
			 throw new CommonErrorException("06", "联系方式不能为空");
		 }
		 if(ObjectUtils.isEmpty(contact)) {
			 throw new CommonErrorException("07", "联系人不能为空");
		 }
		 insertEntity(address);
		 int success = addressMapper.insertSelective(address);
		 if(success<=0) {
			 throw new CommonErrorException("00", "新增失败");
		 }
		 return address;
	}


	@Override
	public Address updateAddress(Address address) {
		if(ObjectUtils.isEmpty(address.getId())) {
			throw new CommonErrorException("09", "id不能为空");
		}
		Address oldAddress = addressMapper.selectByPrimaryKey(address.getId());
		if(oldAddress==null) {
			throw new CommonErrorException("10", "传入数据有误");
		}
		 Long userId = address.getUserId();		
		 String province =address.getProvince();		
		 String city = address.getCity();		
		 String area = address.getArea();		
		 String street = address.getStreet();		
		 String phone = address.getPhone();		
		 String contact = address.getContact();
		 if(!ObjectUtils.isEmpty(userId)) {
			 oldAddress.setUserId(userId);
		 }
		 if(!ObjectUtils.isEmpty(province)) {
			 oldAddress.setProvince(province);
		 }
		 if(!ObjectUtils.isEmpty(city)) {
			 oldAddress.setCity(city);
		 }
		 if(!ObjectUtils.isEmpty(area)) {
			 oldAddress.setArea(area);
		 }
		 if(!ObjectUtils.isEmpty(street)) {
			 oldAddress.setStreet(street);
		 }
		 if(!ObjectUtils.isEmpty(phone)) {
			 oldAddress.setPhone(phone);
		 }
		 if(!ObjectUtils.isEmpty(contact)) {
			 oldAddress.setContact(contact);
		 }
		 updateEntity(address);
		 int success = addressMapper.updateByPrimaryKeySelective(oldAddress);
		 if(success<=0) {
			 throw new CommonErrorException("00", "编辑失败");
		 }
		 return address;
	}


	@Override
	public int delAddressById(Long id) {
		if(ObjectUtils.isEmpty(id)) {
			throw new CommonErrorException("09", "id不能为空");
		}
		Address address = addressMapper.selectByPrimaryKey(id);
		if(address==null) {
			throw new CommonErrorException("10", "传入数据有误");
		}
		address.setStatus(BooleanType.TRUE);
		updateEntity(address);
		int success = addressMapper.updateByPrimaryKeySelective(address);
		 if(success<=0) {
			 throw new CommonErrorException("00", "删除失败");
		 }
		 return success;
	}


}
