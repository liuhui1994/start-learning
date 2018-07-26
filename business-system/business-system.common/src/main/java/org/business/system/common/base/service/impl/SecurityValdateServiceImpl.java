package org.business.system.common.base.service.impl;

import org.business.system.common.base.service.SecurityValidateService;
import org.business.system.common.constants.SecurityConstants;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.common.util.AesUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class SecurityValdateServiceImpl implements SecurityValidateService{

	@Override
	public Long getUserIdByUserIdEnc(String userIdEnc) {
		if(ObjectUtils.isEmpty(userIdEnc)) {
			throw new CommonErrorException("服务器异常");
		}
		try {
			return  Long.parseLong(AesUtil.decrypt(userIdEnc, SecurityConstants.USER_ID_SECRET_KEY));
		} catch (NumberFormatException e) {
			throw new CommonErrorException("服务器异常");
		}
	}

}
