package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class ReproController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String home(ModelMap model) {
		return "main";
	}

}

