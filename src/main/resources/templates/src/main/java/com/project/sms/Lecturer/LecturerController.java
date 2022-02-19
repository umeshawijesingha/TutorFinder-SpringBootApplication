package com.project.sms.Lecturer;

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
import com.project.sms.subject.Subject;
import com.project.sms.subject.SubjectRepository;



@Controller
public class LecturerController {

	@Autowired
	private LecturerRepository lecturerRepo;
	@Autowired
	private SubjectRepository subjectRepostiory;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@GetMapping("/lecturer")
	public String listLecturer(Model m) {
		List<Lecturer> listLecturer = lecturerRepo.findAll();
		m.addAttribute("listLecturer", listLecturer);
		return "lecturer";
		
	}
	
	@GetMapping("/lecturer/new")
	public String addLecturerForm(Model m) {
		List<Subject> listSubject = subjectRepostiory.findAll();
		m.addAttribute("lecturer", new Lecturer());
		m.addAttribute("listSubject", listSubject);
		return "newLecturer";
	}
	
	@PostMapping("/lecturer/save")
	public String saveLecturer(@Valid Lecturer lecturer, Errors errors, Model m,HttpSession session) {
		
		if(errors.hasErrors()) {
			return "newLecturer";
		}
		else{
			
			lecturerRepo.save(lecturer);
			session.setAttribute("msg", "Lecturer added successfully...");
			return "redirect:/lecturer";
		}
		
		
	}
	
	@GetMapping("/back_main")
	public String backToWelcome() {
		return "redirect:/";
	}
 
	@GetMapping("lecturer/edit/{id}")
		public String updateLecturer(@PathVariable("id") Integer id, Model m) {
		Lecturer lecturer = lecturerRepo.findById(id).get();
		List<Subject> listSubject = subjectRepostiory.findAll();
		m.addAttribute("listSubject", listSubject);
		m.addAttribute("lecturer", lecturer);
		return "updateLecturer";
	}
	
	@PostMapping("/lecturer/update")
	public String updateLecturer(@Valid Lecturer lecturer, Errors errors, Model m,HttpSession session) {
		
		
			
			lecturerRepo.save(lecturer);
			session.setAttribute("msg", "Lecturer update successfully...");
			return "redirect:/lecturer";
		
		
		
	}
	
	
	@GetMapping("lecturer/delete/{id}")
	public String deleteLecturer(@PathVariable("id") Integer id, Model m,HttpSession session) {
		lecturerRepo.deleteById(id);
		session.setAttribute("msg", "Lecturer delete successfully...");
		return "redirect:/lecturer";
}
}
