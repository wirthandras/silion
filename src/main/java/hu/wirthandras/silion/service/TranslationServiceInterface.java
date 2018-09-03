package hu.wirthandras.silion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.wirthandras.silion.domain.Translation;

@Service
public interface TranslationServiceInterface {
	
	public Translation getRandom();

	public boolean check(String original, String input);

	public void save(String base, String translation);
	
	public List<Translation> getAll();
}
