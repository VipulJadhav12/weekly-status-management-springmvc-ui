package com.afourathon.weekly_status_management_ui.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.afourathon.weekly_status_management_ui.data.entity.WeeklyStatus;
import com.afourathon.weekly_status_management_ui.data.payloads.request.WeeklyStatusRequest;


@Service
public class ConsumeWeeklyStatusRestApiService {

	@Autowired
	RestTemplate restTemplate;

	public List<WeeklyStatus> getAllWeeklyStatuses() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<WeeklyStatus>> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/getAllBy=NONE");

		ResponseEntity<List<WeeklyStatus>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<WeeklyStatus>>(){});
		
		List<WeeklyStatus> weeklyStatuses = response.getBody();
		
		return weeklyStatuses;
	}
	
	public WeeklyStatus getWeeklyStatusById(Long weeklyStatusId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<WeeklyStatus> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/getBy=ID/weekly_status/" + weeklyStatusId);

		ResponseEntity<WeeklyStatus> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<WeeklyStatus>(){});
		
		WeeklyStatus weeklyStatus = response.getBody();
		
		return weeklyStatus;
	}

	public WeeklyStatus getWeeklyStatusByIdAndProjectId(Long projectId, Long weeklyStatusId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<WeeklyStatus> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/getBy=PROJECT_ID/project/" + String.valueOf(projectId)
							+ "/weekly_status/" + String.valueOf(weeklyStatusId));

		ResponseEntity<WeeklyStatus> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<WeeklyStatus>(){});
		
		WeeklyStatus weeklyStatus = response.getBody();
		
		return weeklyStatus;
	}
	
	public WeeklyStatus addWeeklyStatus(Long projectId, WeeklyStatusRequest weeklyStatusRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<WeeklyStatusRequest> entity = new HttpEntity<>(weeklyStatusRequest, headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/addBy=PROJECT_ID/project/" + String.valueOf(projectId));

		ResponseEntity<WeeklyStatus> response = restTemplate.exchange(uri, HttpMethod.POST, entity, new ParameterizedTypeReference<WeeklyStatus>(){});
		
		WeeklyStatus weeklyStatus = response.getBody();
		
		if(null != weeklyStatus)
			System.out.println("Weekly Status has been added successfully!");
		
		return weeklyStatus;
	}
	
	public WeeklyStatus updateWeeklyStatus(Long projectId, Long weeklyStatusId, WeeklyStatusRequest weeklyStatusRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<WeeklyStatusRequest> entity = new HttpEntity<>(weeklyStatusRequest, headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/updateBy=PROJECT_ID/project/" + String.valueOf(projectId)
							+ "/weekly_status/" + String.valueOf(weeklyStatusId));

		ResponseEntity<WeeklyStatus> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, new ParameterizedTypeReference<WeeklyStatus>(){});
		
		WeeklyStatus weeklyStatus = response.getBody();
		
		if(null != weeklyStatus)
			System.out.println("Weekly Status has been updated successfully!");
		
		return weeklyStatus;
	}
	
	public String deleteWeeklyStatusById(Long projectId, Long weeklyStatusId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/deleteBy=ID/project/" + String.valueOf(projectId)
							+ "/weekly_status/" + String.valueOf(weeklyStatusId));

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
		
		String apiResponse = response.getBody();
		
		if(null != apiResponse)
			System.out.println(apiResponse);
		
		return apiResponse;
	}
	
	public String deleteAllWeeklyStatusesByProjectId(Long projectId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/weekly_statuses/deleteAllBy=PROJECT_ID" + String.valueOf(projectId));

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class);
		
		String apiResponse = response.getBody();
		
		return apiResponse;
	}

}
