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
			return "You've reached the boring root page.";
		}
		
		@GetMapping(value = "/data/{projectSymbol}")
		public Project getItemIdData(@PathVariable String projectSymbol) {  // http://localhost:8080/data/id1 = object oriented, built by system. this is the RESTful way, where everything is an object
		// public Project getProjectIdData(@RequestParam("projectId") String projectId) {  // http://localhost:8080/data/id1?projectId=id1 = user centric, built by user
			Project iget = null;
			System.out.println("getting project with symbol "+projectSymbol);
 			try {
				iget = ir.findById(projectSymbol).get();
			} catch (Exception e) {
				System.out.println("Not found xxx");
			}
 			return iget;
		}

		// FYI: @PostMapping maps HTTP POST requests to a specific handler method
		// http://localhost:8080/rest/project/create?projectId=id3&projectName=bitcoin&projectSymbol=btc&projectDecimals=10&projectTotalSupply=1000
		@PostMapping(value = "/rest/project/create", consumes= {"*/*"} )
		public Project createProject(@RequestBody Project project) {  // http://localhost:8080/data/id1 this is the RESTful way
			System.out.println(project.toString());
			ir.save(project);
			return project;
		}
		
		// TODO: search by secondary identifer, using @indexer, it seems. Might need to add functionality to Repository
}