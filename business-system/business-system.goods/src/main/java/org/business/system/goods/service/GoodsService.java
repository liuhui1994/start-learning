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
	GoodsDto saveGoods(GoodsDto goods);
	
	/**
	 * 新增单个商品
	 * @param goodsAttr
	 * @return
	 */
	GoodsAttr saveGoodsAttr(GoodsAttr goodsAttr);

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
	GoodsDto getGoodsDtoByGoodsId(Long attrId);

  
   

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
