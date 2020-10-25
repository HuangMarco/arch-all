package com.huangshi.wuji.controller;

import com.huangshi.wuji.constant.RedisConstants;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = RedisConstants.API_Mapping)
public class DefaultController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name){
        return "hello";
    }

}
