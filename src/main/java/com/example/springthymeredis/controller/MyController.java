package com.example.springthymeredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springthymeredis.model.Project;

// controller populates and returns thymeleaf templates
// create a method handler which returns "greeting" page
// @Controller prepares a model map with data and selects which view to render
// it allows template expressions to read model variables
@Controller
public class MyController {
	@GetMapping("/greeting")  // references url `/greeting`
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {  // this returns some data, so use a Model
		model.addAttribute("name", "my dude");  // key-value. copy "name" into greeting.html template
		return "greeting.html";  // returns thymeleaf template `greeting.html`
		}

	// routes appearing in @Controller run through thymeleaf template engine and return dynamic htmls, @RestController routes return REST
	// @GetMapping is a shortcut for @RequestMapping(method = RequestMethod.GET). Its newer and supports consumes
	@GetMapping("/lookup")
	public String lookup() {
		return "project_details.html";
	}

	@GetMapping("/submit")
	public String submit() {
		return "submit.html";
	}

	@GetMapping("/project_details")
	public String project_details(@RequestParam(name="name", required=false, defaultValue="") String name, Model model) {
		model.addAttribute("name", "my dude");
		return "project_details.html";
	}

}
