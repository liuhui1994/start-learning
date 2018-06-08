package org.business.system.account.service.impl;

import org.springframework.stereotype.Service;

import com.codingapi.tx.netty.service.TxManagerHttpRequestService;
import com.lorne.core.framework.utils.http.HttpUtils;

@Service
public class TxManagerHttpRequestServiceImpl implements TxManagerHttpRequestService{

    @Override
    public String httpGet(String url) {
//        System.out.println("httpGet-start");
//        String res = HttpUtils.get(url);
//        System.out.println("httpGet-end");
        return null;
    }

    @Override
    public String httpPost(String url, String params) {
//        System.out.println("httpPost-start");
//        String res = HttpUtils.post(url,params);
//        System.out.println("httpPost-end");
        return null;
    }
}
