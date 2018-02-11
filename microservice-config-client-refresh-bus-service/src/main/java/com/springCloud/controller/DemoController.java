package com.springCloud.controller;

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
    public String getDemo() {
        return "SUCCESS_3";
    }

    @GetMapping("/getMovingParam")
    @PreAuthorize("permitAll()")
    public String getMovingParam() {
        return param + "_3";
    }

}
