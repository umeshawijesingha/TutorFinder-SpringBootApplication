package com.project.sms.Student;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.sms.Department.Department;
import com.project.sms.Department.DepartmentRepository;
import com.project.sms.course.Course;
import com.project.sms.course.CourseRepository;



@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private DepartmentRepository departmentRepostiory;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/student")
	public String listStudent(Model m) {
		List<Student> listStudent = studentRepo.findAll();
		m.addAttribute("listStudent", listStudent);
		return "student";
		
	}
	
	@GetMapping("/student/new")
	public String addStudentForm(Model m) {
		List<Department> listDepartment=departmentRepostiory.findAll();
		List<Course> listCourse = courseRepository.findAll();
;		m.addAttribute("student", new Student());
		m.addAttribute("listDepartment", listDepartment);
		m.addAttribute("listCourse", listCourse);
		return "newStudent";
	}
	
	@PostMapping("/student/save")
	public String saveStudent(@Valid Student student, Errors errors, Model m,HttpSession session) {
		
		if(errors.hasErrors()) {
			return "newStudent";
		}
		else{
			
			studentRepo.save(student);
			session.setAttribute("msg", "Student added successfully...");
			return "redirect:/student";
		}
		
		
	}
	
	@GetMapping("/backWelcome")
	public String backToWelcome() {
		return "redirect:/";
	}
 
	@GetMapping("student/edit/{id}")
		public String updateStudent(@PathVariable("id") Integer id, Model m) {
			Student student = studentRepo.findById(id).get();
			m.addAttribute("student", student);
			List<Course> listCourse = courseRepository.findAll();
			List<Department> listDepartment=departmentRepostiory.findAll();
			m.addAttribute("listDepartment", listDepartment);
			m.addAttribute("listCourse", listCourse);
			return "updateStudent";
	}
	
	@PostMapping("/student/update")
	public String updateStudent(@Valid Student student, Errors errors, Model m,HttpSession session) {
		
		
			
			studentRepo.save(student);
			session.setAttribute("msg", "Student update successfully...");
			return "redirect:/student";
		
		
		
	}
	
	
	@GetMapping("student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model m,HttpSession session) {
		studentRepo.deleteById(id);
		session.setAttribute("msg", "Student delete successfully...");
		return "redirect:/student";
}
}
