package com.sample.springboot.web.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

//import com.netflix.appinfo.InstanceInfo;
//import com.netflix.discovery.EurekaClient;
//import com.netflix.discovery.shared.Application;
import com.sample.springboot.web.model.Todo;
import com.sample.springboot.web.service.TodoService;


@Controller
@RibbonClient(name = "todo-service")
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;
    
    
   
    @LoadBalanced
    @Autowired
    private RestTemplate restTemplate;
   
   // @Autowired
   //private EurekaClient eurekaClient;
    
    @Value("${service.ToDoService.serviceId}")
    private String toDoServiceId;
   

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name = (String) model.get("name");
       
        Map<String, String> uriVariables = new HashMap<>();
		//uriVariables.put("from", from);
		//uriVariables.put("to", to);

		ResponseEntity<List> responseEntity = this.restTemplate.getForEntity(
				"http://todo-service/list-todos/", List.class,
				uriVariables);

		List<Object> response = responseEntity.getBody();

	
     // get list of available todos 
     		//List<Object> lst = restTemplate.getForObject("http://localhost:8100/list-todos/", List.class);
        
        model.put("todos", response);
        return "list-todos";
    }
}
