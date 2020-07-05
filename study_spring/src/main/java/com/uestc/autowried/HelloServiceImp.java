package com.uestc.autowried;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImp implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("say hello");
    }
}
