package com.project.sms.faculty;

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

import com.project.sms.Department.Department;
import com.project.sms.Department.DepartmentRepository;

@Controller
public class FacultyController {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository; 

	@GetMapping("/faculty/new")
	public String createFacultyForm(Model m) {
		List<Department> listDepartment = departmentRepository.findAll();
		m.addAttribute("faculty", new Faculty());
		m.addAttribute("listDepartment", listDepartment);
		
		return "newFaculty";
		
	}
	
	
	@PostMapping("/faculty/save")
	public String saveFaculty(Faculty faculty,HttpSession session) {
		facultyRepository.save(faculty);
		session.setAttribute("msg", "Faculty added successfully...");
		return "redirect:/faculty";
		
	}
	
	@GetMapping("/faculty")
	public String listFaculty(Model m) {
		List<Faculty> listFaculty = facultyRepository.findAll();
		m.addAttribute("listFaculty",listFaculty);
		return "faculty";
		
	}
	
	@GetMapping("faculty/edit/{id}")
	public String updateFaculty(@PathVariable("id") Integer id, Model m) {
		List<Department> listDepartment = departmentRepository.findAll();
		Faculty faculty = facultyRepository.findById(id).get();
		
		m.addAttribute("listDepartment", listDepartment);
		m.addAttribute("faculty", faculty);
		return "updateFaculty";
		
	}
	
	@PostMapping("/faculty/update")
	public String updateFaculty(@Valid Faculty faculty, Errors errors, Model m,HttpSession session) {
		
		
			
			facultyRepository.save(faculty);
			session.setAttribute("msg", "Faculty update successfully...");
			return "redirect:/faculty";
		
		
		
	}
	
	@GetMapping("faculty/delete/{id}")
	public String deleteFaculty(@PathVariable("id") Integer id, Model m,HttpSession session) {
		facultyRepository.deleteById(id);
		session.setAttribute("msg", "Faculty delete successfully...");
		return "redirect:/faculty";
}
	
}
