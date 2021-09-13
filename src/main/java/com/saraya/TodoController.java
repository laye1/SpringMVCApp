package com.saraya;

import java.util.Date;   



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;




@Controller
@SessionAttributes("username")
public class TodoController {
@Autowired
TodoService todoService;
Todo todo;
	
		
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(ModelMap model) {
		
		model.put("username",getLoggedInUserName());
		
		return "listTodo";
	}
	
	
	private String getLoggedInUserName() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(principal instanceof UserDetails) {
			
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
		
	}
	
	




	@RequestMapping(value="/list-todo", method=RequestMethod.GET)
	public String listDo(ModelMap model) {
		
		
		model.addAttribute("todos", todoService.showTodo());
		return "home";
	}
	
	
	@RequestMapping(value="/create-todo", method=RequestMethod.GET)
	public String addTodo() {
		
		return "createTodo";
	}
	
	@RequestMapping(value="/create-todo", method=RequestMethod.POST)
	public String addTodo(@RequestParam("description") String description) {
		
	
	todoService.addTodo("laye", description, new Date(), false);
		
		return "redirect:/list-todo";
		
	}
	

	
	@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
	public String deleteDo(ModelMap model,@RequestParam int id) {
		
	
		todoService.deleteTodo(id);
		model.clear();
		
		return "redirect:/list-todo";
		
	}
	

	@RequestMapping(value="/update-todo", method=RequestMethod.GET)
	public String updTodo(ModelMap model,@RequestParam int id) {
		model.addAttribute("todo",todoService.findById(id));
		return "updateTodo";
	}
	
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@ModelAttribute("todo") Todo todo) {
		
		todo.setUser("laye");
		todo.setDescription(todo.getDescription());
		todo.setTargetDate(new Date());
		
		todoService.updateTodo(todo);
		model.clear();
		
		return "redirect:/list-todo";
	}
	
	
}
