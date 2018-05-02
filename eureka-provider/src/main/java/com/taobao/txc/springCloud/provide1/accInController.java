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
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;

    @GetMapping("/substract")
    public String  substract(@RequestParam Map<String, String> map ) {
        try {
            String xid = map.get("xid");
            String strMoney = map.get("strMoney");
            TxcContext.bind(xid, null);
            System.out.println("收到的xid和钱数为" + xid + "**************" + strMoney);
            jdbcTemplate1.update("update ACCOUNT set money = money - ? where id = 1", strMoney);
        } finally {
            TxcContext.unbind();
        }
        return "1";
    }
}
