package com.uestc.boot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class GirlController2 {
    @Autowired
    private GirlProperties girlProperties;
    //http://127.0.0.1:8082/girl/100/girl2
    @RequestMapping(value="/{id}/girl2",method=RequestMethod.GET)
    public String sayhello(@PathVariable("id") Integer id) {
        return id+"";
    }
}
