package org.business.system.merchant.service.impl;

import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.merchant.mapper.MerchantMapper;
import org.business.system.merchant.model.Merchant;
import org.business.system.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MerchantServiceImpl extends BaseServiceImpl<Merchant,Long> implements MerchantService,DefaultService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public Merchant saveMerchant(Merchant merchant) {

        merchant.setAppId(UUID.randomUUID().toString().replace("-",""));
        merchant.setAppKey(UUID.randomUUID().toString().replace("-",""));
        this.checkMerchant(merchant);
        merchant.setCommision(merchant.getCommision()/100);
        insertEntity(merchant);
         merchantMapper.insertSelective(merchant);
         return merchant;
    }

    @Override
    public Merchant getMerchantById(Long id) {
        return merchantMapper.selectByPrimaryKey(id);
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) {
        if(merchant.getId() == null || merchant.getId() <= 0){
            throw new CommonErrorException("商户id有误");
        }
        this.checkMerchant(merchant);
        int result = merchantMapper.updateByPrimaryKeySelective(merchant);
        if(result <= 0){
            throw new CommonErrorException("更新商户失败");
        }
        return merchant;
    }

    @Override
    public List<Merchant> getMerchantList(Merchant merchant) {

        Example example = new Example(Merchant.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("merchantType",merchant.getMerchantType());
        criteria.andEqualTo("status", BooleanType.FALSE);
        return merchantMapper.selectByExample(example);

    }

    @Override
    public int deleteMerchantById(Long id) {
         return merchantMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteMerchantByIds(List<Long> ids) {
        int result = 0;
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        for ( Long id:ids) {
            Merchant merchantById = this.getMerchantById(id);
            merchantById.setStatus(BooleanType.TRUE);
            result = merchantMapper.updateByPrimaryKey(merchantById);
        }
        return result;
    }

    private void checkMerchant(Merchant merchant) {
        if(StringUtils.isEmpty(merchant.getAccountName())){
            throw new CommonErrorException("商户账户不能为空");
        }
        if(StringUtils.isEmpty(merchant.getAddress())){
            throw new CommonErrorException("商户地址不能为空");
        }
        if(StringUtils.isEmpty(merchant.getMerchantName())){
            throw new CommonErrorException("商户名称不能为空");
        }
        if(StringUtils.isEmpty(merchant.getBusinessLicense())){
            throw  new CommonErrorException("商户营业执照不能为空");
        }
        if(StringUtils.isEmpty(merchant.getContact())){
            throw new CommonErrorException("商户联系人不能为空");
        }
        if(StringUtils.isEmpty(merchant.getPhone())){
            throw new CommonErrorException("商户联系人电话不能为空");
        }
        if(StringUtils.isEmpty(merchant.getLogo())){
            throw new CommonErrorException("logo不能为空");
        }
        if(StringUtils.isEmpty(merchant.getAppId())){
            throw  new CommonErrorException("appId不能为空");
        }
        if(StringUtils.isEmpty(merchant.getAppKey())){
            throw  new CommonErrorException("appKey不能为空");
        }
        if(merchant.getAccountType() == null){
            throw new CommonErrorException("账户类型不能为空");
        }
        if(merchant.getMerchantType() == null){
            throw new CommonErrorException("商户类型不能为空");
        }
        if(merchant.getCommision() == null || merchant.getCommision() > 100 || merchant.getCommision() < 0){
            throw new CommonErrorException("佣金比列输入有误");
        }
    }
}
