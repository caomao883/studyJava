package com.kfit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CupSizeController {
    @Value("${cupSize}")
    private String curSize;
    @Value("${age}")
    private Integer age;
    @Value("${context}")
    private String context;
    @RequestMapping("cupSize")
    public String cupSize() {
        return this.context;
    }
}
