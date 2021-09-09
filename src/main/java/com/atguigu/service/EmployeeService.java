package com.atguigu.service;

import com.atguigu.dao.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.atguigu.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yangli
 * @create 2021-08-19 9:48
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }

    /**
     * 员工保存
     * @param employee
     */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    /**
     * 检验用户名是否可用
     * @param empName
     * @return true代表姓名可用，false代表不可用
     */
    public boolean checkUser(String empName) {

        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
//        如果count=0，返回true
        return count == 0;
    }

    //    按照员工id查询员工
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    /**
     * 员工更新
     * @param employee
     */
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);

    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public void deleteBatch(List<Integer> ids) {

        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
//        delete from tbl_employee where emp_id in (1,2,...)
        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }

    /**
     * 按条件查询
     * @return
     */
    public List<Employee> searchEmpByNameOrId(String content) {
        return employeeMapper.selectVaguely(content);
    }
}
