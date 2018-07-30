package org.business.system.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.business.system.common.response.ResponseMessage;
import org.business.system.goods.model.Goods;
import org.business.system.goods.model.dto.GoodsDto;
import org.business.system.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value="通过Id获取商品详情", notes="通过Id获取商品详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="商品id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseMessage<GoodsDto> goodsDetail(@PathVariable(name="id") Long id) {
        return ResponseMessage.success(goodsService.getGoodsById(id));
    }


    /*@ApiOperation(value="通过Id删除商户", notes="通过Id删除商户" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="商户id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public ResponseMessage<Integer> goodsDelete(@PathVariable(name="id") Long id) {
        return ResponseMessage.success(goodsService.deletegoodsById(id));
    }*/

    @ApiOperation(value="通过Id列表删除商品", notes="通过Id列表删除商品" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids", value="商品id列表",required = true,dataType="List",paramType="path"),
    })
    @RequestMapping(value ="/{ids}", method = RequestMethod.POST)
    public ResponseMessage<Integer> goodsDeletes(@PathVariable(name="ids") List<Long> ids) {
        return ResponseMessage.success(goodsService.deleteGoodsByIds(ids));
    }



    @ApiOperation(value="新增商品", notes="新增商品" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="goods", value="商品id",required = true,dataType="goods"),
    })
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseMessage<GoodsDto> insertgoods(@RequestBody GoodsDto goodsDto){
        return ResponseMessage.success(goodsService.saveGoods(goodsDto));
    }


    @ApiOperation(value="编辑商品", notes="商品活动" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="goods", value="商品id",required = true,dataType="goods"),
    })
    @RequestMapping(value ="/update", method = RequestMethod.POST)
    public ResponseMessage<GoodsDto> updategoods(
            @RequestBody GoodsDto goodsDto) {
        return ResponseMessage.success(goodsService.updateGoods(goodsDto));
    }
    @ApiOperation(value="获取商品列表", notes="获取商品列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goods", value = "商品查询对象", required = false, dataType = "goods"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),

    })
    @RequestMapping(value="/goodslist", method= RequestMethod.POST)
    public ResponseMessage<PageInfo<Goods>> list(
            @RequestBody GoodsDto goodsDto,
            @RequestParam(name="pageNum") Integer pageNum,
            @RequestParam(name="pageSize",defaultValue="1") Integer pageSize,
            @RequestParam(name="orderBy",defaultValue="id") String orderBy){
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Goods> goodsList = goodsService.getGoodsListByDto(goodsDto);
        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList);
        return ResponseMessage.success(pageInfo);

    }
}
