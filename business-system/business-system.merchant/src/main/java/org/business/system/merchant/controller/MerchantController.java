package org.business.system.merchant.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.business.system.common.response.ResponseMessage;
import org.business.system.merchant.model.Merchant;
import org.business.system.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @ApiOperation(value="通过Id获取商户详情", notes="通过Id获取商户详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="商户id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseMessage<Merchant> merchantDetail(@PathVariable(name="id") Long id) {
        return ResponseMessage.success(merchantService.getMerchantById(id));
    }


    /*@ApiOperation(value="通过Id删除商户", notes="通过Id删除商户" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="商户id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public ResponseMessage<Integer> merchantDelete(@PathVariable(name="id") Long id) {
        return ResponseMessage.success(merchantService.deleteMerchantById(id));
    }*/

    @ApiOperation(value="通过Id列表删除商户", notes="通过Id列表删除商户" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids", value="商户id列表",required = true,dataType="List",paramType="path"),
    })
    @RequestMapping(value ="/{ids}", method = RequestMethod.POST)
    public ResponseMessage<Integer> merchantDeletes(@PathVariable(name="ids") List<Long> ids) {
        return ResponseMessage.success(merchantService.deleteMerchantByIds(ids));
    }



    @ApiOperation(value="新增商户", notes="新增商户" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="merchant", value="商户id",required = true,dataType="Merchant"),
    })


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseMessage<Merchant> saveMerchant(@RequestBody Merchant merchant){
        return ResponseMessage.success(merchantService.saveMerchant(merchant));
    }


    @ApiOperation(value="编辑商户", notes="商户活动" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="merchant", value="商户id",required = true,dataType="merchant"),
    })
    @RequestMapping(value ="/update", method = RequestMethod.POST)
    public ResponseMessage<Merchant> updateActivity(
            @RequestBody Merchant merchant) {
        return ResponseMessage.success(merchantService.updateMerchant(merchant));
    }
    @ApiOperation(value="获取商户列表", notes="获取商户列表" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchant", value = "商户查询对象", required = false, dataType = "Merchant"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),

    })
    @RequestMapping(value="/merchantlist", method= RequestMethod.POST)
    public ResponseMessage<PageInfo<Merchant>> list(
            @RequestBody Merchant merchant,
            @RequestParam(name="pageNum") Integer pageNum,
            @RequestParam(name="pageSize",defaultValue="1") Integer pageSize,
            @RequestParam(name="orderBy",defaultValue="id") String orderBy){
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<Merchant> merchantList = merchantService.getMerchantList(merchant);
        PageInfo<Merchant> pageInfo = new PageInfo<Merchant>(merchantList);
        return ResponseMessage.success(pageInfo);

    }
}
