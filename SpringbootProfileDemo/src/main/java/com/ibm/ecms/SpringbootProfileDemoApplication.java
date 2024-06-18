package com.ibm.ecms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringbootProfileDemoApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context=(AbstractApplicationContext)
		SpringApplication.run(SpringbootProfileDemoApplication.class, args);
		
		//devlopment env
		
		CustomerProd service=(CustomerProd) context.getBean("CustomerProd");
		service.insertCustomer();
		context.close();
		
	}

}
