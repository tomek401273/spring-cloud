package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 30/05/2017.
 */

@RestController
public class WebfeignController {

    @Autowired
    Bookservice bookservice;

    @RequestMapping("/f")
    public String index(){
        String message = bookservice.index();
        return "Feign+" + message;
    }

    @RequestMapping("/l")
    public String index2(){
        return "Feign Logic logic Logic";
    }
}
