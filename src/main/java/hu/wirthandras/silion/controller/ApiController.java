package hu.wirthandras.silion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApiController {

	@RequestMapping("/api")
	public String apiView() {
		return "api";
	}

}
