package com.uestc.autowried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloServiceImp;
    @RequestMapping("sayhello")
    public String hello() {
        return helloServiceImp.sayHello();
    }
}
