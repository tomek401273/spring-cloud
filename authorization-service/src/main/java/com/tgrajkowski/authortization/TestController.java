package com.tgrajkowski.authortization;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "/logic")
    public String logigMethod() {
        return "Logic Logic Logic";
    }
}
