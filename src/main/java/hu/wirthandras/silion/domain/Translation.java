package hu.wirthandras.silion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Translation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	public Long id;
	@XmlElement
	public String base;
	@XmlElement
	public String translation;
	@XmlElement
	public int occurences;
	@XmlElement
	public int answered;
	@XmlElement
	public int correct;
	@XmlElement
	public Boolean disabled = false;

	public Translation() {

	}

	public Translation(Long id, String base, String translation) {
		super();
		this.id = id;
		this.base = base;
		this.translation = translation;
	}

	public Translation(String base, String translation) {
		super();
		this.id = null;
		this.base = base;
		this.translation = translation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}
	
	public void incrementOccurences() {
		this.occurences++;
	}
	
	public void incrementAnswered() {
		this.answered++;
	}
	
	public void incrementCorrect() {
		this.correct++;
	}

	public int getAnswered() {
		return answered;
	}

	public void setAnswered(int answered) {
		this.answered = answered;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	public int getPercent() {
		if (answered > 0) {
			return (correct * 100 / answered * 100) / 100;
		} else {
			return 0;
		}
	}

	public Boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	
	

}
