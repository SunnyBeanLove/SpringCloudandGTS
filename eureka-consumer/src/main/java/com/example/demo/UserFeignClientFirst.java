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
@FeignClient(name = "hello-service" ,fallback = FeignClientFallback.class)
public interface UserFeignClientFirst {
    @RequestMapping(value = "/substract", method = RequestMethod.GET)
    public String substract(@RequestParam Map<String,String> map);

}
/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 * @author 周立
 */
@Component
class FeignClientFallback implements UserFeignClientFirst{
    @Override
    public String substract(Map<String, String> map) {
        return "默认的结果";
    }

}