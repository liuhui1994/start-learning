package org.business.system.merchant.service;

import org.business.system.merchant.model.Merchant;
import org.business.system.merchant.model.dto.MerchantDto;

import java.util.List;

public interface MerchantService {
	/**
	 * 新增商户
	 * @param merchant
	 * @return
	 */
    Merchant saveMerchant(Merchant merchant);

    /**
     * 通过id获取商户详情
     * @param id
     * @return
     */
    Merchant getMerchantById(Long id);

    /**
     * 编辑商户
     * @param merchant
     * @return
     */
    Merchant updateMerchant(Merchant merchant);

    /**
     * 通过dto获取商户列表
     * @param merchantDto
     * @return
     */
    List<Merchant> getMerchantListByDto(MerchantDto merchantDto);

    /**
     * 通过id删除商户
     * @param id
     * @return
     */
    int deleteMerchantById(Long id);

    /**
     * 批量删除商户
     * @param ids
     * @return
     */
    int deleteMerchantByIds(List<Long> ids);
}
