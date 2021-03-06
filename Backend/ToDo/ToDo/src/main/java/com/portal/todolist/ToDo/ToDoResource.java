package com.portal.todolist.ToDo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portal.todolist.ToDo.Service.TodoHardCodedService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ToDoResource {

	@Autowired
	private TodoHardCodedService todoService;

	@GetMapping("/users/{username}/todos")
	public List<ToDo> getAllToDos(@PathVariable String username) {
		return todoService.findAll();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public ToDo getToDo(@PathVariable String username, @PathVariable long id) {
		return todoService.findById(id);
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		
		ToDo todo = todoService.deleteById(id);
		if(todo!=null)
		{
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody ToDo todo) 
	{
		ToDo todoUpdated = todoService.save(todo);
		return new ResponseEntity<ToDo>(todo,HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, @RequestBody ToDo todo) 
	{
		ToDo createdTodo = todoService.save(todo);
		
		//location with current resource url and {id}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}
}
