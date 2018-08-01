package org.business.system.goods.service.impl;

import java.util.List;
import java.util.UUID;
import org.business.system.common.base.service.DefaultService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.em.BooleanType;
import org.business.system.common.exception.CommonErrorException;
import org.business.system.goods.mapper.GoodsAttrMapper;
import org.business.system.goods.mapper.GoodsMapper;
import org.business.system.goods.model.Goods;
import org.business.system.goods.model.GoodsAttr;
import org.business.system.goods.model.dto.GoodsDto;
import org.business.system.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods,Long> implements GoodsService,DefaultService {

    @Autowired
    private GoodsMapper goodsMapper;
    
    @Autowired
    private GoodsAttrMapper goodsAttrMapper;

    Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
    /**
	 * 生成查询的example
	 * @param
	 * @return
	 */
	private Example createaExample(GoodsDto goodsDto){
		Example example = new Example(Goods.class);
        Criteria criteria = example.createCriteria();
		criteria.andEqualTo("status", BooleanType.FALSE);
		if(goodsDto!=null && !StringUtils.isEmpty(goodsDto.getGoodsName())){
	        criteria.andEqualTo("goodsName",goodsDto.getGoodsName());
		}
		return example;
	}

    @Override
    @Transactional
    public GoodsDto saveGoods(GoodsDto goodsDto) {
    	goodsDto.setGoodsSerial(UUID.randomUUID().toString().replace("-","")); //商品编号生成有误
        this.checkGoods(goodsDto);
        insertEntity(goodsDto);
        int success = goodsMapper.insertUseGeneratedKeys(goodsDto);
        if(success <= 0) {
        	throw new CommonErrorException("00", "新增失败");
        }
        Long goodsId = goodsDto.getId();
        if(!StringUtils.isEmpty(goodsDto.getGoodsAttrList())){
        	List<GoodsAttr> goodsAttrList = goodsDto.getGoodsAttrList();
            goodsAttrList.stream().forEach(goodsAttr->{
            	goodsAttr.setGoodsId(goodsId);
            });
            success = goodsAttrMapper.insertList(goodsAttrList);
        }
        if(success <= 0) {
        	throw new CommonErrorException("00", "新增失败");
        }
        return goodsDto;
    }
    
	@Override
	public GoodsDto updateGoods(GoodsDto goodsDto) {
		// TODO Auto-generated method stub
		return null;
	}
    

	
	@Override
	public GoodsAttr saveGoodsAttr(GoodsAttr goodsAttr) {
		this.checkGoodsAttr(goodsAttr);
	    Goods goods = goodsMapper.selectByPrimaryKey(goodsAttr.getGoodsId());
	    if(goods ==null) {
	    	throw new CommonErrorException("01", "当前选择商品id有误");
	    }
	    int success = goodsAttrMapper.insertSelective(goodsAttr);
	    if(success<=0) {
	    	throw new CommonErrorException("00", "新增失败");
	    }
		return goodsAttr;
	}
	
	@Override
	public GoodsAttr updateGoodsAttr(GoodsAttr goodsAttr) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<GoodsDto> getGoodsListByGoodsId(Long goodsId) {
		return goodsAttrMapper.selectGoodsDtoById(goodsId);
	}
	
	@Override
	public GoodsDto getGoodsDtoByGoodsId(Long attrId) {
		return goodsAttrMapper.selectGoodsByattrId(attrId);
	}
	
	@Override
	public int deleteGoodsById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

    @Override
    @Transactional
    public int deleteGoodsByIds(List<Long> ids) {
        int result = 0;
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        return result;
    }

    private void checkGoods(Goods goods) {
        if(StringUtils.isEmpty(goods.getGoodsName())){
            throw new CommonErrorException("01","商品名字不能为空");
        }
        if(StringUtils.isEmpty(goods.getDescrible())){
            throw new CommonErrorException("02","商户描述不能为空");
        }
//        if(StringUtils.isEmpty(goods.getDetail())){
//            throw new CommonErrorException("03","商品详情不能为空");
//        }
        if(StringUtils.isEmpty(goods.getGoodsSerial())){
            throw  new CommonErrorException("04","商品编号不能为空");
        }
        if(StringUtils.isEmpty(goods.getKeyword())){
            throw new CommonErrorException("05","关键字不能为空");
        }
//        if(StringUtils.isEmpty(goods.getMaterial())){
//            throw new CommonErrorException("06","商品材料不能为空");
//        }
        if(StringUtils.isEmpty(goods.getPic())){
            throw new CommonErrorException("07","图片不能为空");
        }
//        if(StringUtils.isEmpty(goods.getProduct())){
//            throw  new CommonErrorException("08","产地不能为空");
//        }
//        if(StringUtils.isEmpty(goods.getSpecifications())){
//            throw  new CommonErrorException("09","规格不能为空");
//        }
//        if(StringUtils.isEmpty(goods.getStyle())){
//            throw new CommonErrorException("10","款式不能为空");
//        }
//        if(StringUtils.isEmpty(goods.getSuitable())){
//            throw new CommonErrorException("11","商品适宜人群不能为空");
//        }
//        if(goods.getBrandId() == null){
//            throw new CommonErrorException("12","商品品牌不能为空");
//        }
//        if(goods.getMerchantId() == null){
//            throw new CommonErrorException("13","商品所属商户不能为空");
//        }
        if(StringUtils.isEmpty(goods.getIsInvoice())){
            throw  new CommonErrorException("14","商品是否开发票不能为空");
        }
        if(StringUtils.isEmpty(goods.getIsWarranty())){
            throw new CommonErrorException("15","商品是否保修不能为空");
        }
        if(StringUtils.isEmpty(goods.getOneMenu())){
            throw  new CommonErrorException("16","商品所属一级类目不能为空");
        }
        if(StringUtils.isEmpty(goods.getTwoMenu())){
            throw new CommonErrorException("17","商品所属二级类目不能为空");
        }
    }


    private void checkGoodsAttr(GoodsAttr goodsAttr) {
         if(ObjectUtils.isEmpty(goodsAttr.getGoodsId())){
             throw  new CommonErrorException("18","商品关联id不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getCostPrice())){
             throw new CommonErrorException("19","商品成本价不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getSellPrice())){
             throw  new CommonErrorException("20","商品销售价格不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getInventory())){
             throw new CommonErrorException("21","商品库存不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getSales())){
             throw new CommonErrorException("22","商品销量不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getSku1())){
             throw  new CommonErrorException("23","商品sku不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getSkuDesc1())){
             throw new CommonErrorException("24","商品sku描述不能为空");
         }
         if(ObjectUtils.isEmpty(goodsAttr.getSkuPic())){
             throw new CommonErrorException("25","商品sku图不能为空");
         }
    }





}
