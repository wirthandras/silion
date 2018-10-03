package hu.wirthandras.silion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hu.wirthandras.silion.domain.NewTranslation;
import hu.wirthandras.silion.service.TranslationServiceInterface;

@Controller
public class NewController {
	
	@Autowired
	private TranslationServiceInterface translationSevice;
	
	@GetMapping("/new")
	public String newTranslation(@ModelAttribute("object") NewTranslation t) {
		return "new";
	}
	
	@PostMapping("/new")
	public String newTranslationSave(@ModelAttribute NewTranslation object) {
		translationSevice.save(object.getBase(), object.getTranslation());
		return "redirect:random";
	}
	
}
