package org.business.system.common.cloud.goods;

import org.business.system.common.model.dto.GoodsDto;
import org.business.system.common.response.ResponseMessage;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="goods-service",name="goods-service",path="/goods/manager")

public interface GoodsCloudService {
    @RequestMapping(value ="/single/{id}", method = RequestMethod.GET)
    public ResponseMessage<GoodsDto> singelGoods(@PathVariable(name="id") Long id);
}
