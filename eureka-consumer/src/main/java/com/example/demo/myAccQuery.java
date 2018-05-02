package com.example.demo;

import com.taobao.txc.client.aop.annotation.TxcTransaction;
import com.taobao.txc.common.TxcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : JHL
 * @date :2018/4/25
 * @Descpricion：
 */
@Service
public class myAccQuery {

    @Autowired
    private UserFeignClientFirst userFeignClientFirst;
    @Autowired
    private UserFeignClient userFeignClient;

    @TxcTransaction(timeout = 1000 * 1200)
    public String transferMap(String money) {
        String xid = TxcContext.getCurrentXid();
        Map<String,String> map = new HashMap<>(2);
        map.put("xid",xid);
        map.put("strMoney","132");
        userFeignClientFirst.substract(map);
        userFeignClient.increase(map);
        return "1";
    }

}
