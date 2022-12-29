package com.afourathon.weekly_status_management_ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.afourathon.weekly_status_management_ui.data.entity.Project;
import com.afourathon.weekly_status_management_ui.service.ConsumeProjectRestApiService;

@Controller
public class ProjectController {
	
	@Autowired
	ConsumeProjectRestApiService projectService;
	
	@GetMapping({"/", "/displayAllProjects"})
	public ModelAndView displayAllProjects() {
		ModelAndView modelAndView = new ModelAndView("display-projects");
		List<Project> projects = projectService.getAllProjects();
		modelAndView.addObject("projects", projects);
		
		return modelAndView;
	}
	
	@GetMapping("/displayProject")
	public ModelAndView displayProject(@RequestParam Long projectId) {
		ModelAndView modelAndView = new ModelAndView("display-project");
		Project project = projectService.getProjectById(projectId);
		modelAndView.addObject("project", project);
		
		return modelAndView;
	}
	
}
