package com.project.sms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


	@Controller
	public class MainController {
		
		@GetMapping("")
		public String viewMain() {
			return "index";
			
		}


}
