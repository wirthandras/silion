package hu.wirthandras.silion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Translation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String base;
	public String translation;
	public int occurences;
	public int answered;
	public int correct;

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
	
	public String getPercent() {
		if (answered > 0) {
			return correct / answered * 100 + "%";
		} else {
			return 0 + "%";
		}
	}

}
