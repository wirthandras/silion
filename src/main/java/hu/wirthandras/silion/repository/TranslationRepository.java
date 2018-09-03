package hu.wirthandras.silion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.wirthandras.silion.domain.Translation;

public interface TranslationRepository extends CrudRepository<Translation, Long> {

	List<Translation> findAll();
	
}
