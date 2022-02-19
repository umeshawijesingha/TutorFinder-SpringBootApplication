package com.project.sms.subject;

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
import com.project.sms.Lecturer.Lecturer;
import com.project.sms.Lecturer.LecturerRepository;
import com.project.sms.Student.Student;
import com.project.sms.Student.StudentRepository;
import com.project.sms.faculty.Faculty;

@Controller
public class SubjectController {
	
	
	@Autowired
	private LecturerRepository lecturerRepo;
	@Autowired
	private SubjectRepository subjectRepository; 
	
	@GetMapping("/subject/new")
	public String createSubjectForm(Model m) {
		List<Lecturer> listLecturer = lecturerRepo.findAll();
		m.addAttribute("subject", new Subject());
		m.addAttribute("listLecturer", listLecturer);
		
		return "newSubject";
		
	}
	
	@GetMapping("/subject")
	public String listSubject(Model m) {
		List<Subject> listSubject = subjectRepository.findAll();
		m.addAttribute("listSubject",listSubject);
		return "subject";
		
	}
	
	@PostMapping("/subject/save")
	public String saveSubject(Subject subject,HttpSession session) {
		subjectRepository.save(subject);
		session.setAttribute("msg", "Subject added successfully...");
		return "redirect:/subject";
		
	}

	@GetMapping("subject/edit/{id}")
	public String updateSubject(@PathVariable("id") Integer id, Model m) {
		
		Subject subject = subjectRepository.findById(id).get();
		m.addAttribute("subject", subject);
		return "updateSubject";
		
	}
	
	@PostMapping("/subject/update")
	public String updateSubject(@Valid Subject subject, Errors errors, Model m,HttpSession session) {
		
		
			
		subjectRepository.save(subject);
			session.setAttribute("msg", "Subject update successfully...");
			return "redirect:/subject";
		
		
		
	}
	
	@GetMapping("subject/delete/{id}")
	public String deleteSubject(@PathVariable("id") Integer id, Model m,HttpSession session) {
		subjectRepository.deleteById(id);
		session.setAttribute("msg", "Subject delete successfully...");
		return "redirect:/subject";
}

}
