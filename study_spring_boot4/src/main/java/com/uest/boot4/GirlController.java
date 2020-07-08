package com.uest.boot4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController {
    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value={"girl2","girl3"},method = RequestMethod.GET)
    public String sayhello() {
        return "cupSize:" + this.girlProperties.getCupSize() + ", age: " + this.girlProperties.getAge();
    }
}
