package org.business.system.notice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codingapi.tx.config.service.TxManagerTxUrlService;

//@Service
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService{


//    @Value("${tm.manager.url}")
    private String url;

    @Override
    public String getTxUrl() {
//        System.out.println("load tm.manager.url ");
        return url;
    }

}
