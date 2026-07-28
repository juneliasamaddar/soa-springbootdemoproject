package com.klef.soa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoProjectApplication.class, args);
		System.out.println("Project is running...!!!");
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
