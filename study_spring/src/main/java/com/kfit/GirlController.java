package com.kfit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {
    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping("girl2")
    public String sayhello() {
        return "cupSize:" + this.girlProperties.getCupSize() + ", age: " + this.girlProperties.getAge();
    }
}
