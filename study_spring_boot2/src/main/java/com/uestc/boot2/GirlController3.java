package com.uestc.boot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class GirlController3 {
    @Autowired
    private GirlProperties girlProperties;
    //http://127.0.0.1:8082/girl/girl4?id=111
    @RequestMapping(value="/girl4",method=RequestMethod.GET)
    public String sayhello(@RequestParam("id") Integer id) {
        return id+"";
    }
}
