package org.business.system.goods.model;


public class GoodsAttr {
    //商品详情id
    private Long id;
    //商品id
    private Long goodsId;
    //商品成本价
    private Float costPrice;
    //商品售价
    private Float sellPrice;
    //商品库存
    private Float inventory;
    //商品销量
    private Float sales;
    //sku
    private String sku1;
    //sku描述
    private String skuDesc1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Float costPrice) {
        this.costPrice = costPrice;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Float getInventory() {
        return inventory;
    }

    public void setInventory(Float inventory) {
        this.inventory = inventory;
    }

    public Float getSales() {
        return sales;
    }

    public void setSales(Float sales) {
        this.sales = sales;
    }

    public String getSku1() {
        return sku1;
    }

    public void setSku1(String sku1) {
        this.sku1 = sku1;
    }

    public String getSkuDesc1() {
        return skuDesc1;
    }

    public void setSkuDesc1(String skuDesc1) {
        this.skuDesc1 = skuDesc1;
    }
}
