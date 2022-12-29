package com.afourathon.weekly_status_management_ui.data.payloads.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyStatusRequest {
	
	@NotBlank(message = "Weekly Status cannot be null.")
	private String status;
	
	private String highlight;
	
	private String risk;
	
	@NotBlank(message = "Weekly End Date cannot be null.")
	private String weeklyEndDate;
	
}
