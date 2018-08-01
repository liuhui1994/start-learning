package org.business.system.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pay")
public class PayMentController {
	
	/**
	 * 调用H5支付页面  回显相关支付信息
	 * @return
	 */
	public ModelAndView invokeH5Pay(String  orderNo) {
		ModelAndView model = new ModelAndView();
		return model;
	}
	
	
	

}
