package org.business.system.goods.model;

import org.business.system.common.base.model.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "t_system_goods")
public class Goods  extends Entity {
    @Id
    private Long id;
    //商品名称
    private String goodsName;
    //商品编号
    private String goodsSerial;
    //商品描述
    private String describle;
    //品牌
    private Long brandId;
    //所属商户
    private Long merchantId;
    //商品规格
    private String specifications;
    //材质
    private String material;
    //款式
    private String style;
    //产地
    private String product;
    //重量
    private String weight;
    //适用对象
    private String suitable;
    //商品主图
    private String pic;
    //商品详情
    private String detail;
    //关键字
    private String keyword;
    //是否开发票
    private Boolean isInvoice;
    //是否保修
    private Boolean isWarranty;
    //其他服务
    private String otherService;
    //备注
    private String remark;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSerial() {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial) {
        this.goodsSerial = goodsSerial;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSuitable() {
        return suitable;
    }

    public void setSuitable(String suitable) {
        this.suitable = suitable;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Boolean getInvoice() {
        return isInvoice;
    }

    public void setInvoice(Boolean invoice) {
        isInvoice = invoice;
    }

    public Boolean getWarranty() {
        return isWarranty;
    }

    public void setWarranty(Boolean warranty) {
        isWarranty = warranty;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
