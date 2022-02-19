package com.project.sms.course;

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
import com.project.sms.Student.Student;
import com.project.sms.Student.StudentRepository;
import com.project.sms.faculty.Faculty;

@Controller
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository; 
	
	@GetMapping("/course/new")
	public String createCourseForm(Model m) {
		List<Student> listStudent = studentRepository.findAll();
		m.addAttribute("course", new Course());
		m.addAttribute("listStudent", listStudent);
		
		return "newCourse";
		
	}
	
	@GetMapping("/course")
	public String listCourse(Model m) {
		List<Course> listCourse = courseRepository.findAll();
		m.addAttribute("listCourse",listCourse);
		return "course";
		
	}
	
	@PostMapping("/course/save")
	public String saveCourse(Course course,HttpSession session) {
		courseRepository.save(course);
		session.setAttribute("msg", "Course added successfully...");
		return "redirect:/course";
		
	}

	@GetMapping("course/edit/{id}")
	public String updateCourse(@PathVariable("id") Integer id, Model m) {
		
		Course course = courseRepository.findById(id).get();
		m.addAttribute("course", course);
		return "updateCourse";
		
	}
	
	@PostMapping("/course/update")
	public String updateCourse(@Valid Course course, Errors errors, Model m,HttpSession session) {
		
		
			
		courseRepository.save(course);
			session.setAttribute("msg", "Course update successfully...");
			return "redirect:/course";
		
		
		
	}
	
	@GetMapping("course/delete/{id}")
	public String deleteCourse(@PathVariable("id") Integer id, Model m,HttpSession session) {
		courseRepository.deleteById(id);
		session.setAttribute("msg", "Course delete successfully...");
		return "redirect:/course";
}

}
