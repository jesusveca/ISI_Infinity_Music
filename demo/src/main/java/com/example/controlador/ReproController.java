package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.Person;

@Controller
public class ReproController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(ModelMap model) {
		return "main";
	}
	

	
}

