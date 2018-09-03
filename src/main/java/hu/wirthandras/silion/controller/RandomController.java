package hu.wirthandras.silion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.wirthandras.silion.domain.Result;
import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.service.TranslationServiceInterface;

@Controller
public class RandomController {

	@Autowired
	public TranslationServiceInterface service;

	private Translation t;

	@RequestMapping("random")
	public String random(Model model) {
		t = service.getRandom();
		model.addAttribute("task", t.getBase());
		model.addAttribute("result", new Result());
		return "random";
	}

	@RequestMapping(value = "/rand", method = RequestMethod.POST)
	public String randomClicked(@ModelAttribute Result result) {
		boolean b = service.check(t.getTranslation(), result.getResult());
		if (b) {
			System.out.println("Match");
		} else {
			System.out.println("Fail");
		}
		return "redirect:random";
	}

}
