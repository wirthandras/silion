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
	
	private Translation t;

	@Override
	public Translation getRandom() {
		List<Translation> translations = repository.findAll();
		Random r = new Random();
		int randomIndex = r.nextInt(translations.size());
		t = translations.get(randomIndex);
		t.incrementOccurences();
		repository.save(t);
		return t;
	}

	@Override
	/**
	 * Lower case check
	 */
	public boolean check(String original, String input) {
		if (original.toLowerCase().equals(input.toLowerCase())) {
			t.incrementAnswered();
			t.incrementCorrect();
			repository.save(t);
			return true;
		} else {
			t.incrementAnswered();
			repository.save(t);
			return false;
		}
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
