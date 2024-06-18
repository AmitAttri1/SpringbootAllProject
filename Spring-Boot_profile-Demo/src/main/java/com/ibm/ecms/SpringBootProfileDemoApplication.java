package com.ibm.ecms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootProfileDemoApplication implements CommandLineRunner {

	private static final Log Logger=LogFactory.getLog(SpringBootProfileDemoApplication.class);
	@Autowired
	Environment environment;
	public static void main(String[] args) {
		
		SpringApplication springApplication=new SpringApplication(SpringBootProfileDemoApplication.class);
		springApplication.setAdditionalProfiles("dev");
		//SpringApplication.run(SpringBootProfileDemoApplication.class, args);
		springApplication.run(args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Logger.info(environment.getProperty("message"));
	}


}
