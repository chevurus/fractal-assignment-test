package com.fractal.assignment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {



	@Bean
	public RestTemplate restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();

		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();

		if (CollectionUtils.isEmpty(interceptors)) {
			interceptors = new ArrayList<>();
		}

//		 interceptors.add(new RestTemplateHeaderModifierInterceptor());
//		 restTemplate.setInterceptors(interceptors);

		restTemplate.setInterceptors(Collections.singletonList(restTemplateHeaderModifierInterceptor()));

		return restTemplate;

	}

	//Autowired as bean to enable to use the application.properties in the class
	@Bean
	public RestTemplateHeaderModifierInterceptor restTemplateHeaderModifierInterceptor() {
		return new RestTemplateHeaderModifierInterceptor();
	}

}