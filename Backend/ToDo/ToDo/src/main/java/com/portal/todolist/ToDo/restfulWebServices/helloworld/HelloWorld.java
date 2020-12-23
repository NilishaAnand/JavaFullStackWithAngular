package com.portal.todolist.ToDo.restfulWebServices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.portal.todolist.ToDo.basic.auth.AuthenticationBean;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorld {
	
	@GetMapping(path = "/hello-world")
	public String HelloWorld()
	{
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public AuthenticationBean helloWorldBean()
	{
		return new AuthenticationBean("Hello-World-Message");
		//throw new RuntimeException("Some Error Occurred.... Please contact the Support***");
	}

	@GetMapping(path ="/hello-world/path-variable/{name}")
	public AuthenticationBean helloWorldPathVariable(@PathVariable String name)
	{
		return new AuthenticationBean(String.format("Hello World, %s", name));
	}
}
