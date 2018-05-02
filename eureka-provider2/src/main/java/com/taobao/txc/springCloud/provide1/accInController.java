package com.taobao.txc.springCloud.provide1;


import com.taobao.txc.common.TxcContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@Repository
public class accInController {

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @GetMapping("/increase")
    public String increaseMoney(@RequestParam Map<String, String> map ) {
        String xid =  map.get("xid");
        String strMoney =  map.get("strMoney");
        System.out.println("收到的xid和钱数为"+xid+"**************"+strMoney);
        TxcContext.bind(xid,null);
        long startTime=System.currentTimeMillis();   //获取开始时间
        jdbcTemplate1.update("update ACCOUNT set money = money + ? where id = 1",strMoney);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("运行时间： "+(endTime-startTime)+"ms");
        TxcContext.unbind();
        return "1" ;
    }

}
