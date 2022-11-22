package com.example.springthymeredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// controller populates and returns thymeleaf templates
// create a method handler which returns "greeting" page
@Controller
public class MyController {
	@GetMapping("/greeting")  // references url `/greeting`
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {  // this returns some data, so use a Model
		model.addAttribute("name", "my dude");  // key-value. copy "name" into greeting.html template
		return "greeting";  // returns a thymeleaf template `greeting.html`
		}

	// TODO: why do some routes appear in MyController, some in MyRestController?
	@GetMapping("/lookup")
	public String lookup() {
		return "project_details";
	}
}
