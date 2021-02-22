package com.tyb.restfulcrud.controllers;

import com.tyb.restfulcrud.dao.EmployeeDao;
import com.tyb.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps", employees);
        //thymeleaf 默认自动拼串-> 到 classpath:/templates/ 寻找/emp/list.html 页面
        return "/emp/list";
    }
}
