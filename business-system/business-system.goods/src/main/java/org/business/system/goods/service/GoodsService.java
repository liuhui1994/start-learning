package org.business.system.goods.service;



import org.business.system.goods.model.Goods;
import org.business.system.goods.model.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
	/**
	 * 新增商户
	 * @param goods
	 * @return
	 */
    Goods saveGoods(Goods goods);

    /**
     * 通过id获取商户详情
     * @param id
     * @return
     */
    Goods getGoodsById(Long id);

    /**
     * 编辑商户
     * @param goods
     * @return
     */
    Goods updateGoods(Goods goods);

    /**
     * 通过dto获取商户列表
     * @param goodsDto
     * @return
     */
    List<Goods> getGoodsListByDto(GoodsDto goodsDto);

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
