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

import com.afourathon.weekly_status_management_ui.data.entity.Project;


@Service
public class ConsumeProjectRestApiService {

	@Autowired
	RestTemplate restTemplate;

	public List<Project> getAllProjects() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<Project>> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/projects/getAllBy=NONE");

		ResponseEntity<List<Project>> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Project>>(){});
		
		List<Project> projects = response.getBody();
		
		return projects;
	}
	
	public Project getProjectById(Long projectId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Project> entity = new HttpEntity<>(headers);
		
		URI uri = URI.create("http://localhost:9292/api/v1/projects/getBy=ID/project/" + String.valueOf(projectId));

		ResponseEntity<Project> response = restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<Project>(){});
		
		Project project = response.getBody();
		
		return project;
	}

}
