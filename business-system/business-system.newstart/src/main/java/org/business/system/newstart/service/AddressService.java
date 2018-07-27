package org.business.system.newstart.service;

import java.util.List;

import org.business.system.common.base.service.BaseService;
import org.business.system.common.em.UserState;
import org.business.system.newstart.model.Address;

public interface AddressService extends BaseService<Address, Long> {
	
	/**
	 * 查询所有用户
	 * @param userModel
	 * @return
	 */
	public List<Address> getAddressList(Address address);
	
	/**
	 * 新用户注册
	 * @param user
	 * @return
	 */
	public Address insertAddress(Address  address);
	
	/**
	 * 用户冻结或解冻
	 * @param userIdEnc
	 * @param state
	 * @return
	 */
	public Address updateAddress(Address address);
	
	/**
	 * 用户冻结或解冻
	 * @param userIdEnc
	 * @param state
	 * @return
	 */
	public int delAddressById(Long id);

}
