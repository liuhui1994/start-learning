package org.business.system.cart.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.business.system.cart.model.Cart;
import org.business.system.cart.service.CartService;
import org.business.system.cart.service.CookieCartService;
import org.business.system.common.cloud.auth.OauthCloudService;
import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.UserModelDto;
import org.business.system.common.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private OauthCloudService oauthCloudService;
    @Autowired
    private CookieCartService cookieCartService;

    /**
     * @param
     * @param
     * @return
     */
   /* @ApiOperation(value="通过Id获取商品详情", notes="通过Id获取商品详情" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId", value="商品id",required = true,dataType="Long",paramType="path"),
    })
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseMessage<Cart> goodsDetail(@PathVariable(name="id") Long id, @RequestParam(name="isIncludeAttr") Integer isIncludeAttr) {
        return ResponseMessage.success(cartService.getGoodsById(id,isIncludeAttr));
    }*/
    @ApiOperation(value = "添加商品至购物车", notes = "添加商品至购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "商品id", value = "商品id", required = true, dataType = "path"),
    })
    @RequestMapping(value = "/insert/{itemId}", method = RequestMethod.POST)
    public ResponseMessage<Integer> insertCarts(@PathVariable(name="itemId") Long itemId, String token, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserModelDto user =  oauthCloudService.getUserBytoken(token).getData();
        if (user != null) {
            return ResponseMessage.success(cartService.addItemToCart(itemId, user));
        } else {
            return ResponseMessage.success(cookieCartService.addItemToCart(itemId, request, response));
        }
    }

    @ApiOperation(value = "更新购物车商品数量", notes = "更新商品数量")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "商品id", value = "商品id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "商品数量", value = "商品数量", required = true, dataType = "Long"),
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseMessage<Integer> updateCarts(Long itemId, Long num, String token, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserModelDto user = oauthCloudService.getUserBytoken(token).getData();
        if (user != null) {
            return ResponseMessage.success(cartService.updateCart(itemId, num, user, request, response));
        } else {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("COOKIE_TICKET")){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
            return ResponseMessage.success(cookieCartService.updateCart(itemId, num, request, response));
        }
    }

    @ApiOperation(value = "查看购物车", notes = "查看购物车")
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/cartList", method = RequestMethod.GET)
    public ResponseMessage<Map> queryCars(String token, HttpServletRequest request) throws IOException {
        UserModelDto user = oauthCloudService.getUserBytoken(token).getData();
        Map map = new HashMap<String,Object>();
        int totalPrice = 0;
        List<Cart> cartList;
        if (user == null) {
            cartList = cookieCartService.queryCartList(request);
        } else {
            cartList = cartService.queryCartList(user);
        }
        for (Cart cart : cartList) {
            totalPrice += cart.getSubTotal();
        }
        map.put("cartList", cartList);
        map.put("totalPrice", totalPrice);
        return ResponseMessage.success(map);
    }
    @ApiOperation(value="通过Id列表删除商品", notes="通过Id列表删除商品" )
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids", value="商品id列表",required = true,dataType="List",paramType="path"),
    })
    @RequestMapping(value ="/{ids}", method = RequestMethod.POST)
    public ResponseMessage<Integer> goodsDeletes(@PathVariable(name="ids") List<Long> ids,String token,HttpServletRequest request,HttpServletResponse response) throws IOException {
        UserModelDto user = oauthCloudService.getUserBytoken(token).getData();
        if(user != null){
            return ResponseMessage.success(cartService.deleteCart(ids));
        }else{
            return ResponseMessage.success(cookieCartService.deleteCart(ids,request,response));
        }
    }
}
