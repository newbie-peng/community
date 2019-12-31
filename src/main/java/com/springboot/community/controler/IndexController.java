package com.springboot.community.controler;

/**
 * ClassName:HelloController
 * Package:com.springboot.community.controler
 * Descripetion:
 *
 * @Date:2019/12/28 15:14
 * @Author: 李一鹏
 */

import com.springboot.community.model.User;
import com.springboot.community.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName());
            if (cookie.getName().equals("token")){
                String value = cookie.getValue();
                User user = UserService.selectBy(value);
                if (user!=null){
                    request.getSession().setAttribute("user",user);
                }
            }
        }
        return "index";
    }
}
