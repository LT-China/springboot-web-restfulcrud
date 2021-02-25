package com.tyb.restfulcrud.controllers;

import com.tyb.restfulcrud.dao.DepartmentDao;
import com.tyb.restfulcrud.dao.EmployeeDao;
import com.tyb.restfulcrud.entities.Department;
import com.tyb.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps", employees);
        //thymeleaf 默认自动拼串-> 到 classpath:/templates/ 寻找/emp/list.html 页面
        return "/emp/list";
    }

    //添加employee页面
    @GetMapping("/empAddPage")
    public String toAddEmployeePage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deptInfo", departments);

        return "/emp/addEmployee";
    }

    @PostMapping("/empAdd")
    public String addEmp(Employee employee){
        System.out.println(employee);
        //redirect 重定向一个地址
        //forward 转发到一个地址
        return "redirect:/emps";
    }

}
