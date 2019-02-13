package com.spring.controller;

import com.spring.dao.DepartmentDao;
import com.spring.dao.EmployeeDao;
import com.spring.entities.Department;
import com.spring.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpsController {
	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DepartmentDao departmentDao;

	@GetMapping("/emps")
	public String empList(Model model){
		// 查询所有员工
		Collection<Employee> employees = employeeDao.getAll();
		model.addAttribute("emps",employees);
		/*public static final String DEFAULT_PREFIX = "classpath:/templates/";
		public static final String DEFAULT_SUFFIX = ".html";*/
		return "emp/list";
	}

	@GetMapping("/emp")
	public String toAddPage(Model model){
		// 查询部门
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts",departments);
		return "emp/add";
	}

	// 添加员工
	@PostMapping("/emp")
	public String addEmp(Employee employee){
		employeeDao.save(employee);
		System.out.println("添加:"+employee);
		return "redirect:/emps";
	}

	@GetMapping("/emp/{id}")
	public String editEmp(@PathVariable("id") Integer id, Model model){
		// 查询单条
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp",employee);
		// 查询部门
		Collection<Department> departments = departmentDao.getDepartments();
		model.addAttribute("depts",departments);
		return "emp/add";
	}

	@PutMapping("/emp")
	public String editEmpDone(Employee employee){
		employeeDao.save(employee);
		System.out.println("修改:"+employee);
		return "redirect:/emps";
	}

	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
