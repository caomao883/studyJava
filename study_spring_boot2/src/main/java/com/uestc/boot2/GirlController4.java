package com.uestc.boot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GirlController4 {
    @Autowired
    private GirlProperties girlProperties;
    //http://127.0.0.1:8082/girl/girl5?id=111
    @RequestMapping(value="/girl5",method=RequestMethod.GET)
    public String sayhello(@RequestParam(value = "id",required = false, defaultValue = "0") Integer id) {
        return id+"";
    }
}
