package com.project.sms.Department;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.sms.course.Course;
import com.project.sms.faculty.Faculty;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@GetMapping("/department")
	public String listDepartment(Model m) {
		List<Department> listDeaprtment = deptRepo.findAll();
		m.addAttribute("listDeaprtment", listDeaprtment);
		return "department";
		
	}
	
	@GetMapping("/department/new")
	public String addDepartmentForm(Model m) {
		m.addAttribute("department", new Department());
		return "newDepartment";
		
	}
	
	@PostMapping("/department/save")
	public String saveDepartment(Department department,HttpSession session) {
		deptRepo.save(department);
		session.setAttribute("msg", "Department added successfully...");
		return "redirect:/department";
		
	}
	
	@GetMapping("department/edit/{id}")
	public String updateDepartment(@PathVariable("id") Integer id, Model m) {
		
		Department department = deptRepo.findById(id).get();
		
		
		m.addAttribute("department", department);
		return "updateDepartment";
		
	}
	
	@PostMapping("/department/update")
	public String updateDepartment(@Valid Department department, Errors errors, Model m,HttpSession session) {
		
		
			
		deptRepo.save(department);
			session.setAttribute("msg", "Department update successfully...");
			return "redirect:/department";
		
		
		
	}
	
	
	
	@GetMapping("/back")
	public String backToWelcome() {
		return "redirect:/";
	}

}
