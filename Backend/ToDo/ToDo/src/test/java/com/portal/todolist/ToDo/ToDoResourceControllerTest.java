package com.portal.todolist.ToDo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.portal.todolist.ToDo.Service.TodoHardCodedService;

import junit.framework.Assert;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ToDoResource.class)
public class ToDoResourceControllerTest {
	
	
	@MockBean
	private TodoHardCodedService todoHardcodedService;
	
	
	List<ToDo> mockTodo = new ArrayList<>();
	
	@Test
	public void retrieveAllTodos() throws Exception
	{
		Mockito.when(
				todoHardcodedService.findAll()
				).thenReturn((List<ToDo>) mockTodo);
		
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/users/nilisha/todos").accept(
				MediaType.APPLICATION_JSON);
		
		Assert.assertNotNull(todoHardcodedService.findAll());
	}

}
