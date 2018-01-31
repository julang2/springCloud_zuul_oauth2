package com.springCloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joeysin on 2017/1/31.
 */
@RestController
public class DemoController {
    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getDemo(){
        return "SUCCESS";
    }
}
