package com.saraya;

import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;





@Service
public class TodoService {
	
	
	
	private static List<Todo> todoList = new ArrayList<>();
	
	static {
		
		todoList.add(new Todo(1,"laye","desciption",new Date(),false));
		todoList.add(new Todo(2,"laye","desciption",new Date(),false));
		todoList.add(new Todo(3,"laye","desciption",new Date(),false));
		}
	private static int count=3;
	

	
	public List<Todo> showTodo() {
		
		return todoList;
		
	}
	
	
	
	
	public void addTodo( String user, String description, Date targetDate, boolean isDone) {
		
		todoList.add(new Todo(++count,user,description,targetDate,isDone));
		
	}
	
	public  void deleteTodo(int id) {
		
		Iterator<Todo> iterate = todoList.iterator();
		while(iterate.hasNext()) {
			Todo todo = iterate.next();
			if(todo.getId()==id) {
				
				iterate.remove();
				
			    
				
			}
				
		}
		
	}
	
	

	
	
	
public Todo findById(int id) {
		
		for(Todo todo:todoList) {
			if(todo.getId()==id) {
				return todo;
			}
			
		}
		return null;
	}
	
	
	public void updateTodo(Todo todo) {
		todoList.remove(todo);
		todoList.add(todo);
	}





	
	
	
}
