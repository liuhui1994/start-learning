package org.business.system.order.model;

import org.business.system.common.base.model.Entity;
import org.business.system.common.em.BooleanType;
import org.business.system.order.em.OrderStatusType;
import org.business.system.order.em.PayStatus;
import org.business.system.order.em.RefundStatusType;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name = "t_system_order")
public class Order extends Entity {
    @Id
    private Long id;
    //订单编号
    private String orderNo;
    // 交易类型
    private String tradeType;
    //支付类型
    private String payType;
    //支付状态
    private PayStatus payStatus;
    //站外订单号
    private String outTradeNo;
    //支付时间
    private Date payDateTime;
    //支付金额
    private Float payPrice;
    //订单总金额
    private Float orderTotalPrice;
    //订单状态
    private OrderStatusType orderStatus;

    private RefundStatusType refundStatus;
    //交易完成时间
    private Date txnCompleteTime;
    //订单限制支付时间
    private Date limitPayTime;
    //退款金额
    private Float refundPrice;
    //商户id
    private Long merchantId;
    //订单说明
    private String orderTitle;
    //消费奖励
    private String award;
    //收货地址
    private String collectionAddress;
    //物流信息
    private String logistics;




    private Long userId;
    private String fee;


    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getCollectionAddress() {
        return collectionAddress;
    }

    public void setCollectionAddress(String collectionAddress) {
        this.collectionAddress = collectionAddress;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public PayStatus getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PayStatus payStatus) {
        this.payStatus = payStatus;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Date getPayDateTime() {
        return payDateTime;
    }

    public void setPayDateTime(Date payDateTime) {
        this.payDateTime = payDateTime;
    }

    public Float getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Float payPrice) {
        this.payPrice = payPrice;
    }

    public Float getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(Float orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public OrderStatusType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusType orderStatus) {
        this.orderStatus = orderStatus;
    }

    public RefundStatusType getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(RefundStatusType refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getTxnCompleteTime() {
        return txnCompleteTime;
    }

    public void setTxnCompleteTime(Date txnCompleteTime) {
        this.txnCompleteTime = txnCompleteTime;
    }

    public Date getLimitPayTime() {
        return limitPayTime;
    }

    public void setLimitPayTime(Date limitPayTime) {
        this.limitPayTime = limitPayTime;
    }

    public Float getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(Float refundPrice) {
        this.refundPrice = refundPrice;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
