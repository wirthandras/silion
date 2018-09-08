package hu.wirthandras.silion.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

	@RequestMapping("/error")
	public String error() {
		return "error";
	}
}
