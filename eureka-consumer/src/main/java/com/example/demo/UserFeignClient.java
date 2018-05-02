package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author : JHL
 * @date :2018/4/25
 * @Descpricion：
 */
@FeignClient(name = "account-service" ,fallback = FeignClientFallback2.class)
public interface UserFeignClient {
    @RequestMapping(value = "/increase", method = RequestMethod.GET)
    public String increase(@RequestParam Map<String, String> map);

}

@Component
class FeignClientFallback2 implements UserFeignClient{

    @Override
    public String increase(Map<String, String> map) {
        return "默认的结果2";
    }

}