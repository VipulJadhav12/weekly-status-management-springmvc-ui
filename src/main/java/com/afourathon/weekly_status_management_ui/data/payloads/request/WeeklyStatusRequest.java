package com.afourathon.weekly_status_management_ui.data.payloads.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyStatusRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	
	private String highlight;
	
	private String risk;
	
	private String weeklyEndDate;
	
}
