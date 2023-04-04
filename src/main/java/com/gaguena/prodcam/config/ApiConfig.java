package com.gaguena.prodcam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@Configuration
public class ApiConfig {

    @Autowired
    ObjectMapper mapper;

    @Bean
    public ServletRegistrationBean<Servlet> servletRegistrationBean() {
        ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(
          new CamelHttpTransportServlet(),
          "/prodcam/api/*");
        registration.setName("CamelServlet");
        return registration;
    }
}
