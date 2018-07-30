package org.business.system.goods.service;

import org.business.system.common.base.service.BaseService;
import org.business.system.goods.model.GoodsAttr;

import java.util.List;

public interface GoodsAttrService extends BaseService<GoodsAttr,Long> {
    /**
     * 添加商品详情
     * @param goodsAttr
     * @return
     */
    int saveGoodsAttr(GoodsAttr goodsAttr);

    /**
     * 批量添加商品详情
     * @param goodsAttrList
     * @return
     */
    int saveGoodsAttrList(List<GoodsAttr> goodsAttrList);

    /**
     * 更新商品详情
     * @param goodsAttr
     * @return
     */
    int updateGoodsAttr(GoodsAttr goodsAttr);

    /**
     * 删除商品详情
     * @param goodsAttr
     * @return
     */
    int deleteGoodsAttr(GoodsAttr goodsAttr);

    /**
     * 查找商品详情
     * @param goodsAttr
     * @return
     */
    GoodsAttr findGoodsAttr(GoodsAttr goodsAttr);

    /**
     * 查找商品详情列表
     * @param goodsAttr
     * @return
     */
    List<GoodsAttr> findGoodsAttrList(GoodsAttr goodsAttr);
}
