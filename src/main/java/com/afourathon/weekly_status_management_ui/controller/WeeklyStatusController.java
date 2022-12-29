package com.afourathon.weekly_status_management_ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.afourathon.weekly_status_management_ui.data.entity.WeeklyStatus;
import com.afourathon.weekly_status_management_ui.data.payloads.request.WeeklyStatusRequest;
import com.afourathon.weekly_status_management_ui.service.ConsumeWeeklyStatusRestApiService;

@Controller
public class WeeklyStatusController {
	
	@Autowired
	ConsumeWeeklyStatusRestApiService weeklyStatusService;
	
	@GetMapping("/displayAllWeeklyStatuses")
	public ModelAndView displayAllWeeklyStatuses() {
		ModelAndView modelAndView = new ModelAndView("display-weekly-statuses");
		List<WeeklyStatus> weeklyStatuses = weeklyStatusService.getAllWeeklyStatuses();
		modelAndView.addObject("weeklyStatuses", weeklyStatuses);
		
		return modelAndView;
	}
	
	@GetMapping("/displayWeeklyStatus")
	public ModelAndView displayWeeklyStatus(@RequestParam Long weeklyStatusId) {
		ModelAndView modelAndView = new ModelAndView("display-weekly-status");
		WeeklyStatus weeklyStatus = weeklyStatusService.getWeeklyStatusById(weeklyStatusId);
		modelAndView.addObject("weeklyStatus", weeklyStatus);
		
		return modelAndView;
	}
	
	@GetMapping("/addWeeklyStatusForm")
	public ModelAndView addWeeklyStatusForm(@RequestParam Long projectId) {
		ModelAndView modelAndView = new ModelAndView("add-weekly-status-form");
		modelAndView.addObject("projectId", projectId);
		
		WeeklyStatusRequest weeklyStatusRequest = new WeeklyStatusRequest();
		modelAndView.addObject("weeklyStatusRequest", weeklyStatusRequest);
		
		return modelAndView;
	}

	@PostMapping("/addWeeklyStatus")
	public String addWeeklyStatus(@RequestParam Long projectId, @ModelAttribute WeeklyStatusRequest weeklyStatusRequest) {
		weeklyStatusService.addWeeklyStatus(projectId, weeklyStatusRequest);
		
		return "redirect:/displayProject?projectId=" + String.valueOf(projectId);
	}
	
	@GetMapping("/updateWeeklyStatusForm")
	public ModelAndView updateWeeklyStatusForm(@RequestParam Long projectId, @RequestParam Long weeklyStatusId) {
		ModelAndView modelAndView = new ModelAndView("update-weekly-status-form");
		
		WeeklyStatus weeklyStatus = weeklyStatusService.getWeeklyStatusByIdAndProjectId(projectId, weeklyStatusId);
		WeeklyStatusRequest weeklyStatusRequest = new WeeklyStatusRequest();
		weeklyStatusRequest.setStatus(weeklyStatus.getStatus());
		weeklyStatusRequest.setHighlight(weeklyStatus.getHighlight());
		weeklyStatusRequest.setRisk(weeklyStatus.getRisk());
		weeklyStatusRequest.setWeeklyEndDate(weeklyStatus.getWeeklyEndDate().toString());
		
		modelAndView.addObject("projectId", projectId);
		modelAndView.addObject("weeklyStatusId", weeklyStatusId);
		modelAndView.addObject("weeklyStatusRequest", weeklyStatusRequest);
		
		return modelAndView;
	}

	@PostMapping("/updateWeeklyStatus")
	public String updateWeeklyStatus(@RequestParam Long projectId, @RequestParam Long weeklyStatusId, @ModelAttribute WeeklyStatusRequest weeklyStatusRequest) {
		weeklyStatusService.updateWeeklyStatus(projectId, weeklyStatusId, weeklyStatusRequest);
		
		return "redirect:/displayProject?projectId=" + String.valueOf(projectId);
	}
	
	@GetMapping("/deleteWeeklyStatus")
	public String deleteWeeklyStatus(@RequestParam Long projectId, @RequestParam Long weeklyStatusId) {
		weeklyStatusService.deleteWeeklyStatusById(projectId, weeklyStatusId);
		
		return "redirect:/displayProject?projectId=" + String.valueOf(projectId);
	}
	
}
