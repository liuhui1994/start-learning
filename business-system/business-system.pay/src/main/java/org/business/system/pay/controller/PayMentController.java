package org.business.system.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pay")
public class PayMentController {
	

	/**
	 * 调用H5支付页面  回显相关支付信息
	 * @param orderNo  订单号
	 * @param paySource 支付请求来源
	 * @return
	 */
	public ModelAndView invokeH5Pay(String  orderNo,String paySource) {
		ModelAndView model = new ModelAndView();
		return model;
	}
	
	
    /**
     * 起调支付接口
     * @param userIdEnc  加密用户信息
     * @param orderNo  订单号
     * @param paySource 支付请求来源
     * @param payChannel 支付渠道
     * @param redictUrl  回调url
     * @return
     */
	@RequestMapping("/index")
	public ModelAndView payToInvokeService(String userIdEnc,String  orderNo,String paySource,String payChannel,String redictUrl) {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	
	

}
