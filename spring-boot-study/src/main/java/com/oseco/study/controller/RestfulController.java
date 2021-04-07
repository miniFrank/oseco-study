package com.oseco.study.controller;

import com.oseco.study.domain.Zoo;
import org.springframework.web.bind.annotation.*;

/**
 * 如何设计Restful api，是一种设计风格而非标准
 */
@RestController
@RequestMapping(value = "zoos")
public class RestfulController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String get(@PathVariable("id") String id) {
        return id + " at mountain";
   }

    @RequestMapping(method = RequestMethod.POST)
    // todo:规律性呈现400-bad request现象，需要研究
    public Object create(@RequestBody Zoo zoo) {
        return zoo;
    }
}
