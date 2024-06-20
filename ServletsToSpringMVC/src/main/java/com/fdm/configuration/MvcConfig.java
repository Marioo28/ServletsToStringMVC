package com.fdm.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.fdm")
public class MvcConfig{
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setSuffix(".jsp");
		return vr;
	}
	
	/*
	 * @Bean public HandlerMapping resourceHandlerMapping(ResourceLoader
	 * resourceLoader) { SimpleUrlHandlerMapping mapping = new
	 * SimpleUrlHandlerMapping(); mapping.setOrder(Integer.MIN_VALUE);
	 * mapping.setUrlMap(Collections.singletonMap("/**",
	 * resourceHttpRequestHandler(resourceLoader))); return mapping; }
	 * 
	 * @Bean public ResourceHttpRequestHandler
	 * resourceHttpRequestHandler(ResourceLoader resourceLoader) {
	 * ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
	 * requestHandler.setLocations(Collections.singletonList(resourceLoader.
	 * getResource("/"))); return requestHandler; }
	 */

}
