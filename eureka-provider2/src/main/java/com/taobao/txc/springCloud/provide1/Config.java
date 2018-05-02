package com.taobao.txc.springCloud.provide1;


import com.taobao.txc.client.aop.TxcTransactionScaner;
import com.taobao.txc.datasource.cobar.TxcDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Config {


    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public com.taobao.txc.datasource.cobar.TxcDataSource secondaryDataSource()
    {
        return new TxcDataSource();
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(
            @Qualifier("secondaryDataSource") javax.sql.DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }


    //定义声明式事务，要想让事务annotation感知的话，要在这里定义一下
    @Bean(name = "txcScanner")
    @ConfigurationProperties(prefix="aluser")
    public TxcTransactionScaner txcTransactionScaner()
    {
        //xxxx填写txc的逻辑组名
        return  new TxcTransactionScaner("provider2","xxxx",1,"https://test-cs-gts.aliyuncs.com");
    }

}
