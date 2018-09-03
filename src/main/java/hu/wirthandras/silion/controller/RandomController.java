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
	
	private Result res;

	@RequestMapping("random")
	public String random(Model model) {
		model.addAttribute("incorrect", res);
		model.addAttribute("result", new Result());
		if (res == null) {
			t = service.getRandom();
		}		
		model.addAttribute("task", t.getBase());
		
		return "random";
	}

	@RequestMapping(value = "/rand", method = RequestMethod.POST)
	public String randomClicked(@ModelAttribute Result result) {
		boolean b = service.check(t.getTranslation(), result.getResult());
		if (b) {
			res = null;
		} else {
			res = new Result();
		}
		return "redirect:random";
	}

}
