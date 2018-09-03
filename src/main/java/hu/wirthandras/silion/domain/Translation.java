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

}
