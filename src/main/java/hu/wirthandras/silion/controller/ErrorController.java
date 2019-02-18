package hu.wirthandras.silion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

	@GetMapping("/error")
	public String error() {
		return "error";
	}
}
