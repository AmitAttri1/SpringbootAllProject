package com.tcs.trs.api;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/process")
public class MessageAPI {
		
	@GetMapping(value = "/readMessage")
	public String test() {
		return "Welcome to Spring Boot Rest Webservices";
	}

	@PostMapping(value = "/writeMessage")
	public Map<String, String> post(@RequestBody Map<String, String> map) {
		return map;
	}

}
