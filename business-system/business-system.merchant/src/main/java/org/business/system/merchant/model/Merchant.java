package org.business.system.merchant.model;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.AccountType;
import org.business.system.merchant.em.MerchantType;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_system_merchant")
public class Merchant  extends Entity {
    @Id
    private Long id;
    //商户名称
    private String merchantName;
    //商户类型
    private MerchantType merchantType;
    //商户地址
    private String address;
    //商户账号
    private String accountName;
    //商户类型
    private AccountType accountType;
    //银行账户
    private String bankAccount;
    //支付宝号
    private String payAccount;
    //佣金比例
    private Float commision;
    //联系人
    private String contact;
    //联系人电话
    private String phone;

    private String appId;
    private String appKey;
    //营业执照
    private String businessLicense;
    private String logo;
    //备注
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public MerchantType getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(MerchantType merchantType) {
        this.merchantType = merchantType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPayAccount() {
        return payAccount;
    }

    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    public Float getCommision() {
        return commision;
    }

    public void setCommision(Float commision) {
        this.commision = commision;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
