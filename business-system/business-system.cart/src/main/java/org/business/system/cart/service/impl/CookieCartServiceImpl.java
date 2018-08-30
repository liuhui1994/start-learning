package org.business.system.cart.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.business.system.cart.model.Cart;
import org.business.system.cart.service.CookieCartService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.goods.GoodsCloudService;
import org.business.system.common.model.dto.GoodsDto;
import org.business.system.common.util.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CookieCartServiceImpl extends BaseServiceImpl<Cart,Long> implements CookieCartService {
    @Autowired
    private GoodsCloudService goodsService;

    private String TK = "COOKIE_TICKET";

    private int maxTime = 60*60*24*3;

    ObjectMapper mapper = new ObjectMapper();
    @Override
    public int addItemToCart(Long itemId, HttpServletRequest request, HttpServletResponse response) throws IOException {
          if(itemId == null || itemId < 0){
              return 0;
          }
            List<Cart> cartList = this.queryCartList(request);
            Cart c = null;
            for ( Cart cart:cartList) {
                if(itemId.longValue() == cart.getItemId().longValue()){
                    cart.setNum(cart.getNum()+1);
                    c = cart;
                    break;
                }
            }
            if(c == null){
                c = new Cart();
                c.setItemId(itemId);
                GoodsDto goodsDto = goodsService.singelGoods(itemId).getData();
                c.setItemImage(goodsDto.getPic());
                c.setItemPrice(goodsDto.getSellPrice());
                c.setItemTitle(goodsDto.getDescrible());
                c.setSku(goodsDto.getSku1());
                c.setNum(1l);
                cartList.add(c);
            }
            CookieUtils.setCookie(response,TK,mapper.writeValueAsString(cartList),maxTime);
            return  1;
    }

    public List<Cart> queryCartList(HttpServletRequest request) throws IOException {
        String values = CookieUtils.getValues(request, TK);
        if(StringUtils.isEmpty(values)){
            return new ArrayList<Cart>();
        }
        return  mapper.readValue(values, mapper.getTypeFactory().constructCollectionType(List.class, Cart.class));
    }

    public int updateCart(Long itemId,Long num,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(itemId == null || itemId < 0 || num == null || num < 0){
            return 0;
        }
        List<Cart> cartList = queryCartList(request);
        if(CollectionUtils.isEmpty(cartList)){
            return 0;
        }
        for (Cart cart:cartList) {
            if(itemId.longValue() == cart.getItemId().longValue()){
                cart.setNum(num);
            }
        }
        CookieUtils.setCookie(response,TK,mapper.writeValueAsString(cartList),maxTime);
        return 1;
    }

    @Override
    public int deleteCart(List<Long> ids,HttpServletRequest request,HttpServletResponse response) throws IOException {
        if(CollectionUtils.isEmpty(ids)){
            return 0;
        }
        List<Cart> cartList = queryCartList(request);
        if(CollectionUtils.isEmpty(cartList)){
            return 0;
    }
        for (Cart cart:cartList) {
            for (Long id:ids) {
                if(cart.getItemId().longValue() == id.longValue()){
                    cartList.remove(cart);
                }
            }
        }
        CookieUtils.setCookie(response,TK,mapper.writeValueAsString(cartList),maxTime);
        return 1;
    }
}
