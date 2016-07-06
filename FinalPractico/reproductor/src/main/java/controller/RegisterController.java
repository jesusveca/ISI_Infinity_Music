package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Person;
import service.PersonService;

@Controller
public class RegisterController {
	
	@Autowired
	PersonService personService;
	

	
	/*
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	String addNewPerson(@RequestParam(required = false) Long id, ModelMap model) {
		Person person = id == null ? new Person() : personService.get(id);
		model.addAttribute("person", person);
		return "register";
	}*/
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	String showPerson(@RequestParam(required = false) Long id, ModelMap model) {
			Person person = personService.get(id);
			model.addAttribute("person", person);
			return "register";
	}
}







