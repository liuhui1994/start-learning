package org.business.system.merchant.service;

import org.business.system.merchant.model.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant saveMerchant(Merchant merchant);

    Merchant getMerchantById(Long id);

    Merchant updateMerchant(Merchant merchant);

    List<Merchant> getMerchantList(Merchant merchant);

    int deleteMerchantById(Long id);

    int deleteMerchantByIds(List<Long> ids);
}
