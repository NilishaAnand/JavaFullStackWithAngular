package com.portal.todolist.ToDo.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.portal.todolist.ToDo.ToDo;

@Service
public class TodoHardCodedService {

	private static List<ToDo> todos = new ArrayList<ToDo>();
	private static int idCounter = 0;

	static {

		todos.add(new ToDo(++idCounter, "Nilisha", "Learn to dance", new Date(), false,7209103766l,"nilisha.bit@gmail.com"));
		todos.add(new ToDo(++idCounter, "Nilisha", "Learn to cook", new Date(), false,7209103766l,"nilisha.bit@gmail.com"));
		todos.add(new ToDo(++idCounter, "Nilisha", "Learn to drive", new Date(), false,7209103766l,"nilisha.bit@gmail.com"));
	}

	public List<ToDo> findAll() {
		return todos;
	}
	
	public ToDo save(ToDo todo)
	{
		if(todo.getId()==-1 || todo.getId()==0)
		{
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else {
			
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public ToDo deleteById(long id) {
		ToDo todo = findById(id);
		if(todo==null)
			return null;
		if(todos.remove(todo))
			return todo;
		return null;
	}

	public ToDo findById(long id) {

		for (ToDo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}

		return null;
	}

}
