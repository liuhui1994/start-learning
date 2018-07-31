package org.business.system.goods.mapper;

import java.util.List;

import org.business.system.common.configuration.BaseMapper;
import org.business.system.goods.model.GoodsAttr;
import org.business.system.goods.model.dto.GoodsDto;

public interface GoodsAttrMapper extends BaseMapper<GoodsAttr> {
	
	public List<GoodsDto> selectGoodsDtoById(Long goodsId);
}
