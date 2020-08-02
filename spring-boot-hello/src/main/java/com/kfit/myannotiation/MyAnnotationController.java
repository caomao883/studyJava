package com.kfit.myannotiation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAnnotationController {
    @MyTestAnnotation(value = "abc")
    @RequestMapping("annotation")
    public String hello() {
        System.out.println("eeeee");
        return "hello";
    }

}
