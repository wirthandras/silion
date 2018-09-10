package hu.wirthandras.silion.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.service.TranslationServiceInterface;

@Controller
public class AllController {

	@Autowired
	private TranslationServiceInterface tsi;

	@RequestMapping("all")
	public String getTranslations(Model model) {
		model.addAttribute("elements", tsi.getAll());
		return "all";
	}
	
	@RequestMapping("translations/{id}")
	public String get(@PathVariable("id") Long id) {
		Optional<Translation> t = tsi.find(id);
		if (t.isPresent()) {
			tsi.delete(t.get());
		}	
		return "all";
	}

}
