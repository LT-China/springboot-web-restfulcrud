package com.tyb.restfulcrud.controllers;

import com.tyb.restfulcrud.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(){
        //thymeleaf 默认自动拼串-> 到 classpath:/templates/ 寻找/emp/list.html 页面
        return "/emp/list";
    }
}
