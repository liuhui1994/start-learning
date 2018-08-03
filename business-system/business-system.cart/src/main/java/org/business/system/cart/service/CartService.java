package org.business.system.cart.service;

import org.business.system.cart.model.Cart;
import org.business.system.common.base.service.BaseService;
import org.business.system.common.model.UserModel;
import org.business.system.common.model.dto.UserModelDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService extends BaseService<Cart,Long> {
    int addItemToCart(Long itemId, UserModelDto user);

    int updateCart(Long itemId, Long num, UserModelDto user, HttpServletRequest request, HttpServletResponse response);
     List<Cart> queryCartList(UserModelDto user);

    int deleteCart(List<Long> ids);
}
