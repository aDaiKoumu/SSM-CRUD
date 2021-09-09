package com.atguigu.service;

import com.atguigu.dao.DepartmentMapper;
import com.atguigu.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangli
 * @create 2021-08-20 16:24
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
