package com.tyb.restfulcrud.controllers;

import com.tyb.restfulcrud.dao.DepartmentDao;
import com.tyb.restfulcrud.dao.EmployeeDao;
import com.tyb.restfulcrud.entities.Department;
import com.tyb.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //SpringMVC 自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字和JavaBeanr入参的对象里面的属性名一致
    @PostMapping("/empAdd")
    public String addEmp(Employee employee){
        System.out.println(employee);
        //保存员工
        employeeDao.save(employee);
        //返回到员工页面
        //redirect 重定向一个地址
        //forward 转发到一个地址
        return "redirect:/emps";
    }

    //员工修改页面，查出当前员工信息，在页面显示
    @GetMapping("/emps/{id}")
    public String toEditEmpInfoPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deptInfo", departments);

//        System.out.println("ID:" + id + "-----" + employee.getDepartment().getDepartmentName() +  "\n" + employee + "\n" + departments);
        return "/emp/editEmpInfo";
    }

    //员工更新的收据
    @PutMapping("/empUpdate")
    public String toUpdateEmp(Employee employee){
//        System.out.print("修改后的员工信息---" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emps/{id}")
    public String toDeleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
