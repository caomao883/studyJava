package com.uestc.autowried;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloController {
    @Autowired
    private HelloService helloService;

    public void hello() {
        helloService.sayHello();
    }
}
