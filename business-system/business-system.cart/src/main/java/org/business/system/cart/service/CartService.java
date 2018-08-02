package org.business.system.cart.service;

import org.business.system.cart.model.Cart;
import org.business.system.common.base.service.BaseService;
import org.business.system.common.model.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService extends BaseService<Cart,Long> {
    int addItemToCart(Long itemId, UserModel user);

    int updateCart(Long itemId, Long num, UserModel user, HttpServletRequest request, HttpServletResponse response);
     List<Cart> queryCartList(UserModel user);

    int deleteCart(List<Long> ids);
}
