package com.youki;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
	//@RequestMapping("/mvc")
	public class mvcController {
	//@RequestMapping(method = RequestMethod.GET)
	   // @RequestMapping("/hello")
	    @RequestMapping(value = "/hello", method = RequestMethod.GET)
	    public String hello(ModelMap model){        
	    	  model.addAttribute("message", "Hello Spring MVC Framework!");
	          return "hello";
	    }
	    //match automatically
	    @RequestMapping("/person")
	    public String toPerson(String name,double age){
	        System.out.println(name+" "+age);
	        return "hello";
	    }
	    
	    @RequestMapping("/person1")
	    public String toPerson(Person p){
	        System.out.println(p.getName()+" "+p.getAge());
	        return "hello";
	    }
	  //the parameter was converted in initBinder
	    @RequestMapping("/date")
	    public String date(Date date){
	        System.out.println(date);
	        return "hello";
	    }
	    
	    //At the time of initialization,convert the type "String" to type "date"
	    @InitBinder
	    public void initBinder(ServletRequestDataBinder binder){
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
	                true));
	    }
	  //pass the parameters to front-end
	    @RequestMapping("/show")
	    public String showPerson(Map<String,Object> map){
	        Person p =new Person();
	        map.put("p", p);
	        p.setAge(20);
	        p.setName("jayjay");
	        return "show";
	    }
	  //pass the parameters to front-end using ajax
	    @RequestMapping("/getPerson")
	    public void getPerson(String name,PrintWriter pw){
	        pw.write("hello,"+name);        
	    }
	    @RequestMapping("/name")
	    public String sayHello(){
	        return "name";
	    }
	    //redirect 
	    @RequestMapping("/redirect")
	    public String redirect(){
	        return "redirect:hello";
	    }
}
