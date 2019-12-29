package com.springboot.community.controler;

/**
 * ClassName:HelloController
 * Package:com.springboot.community.controler
 * Descripetion:
 *
 * @Date:2019/12/28 15:14
 * @Author: 李一鹏
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
