package org.business.system.goods.model.dto;

import java.util.List;

import org.business.system.goods.model.Goods;
import org.business.system.goods.model.GoodsAttr;

public class GoodsDto  extends Goods {
	
	private List<GoodsAttr> goodsAttrs;

	public List<GoodsAttr> getGoodsAttrs() {
		return goodsAttrs;
	}

	public void setGoodsAttrs(List<GoodsAttr> goodsAttrs) {
		this.goodsAttrs = goodsAttrs;
	}
	
	
    
	
}
