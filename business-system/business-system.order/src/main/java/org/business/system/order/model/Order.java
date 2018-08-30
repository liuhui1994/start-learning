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
    private String outOrderNo;
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

    private Long userId;
    private String fee;

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

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
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
