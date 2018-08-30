package org.business.system.order.model;

import org.business.system.common.base.model.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_system_order_item")
public class OrderItem extends Entity {
    @Id
    private Long id;
    //订单id
    private Long orderId;
    //商品名称
    private String goodsName;
    //商品支付价格
    private Float goodsPayPrice;
    //商品数量
    private Long goodsNum;
    //商品sku
    private String sku;
    private String skuDesc;
    private String  skuPic;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Float getGoodsPayPrice() {
        return goodsPayPrice;
    }

    public void setGoodsPayPrice(Float goodsPayPrice) {
        this.goodsPayPrice = goodsPayPrice;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

    public String getSkuPic() {
        return skuPic;
    }

    public void setSkuPic(String skuPic) {
        this.skuPic = skuPic;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
