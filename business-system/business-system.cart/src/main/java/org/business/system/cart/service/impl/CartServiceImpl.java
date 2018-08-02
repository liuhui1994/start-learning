package org.business.system.cart.service.impl;

import org.business.system.cart.mapper.CartMapper;
import org.business.system.cart.model.Cart;
import org.business.system.cart.service.CartService;
import org.business.system.common.base.service.impl.BaseServiceImpl;
import org.business.system.common.cloud.goods.GoodsCloudService;
import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl extends BaseServiceImpl<Cart,Long> implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodsCloudService goodsService;
    @Override
    public int addItemToCart(Long itemId,UserModel user) {
       int result = 0;
        Cart cart = new Cart();
        cart.setItemId(itemId);
        cart.setUserId(user.getId());
        Cart selectCart = cartMapper.selectOne(cart);
        if(selectCart != null){
            selectCart.setNum(selectCart.getNum()+1);
            selectCart.setModifier(user.getNickName());
            selectCart.setModifyDate(new Date());
            result= cartMapper.updateByPrimaryKey(cart);
        }else{
            GoodsDto goodsDto = goodsService.singelGoods(itemId).getData();
            cart.setNum(1l);
            cart.setItemTitle(goodsDto.getDescrible());
            cart.setItemPrice(goodsDto.getSellPrice());
            cart.setSku(goodsDto.getSku1());
            cart.setItemImage(goodsDto.getPic());
            result = cartMapper.insertSelective(cart);
        }
        return result;
    }

    @Override
    public int updateCart(Long itemId, Long num, UserModel user, HttpServletRequest request, HttpServletResponse response) {
        List<Cart> cartList = this.queryCartList(user);
        if(CollectionUtils.isEmpty(cartList)){
            return 0;
        }
        for (Cart cart:cartList) {
            if(cart.getItemId().longValue() == itemId.longValue()){
                cart.setNum(num);
                cart.setModifyDate(new Date());
                return  cartMapper.updateByPrimaryKey(cart);
            }
        }
        return 0;
    }

    @Override
    public List<Cart> queryCartList(UserModel user){
        Cart cart = new Cart();
        cart.setUserId(user.getId());
       return cartMapper.select(cart);
    }

    @Override
    public int deleteCart(List<Long> ids) {
        Example example = new Example(Cart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("userId",ids );
        return cartMapper.deleteByExample(example);
    }

}
