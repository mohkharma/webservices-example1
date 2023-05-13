package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/")
	public String hello(
			@RequestParam(value = "name",
					defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/moreInfo")
	public Employee moreInfo(
			@RequestParam(value = "firstName",
					defaultValue = "World")
			String name,
			@RequestParam(value = "lastName")
			String lastName) {

		Employee object = new Employee();
		object.setFirstName(name);
		object.setLastName(lastName);

		return object;
	}

	@GetMapping("/employeeList")
	public List<Employee> employeeList(
			@RequestParam(value = "firstName",
					defaultValue = "World")
			String name,
			@RequestParam(value = "lastName")
			String lastName) {

		Employee object = new Employee();
		object.setFirstName(name);
		object.setLastName(lastName);

		return List.of(object,object);
	}

	/*
	* If you are using the spring-web-starter dependency in your Spring Boot
	* project, the media type that the controller returns by default is
	* application/json.
	* The spring-web-starter dependency includes the Jackson library,
	* which is used by Spring to automatically convert Java objects
	* to and from JSON.
	 * As you can see, this API returns a ResponseEntity object
	* and it is not necessary to specify the media type,
	* because the default one is application/json.
	* */
	@GetMapping("/data")
	public ResponseEntity<Object> getData() {
		Map<String, String> data = new HashMap<>();
		data.put("key1", "value1");
		data.put("key2", "value2");
//		return ResponseEntity.ok(data);
//		Another way
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
