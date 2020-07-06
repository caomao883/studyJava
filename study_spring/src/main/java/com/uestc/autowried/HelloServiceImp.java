package com.uestc.autowried;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class HelloServiceImp implements HelloService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
