package com.springboot.community.controler;

import com.springboot.community.dto.AccessTokenDTO;
import com.springboot.community.dto.GithubUser;
import com.springboot.community.model.User;
import com.springboot.community.provider.GithubProvider;
import com.springboot.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * ClassName:AuthorizeController
 * Package:com.springboot.community.controler
 * Descripetion:
 *
 * @Date:2019/12/29 20:01
 * @Author: 李一鹏
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientid;
    @Value("${github.client.secret}")
    private String clientsecret;
    @Value("${github.redirect.uri}")
    private String redirecturi;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
//                            HttpServletRequest request,
                            HttpServletResponse response){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientid);
        accessTokenDTO.setClient_secret(clientsecret);
        accessTokenDTO.setRedirect_uri(redirecturi);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubuser = githubProvider.getUser(accessToken);
        if (githubuser !=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubuser.getName());
            user.setAccountId(String.valueOf(githubuser.getId()));
            Date date = new Date();
            date.setTime(System.currentTimeMillis());
            System.out.println(new SimpleDateFormat().format(date));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGetModified(user.getGmtCreate());
            UserService.insert(user);
            response.addCookie(new Cookie("token",token));
            //登陆成功 执行这里  写cookie  和 session
//            request.getSession().setAttribute("user", githubuser);
            return "redirect:/";
        }else{
            //登陆失败 执行这里  重新登陆
            return "redirect:/";
        }
//        System.out.println(user.getName());
//        return "index";
    }
}
