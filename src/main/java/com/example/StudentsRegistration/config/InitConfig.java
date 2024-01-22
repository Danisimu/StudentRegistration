package com.example.StudentsRegistration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.StudentsRegistration")
@PropertySource("classpath:init-application.properties")
@Profile("init")
public class InitConfig {


}
