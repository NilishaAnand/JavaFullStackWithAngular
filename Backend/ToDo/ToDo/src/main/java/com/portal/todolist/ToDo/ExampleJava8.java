package com.portal.todolist.ToDo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		Employee e1 = new Employee("nilisha",new Date());
		
		List<Employee> list = new ArrayList<>();
		list.add(e1);
		
		public void exampleJava8() {
			list.stream().filter(e->e.getName().equalsIgnoreCase("nilisha")).sorted(Comparator.comparing(Employee::getJoiningDate))
			.collect(Collectors.toList());
			
		}
		
		

	}

}
