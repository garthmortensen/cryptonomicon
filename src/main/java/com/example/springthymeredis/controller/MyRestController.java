package com.example.springthymeredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springthymeredis.model.Project;
import com.example.springthymeredis.repository.ProjectRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@RestController
public class MyRestController {
	@Autowired
	private ProjectRepository ir;

		@GetMapping("/")
		public String index() {
			return "Greetings from Spring Boot!";
		}
		
		@GetMapping("/something")
		public String something() {
			return "Greetings something!";
		}
		
		@PostMapping(value = "/rest/project/create", consumes= {"*/*"} ) 
		public Project createProject(@RequestBody Project project) {
			System.out.println(project.toString());
			ir.save(project);
			return project;
		}
		
		@GetMapping(value = "/data/{projectId}") 
		public Project getProjectIdData(@PathVariable String projectId) {
			Project iget = null;
			System.out.println("getting item with id "+projectId);
 			try {
				iget = ir.findById(projectId).get();
			} catch (Exception e) {
				System.out.println("Not found ");
			}
 			return iget;
		}
}