package org.business.system.goods.service.impl;

import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.goods.mapper.GoodsAttrMapper;
import org.business.system.goods.mapper.GoodsMapper;
import org.business.system.goods.model.GoodsAttr;
import org.business.system.goods.service.GoodsAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
class GoodsAttrServiceImpl extends BaseServiceImpl<GoodsAttr,Long> implements GoodsAttrService,DefaultService {
    @Autowired
    private GoodsAttrMapper goodsAttrMapper;

    /**
     * 新增商品详情
     * @param goodsAttr
     * @return
     */
    @Override
    @Transactional
    public int saveGoodsAttr(GoodsAttr goodsAttr){
       return goodsAttrMapper.insertSelective(goodsAttr);
    }

    /**
     * 批量插入商品详情
     * @param goodsAttrList
     * @return
     */
    @Override
    @Transactional
    public int saveGoodsAttrList(List<GoodsAttr> goodsAttrList){
        return goodsAttrMapper.insertList(goodsAttrList);
    }

    /**
     * 更新商品详情
     * @param goodsAttr
     * @return
     */
    @Transactional
    @Override
    public int updateGoodsAttr(GoodsAttr goodsAttr){
        return goodsAttrMapper.updateByPrimaryKey(goodsAttr);
    }

    /**
     * 删除商品详情
     * @param goodsAttr
     * @return
     */
    @Transactional
    @Override
    public  int deleteGoodsAttr(GoodsAttr goodsAttr){
       return goodsAttrMapper.deleteByPrimaryKey(goodsAttr);
    }

    /**
     * 查询商品详情
     * @param goodsAttr
     * @return
     */
    @Override
    public GoodsAttr findGoodsAttr(GoodsAttr goodsAttr){
        return goodsAttrMapper.selectByPrimaryKey(goodsAttr);
    }

    /**
     * 查询商品详情列表
     * @param goodsAttr
     * @return
     */
    @Override
    public List<GoodsAttr> findGoodsAttrList(GoodsAttr goodsAttr){
       return goodsAttrMapper.select(goodsAttr);
    }
}
