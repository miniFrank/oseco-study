package com.oseco.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NonRestfulController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String words() {
        return "hello,world123";
    }
}
