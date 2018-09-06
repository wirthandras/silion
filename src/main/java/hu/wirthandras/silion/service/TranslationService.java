package hu.wirthandras.silion.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.repository.TranslationRepository;

@Service
public class TranslationService implements TranslationServiceInterface {

	@Autowired
	private TranslationRepository repository;

	@Override
	public Translation getRandom() {
		List<Translation> translations = repository.findAll();
		Random r = new Random();
		int randomIndex = r.nextInt(translations.size());
		return translations.get(randomIndex);
	}

	@Override
	/**
	 *  Lower case check
	 */
	public boolean check(String original, String input) {
		return original.toLowerCase().equals(input.toLowerCase());
	}

	@Override
	public void save(String base, String translation) {
		repository.save(new Translation(base, translation));

	}

	@Override
	public List<Translation> getAll() {
		return repository.findAll();
	}

}
