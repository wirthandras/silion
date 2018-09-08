package hu.wirthandras.silion.domain.api;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import hu.wirthandras.silion.domain.Translation;

@XmlRootElement(name="translations")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLTranslationList {

	@XmlElement (name = "translation")
	private List<Translation> list;
	
	public XMLTranslationList() {
		
	}

	public List<Translation> getList() {
		return list;
	}

	public void setList(List<Translation> list) {
		this.list = list;
	}
	
	
	
	
}
