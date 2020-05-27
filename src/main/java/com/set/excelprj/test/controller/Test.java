package com.set.excelprj.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class Test {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }


}
