package hu.wirthandras.silion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.domain.api.XMLTranslationList;
import hu.wirthandras.silion.service.TranslationServiceInterface;

@RestController
public class AllRestController {
	
	@Autowired
	private TranslationServiceInterface tsi;

	@RequestMapping("/api/json")
	public List<Translation> getAllAsJson() {
		return tsi.getAll();
	}
	
	@RequestMapping(value="/api/xml", produces={"application/xml"})
	public XMLTranslationList getAllAsXML() {
		XMLTranslationList list = new XMLTranslationList();
		list.setList(tsi.getAll());
		return list;
	}

}
