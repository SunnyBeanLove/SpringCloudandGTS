package com.example.demo;

import com.taobao.txc.client.aop.TxcTransactionScaner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    //定义声明式事务，要想让事务annotation感知的话，要在这里定义一下
    @Bean(name = "txcScanner")
    @ConfigurationProperties(prefix="aluser")
    public TxcTransactionScaner txcTransactionScaner()
    {
        //xxxx填写txc的逻辑组名
        return  new TxcTransactionScaner("consumer","xxxx",1,"https://test-cs-gts.aliyuncs.com");
    }

}
