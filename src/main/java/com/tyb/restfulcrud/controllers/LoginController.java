package com.tyb.restfulcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: TYB
 * @Date: 2021/2/5 - 02 - 05 - 15:31
 * @Description: springboot-web-restfulcrud - IntelliJ IDEA
 * @Version: 1.0
 */

@Controller
public class LoginController {
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> message,
                        HttpSession session){
        if(StringUtils.hasLength(username) && "123123".equals(password)){
            session.setAttribute("loginUser", username);
            //为了防止表单重新提交，重定向到dashboard 主页
            //return "dashboard";
            return "redirect:/main-dashboard";
        }else{
            message.put("msg", false);
            return "login";
        }
    }
}
