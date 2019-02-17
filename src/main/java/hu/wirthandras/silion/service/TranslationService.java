package hu.wirthandras.silion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.repository.TranslationRepository;

@Service
public class TranslationService implements TranslationServiceInterface {

	@Autowired
	private RandomService serviceRandom;

	@Autowired
	private TranslationRepository repository;

	private Translation t;

	@Override
	public Translation getRandom() {
		List<Translation> translations = repository.findAll();
		t = translations.get(serviceRandom.nextInt(translations.size()));
		t.incrementOccurences();
		repository.save(t);
		return t;
	}

	@Override
	/**
	 * Lower case check
	 */
	public boolean check(String original, String input) {
		if (original.equalsIgnoreCase(input)) {
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

	@Override
	public void delete(Translation transation) {
		repository.delete(transation);
	}

	@Override
	public Optional<Translation> find(Long primaryKey) {
		Optional<Translation> t = repository.findById(primaryKey);
		return t;
	}

}
