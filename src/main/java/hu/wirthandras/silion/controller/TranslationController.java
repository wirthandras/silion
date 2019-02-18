package hu.wirthandras.silion.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.service.TranslationServiceInterface;

@Controller
public class TranslationController {

	@Autowired
	private TranslationServiceInterface tsi;

	@GetMapping("translations")
	public String getTranslations(Model model) {
		model.addAttribute("elements", tsi.getAll());
		return "translations";
	}
	
	@GetMapping("translations/remove/{id}")
	public String get(@PathVariable("id") Long id) {
		Optional<Translation> t = tsi.find(id);
		if (t.isPresent()) {
			tsi.delete(t.get());
		}	
		return "translations";
	}
	
	@GetMapping("translation/{id}")
	public String detailed(@PathVariable("id") Long id, Model model) {
		Optional<Translation> t = tsi.find(id);
		if (t.isPresent()) {
			model.addAttribute("translation", t.get());
		}	
		return "translation";
	}

}
