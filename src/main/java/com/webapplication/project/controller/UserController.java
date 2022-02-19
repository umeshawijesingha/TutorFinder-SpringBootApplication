package com.webapplication.project.controller;
import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.webapplication.project.model.MediumModel;
import com.webapplication.project.model.SubjectModel;
import com.webapplication.project.model.UserModel;
import com.webapplication.project.model.UserProfileModel;
import com.webapplication.project.service.MediumService;
import com.webapplication.project.service.SubjectService;
import com.webapplication.project.service.UserProfileService;
import com.webapplication.project.service.UserService;

import antlr.collections.List;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private UserProfileService userProfileService;
	 @Autowired
	 private MediumService mediumService;
	
	@GetMapping("/tutor")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers", userService.findAllUsers());
		model.addAttribute("listSubjects", subjectService.findAllSubject());
		
		return "tutor";
	}
	
	@GetMapping("/about")
	public String AboutPage() {
		
		
		return "about_us";
	}
	
	@GetMapping("/medium")
	public String viewMediumPage(Model model) {
		model.addAttribute("listMediums", mediumService.findAllMediums());
		
		
		return "medium";
	}
	
	
	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		//Create model attribute to bind from data
		Collection<SubjectModel> listSubject=subjectService.findAllSubject();
		Collection<MediumModel> listMedium=mediumService.findAllMediums();
		model.addAttribute("listMedium",listMedium);
		model.addAttribute("listSubject",listSubject);
		 UserModel user = new UserModel();
	     model.addAttribute("user", user);
	     
	     return "new_user";
	}
	
	
	
	   UserProfileModel userProfileModel=new UserProfileModel();
	
	 @PostMapping("/saveUser")
	 public String saveUser(@Valid @ModelAttribute("user") UserModel user, BindingResult bindingResult ,Model m) {
	     // save employee to database
	 
		 if (bindingResult.hasErrors()) {
			
			m.addAttribute("listSubject", subjectService.findAllSubject());
            m.addAttribute("listMedium", mediumService.findAllMediums());
			 
	        return "new_user";
	     }else {
		 
	    	 userProfileModel=user.getUserProfile();
	    	 userProfileService.saveProfile(userProfileModel);
	
	    	 userService.saveUser(user);
	      
	    	 return "redirect:/tutor";
		 }
	 }
	
	

	 
	 @GetMapping("/showFormForUpdate/{id}")
	 public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
	  
	  // get employee from the service
	  UserModel user = userService.getUserById(id);
	  
	  // set employee as a model attribute to pre-populate the form
	  model.addAttribute("user", user);
	  return "update_user";
	 }
	 
	 @GetMapping("/deleteUser/{id}")
	 public String deleteUser(@PathVariable (value = "id") int id) {
	  
	  // call delete employee method 
	  this.userService.deleteUser(id);
	  return "redirect:/";
	 }
	 
	 @GetMapping("/subjects")
		public String viewPostPage(Model model) {
			model.addAttribute("listSubjects", subjectService.findAllSubject());
			return "subject";
		}
	 
	 	 
}
