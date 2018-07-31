package org.business.system.goods.model.dto;

import org.business.system.goods.model.Goods;
import org.business.system.goods.model.GoodsAttr;

import java.util.List;

public class GoodsDto  extends Goods {

    public GoodsDto(Goods goods){
        this.setBrandId(goods.getBrandId());
        this.setDescrible(goods.getDescrible());
        this.setDetail(goods.getDetail());
        this.setGoodsName(goods.getGoodsName());
        this.setGoodsSerial(goods.getGoodsSerial());
        this.setId(goods.getId());
        this.setInvoice(goods.getInvoice());
        this.setKeyword(goods.getKeyword());
        this.setMaterial(goods.getMaterial());
        this.setMerchantId(goods.getMerchantId());
        this.setPic(goods.getPic());
        this.setOtherService(goods.getOtherService());
        this.setProduct(goods.getProduct());
        this.setRemark(goods.getRemark());
        this.setSpecifications(goods.getSpecifications());
        this.setStyle(goods.getStyle());
        this.setSuitable(goods.getSuitable());
        this.setWarranty(goods.getWarranty());
        this.setWeight(goods.getWeight());
        this.setCreateDate(goods.getCreateDate());
        this.setCreator(goods.getCreator());
        this.setModifier(goods.getModifier());
        this.setModifyDate(goods.getModifyDate());
        this.setStatus(goods.getStatus());
    }

    public GoodsDto(){}
    //商品属性
    private String goodsAttrs;
    //商品属性
    private List<GoodsAttr> goodsAttrList;

    public String getGoodsAttrs() {
        return goodsAttrs;
    }

    public void setGoodsAttrs(String goodsAttrs) {
        this.goodsAttrs = goodsAttrs;
    }

    public List<GoodsAttr> getGoodsAttrList() {
        return goodsAttrList;
    }

    public void setGoodsAttrList(List<GoodsAttr> goodsAttrList) {
        this.goodsAttrList = goodsAttrList;
    }
	
}
