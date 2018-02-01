package com.springCloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Joeysin on 2017/1/31.
 */
@RestController
@RefreshScope
public class DemoController {
    @Value("${logging.level.org.springframework.security}")
    private String param;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @HystrixCommand(fallbackMethod = "demoFallback")
    public String getDemo() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/", String.class);//这个serviceId不存在所以会走下面的的方法
    }

    @GetMapping("/getMovingParam")
    public String getMovingParam() {
        return param;
    }

    public String demoFallback() {
        return "Hystrix Execute Success_2....";
    }
}
