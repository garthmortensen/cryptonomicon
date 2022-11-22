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

// REST handles GET/POST/etc requests
@RestController
public class MyRestController {
	@Autowired
	private ProjectRepository ir;

		// FYI: @GetMapping maps HTTP GET requests to a specific handler method
		@GetMapping("/")
		public String index() {
			return "Greetings from Spring Boot!";
		}
		
		@GetMapping("/something")
		public String something() {
			return "Greetings something!";
		}
		
		// FYI: @PostMapping maps HTTP POST requests to a specific handler method
		// http://localhost:8080/rest/project/create?projectId=id3&projectName=bitcoin&projectSymbol=btc&projectDecimals=10&projectTotalSupply=1000
		@PostMapping(value = "/rest/project/create", consumes= {"*/*"} )
		public Project createProject(@RequestBody Project project) {
			System.out.println(project.toString());
			ir.save(project);
			return project;
		}
		
		// XXX: is this endpoint ok? http://localhost:8080/data/id1?projectId=id1
		// XXX: changing from this fixed GET: public Project getItemIdData(@PathVariable String projectId) {
		@GetMapping(value = "/data/{projectId}")
		public Project getProjectIdData(@RequestParam("projectId") String projectId) {
			Project iget = null;
			System.out.println("getting project with id "+projectId);
 			try {
				iget = ir.findById(projectId).get();
			} catch (Exception e) {
				System.out.println("Not found xxx");
			}
 			return iget;
		}
		
		// TODO: search by secondary identifer
		// https://docs.spring.io/spring-data/jpa/docs/1.11.1.RELEASE/reference/html/#jpa.query-methods.query-creation
}