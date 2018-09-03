package org.business.system.goods.service;



import java.util.List;

import org.business.system.goods.model.GoodsAttr;
import org.business.system.goods.model.dto.GoodsDto;

public interface GoodsService {
	/**
	 * 新增一类商品
	 * @param goods
	 * @return
	 */
	GoodsDto saveGoods(GoodsDto goodsDto);
	
	/**
	 * 编辑一类商品
	 * @param goodsDto
	 * @return
	 */
	GoodsDto updateGoods(GoodsDto goodsDto);
	
	/**
	 * 新增单个商品属性
	 * @param goodsAttr
	 * @return
	 */
	GoodsAttr saveGoodsAttr(GoodsAttr goodsAttr);
	
	/**
	 * 编辑单个属性
	 * @param goodsAttr
	 * @return
	 */
	GoodsAttr updateGoodsAttr(GoodsAttr goodsAttr);

    /**
     * 通过商品id获取该类商品
     * @param id
     * @return
     */
	List<GoodsDto> getGoodsListByGoodsId(Long goodsId);
	
    /**
     * 通过商品属性id获取商品所有信息
     * @param id
     * @return
     */
	GoodsDto getSingleGoodsDtoByAttrId(Long attrId);

  
   

    /**
     * 通过id删除商户
     * @param id
     * @return
     */
    int deleteGoodsById(Long id);

    /**
     * 批量删除商户
     * @param ids
     * @return
     */
    int deleteGoodsByIds(List<Long> ids);
}
