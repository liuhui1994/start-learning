package org.business.system.cart.model;

import org.business.system.common.base.model.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="t_system_cart")
public class Cart extends Entity {
    @Id
    private Long id;
    private Long userId;
    private Long itemId;
    private String itemTitle;
    private String itemImage;
    private Float itemPrice;
    private Long num;
    private String sku;

    private Float subTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Float getSubTotal() {
        return itemPrice * num;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }
}
