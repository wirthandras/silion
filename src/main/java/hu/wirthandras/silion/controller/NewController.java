package hu.wirthandras.silion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.wirthandras.silion.domain.NewTranslation;
import hu.wirthandras.silion.service.TranslationServiceInterface;

@Controller
public class NewController {
	
	@Autowired
	private TranslationServiceInterface translationSevice;
	
	@RequestMapping("new")
	public String newTranslation(Model model) {
		model.addAttribute("object", new NewTranslation());
		return "new";
	}
	
	@RequestMapping(value = "/newelement", method = RequestMethod.POST)
	public String newTranslationSave(@ModelAttribute NewTranslation object) {
		translationSevice.save(object.getBase(), object.getTranslation());
		return "redirect:random";
	}
	
}
