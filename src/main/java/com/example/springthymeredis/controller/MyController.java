package com.example.springthymeredis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// this controller populates thymeleaf
@Controller
public class MyController {
	// create a method handler which returns "greeting"
	@GetMapping("/greeting")  // reference url /greeting
	// TODO: fix next line to match our actual Model data. Some of these variables need updating. There is no "name" as far as i know
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {  // this returns some data, so use a Model
		model.addAttribute("name", "Garth");  // key-value. copy "name" into greeting.html template
		return "greeting";  // returns a thymeleaf template `greeting.html`
		}

	// TODO: why do some routes appear in MyController, some in MyRestController?
	@GetMapping("/lookup")
	public String lookup() {
		return "project_details";
	}
}
