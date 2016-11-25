package com.infy.jnana;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class MainAppInitializer{

    public static void main(String[] args) throws Exception{
    	
    	SpringApplicationBuilder builder = new SpringApplicationBuilder(MainAppInitializer.class);
    	builder.headless(false);
    	ConfigurableApplicationContext context = builder.run(args);
    	
        //SpringApplication.run(MainAppInitializer.class, args);
       
    }
}

