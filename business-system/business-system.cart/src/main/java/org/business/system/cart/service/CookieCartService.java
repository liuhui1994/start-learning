package org.business.system.cart.service;

import org.business.system.cart.model.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface CookieCartService {
    int addItemToCart(Long itemId, HttpServletRequest request, HttpServletResponse response) throws IOException;

    List<Cart> queryCartList(HttpServletRequest request) throws IOException;

    int updateCart(Long itemId,Long num,HttpServletRequest request,HttpServletResponse response) throws IOException;

    int deleteCart(List<Long> ids,HttpServletRequest request,HttpServletResponse response) throws IOException;
}
