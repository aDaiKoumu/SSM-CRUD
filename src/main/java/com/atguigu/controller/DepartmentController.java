package com.atguigu.controller;


import com.atguigu.pojo.Department;
import com.atguigu.pojo.Msg;
import com.atguigu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Yangli
 * @create 2021-08-20 16:21
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /**
     * 返回所有的部门信息
     *
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> depts = departmentService.getDepts();
        return Msg.success().add("depts",depts);
    }
}
