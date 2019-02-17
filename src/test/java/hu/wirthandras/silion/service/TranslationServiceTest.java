package hu.wirthandras.silion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import hu.wirthandras.silion.domain.Translation;
import hu.wirthandras.silion.repository.TranslationRepository;

public class TranslationServiceTest {

	private TranslationService service;

	private RandomService mockServiceRandom;
	private TranslationRepository mockRepository;

	private Translation mockT1;
	private Translation mockT2;

	@Before
	public void setUp() {
		service = new TranslationService();

		mockT1 = mock(Translation.class);
		mockT2 = mock(Translation.class);

		mockServiceRandom = mock(RandomService.class);
		when(mockServiceRandom.nextInt(anyInt())).thenReturn(1);

		mockRepository = mock(TranslationRepository.class);
		List<Translation> translations = new ArrayList<>();
		translations.add(mockT1);
		translations.add(mockT2);
		when(mockRepository.findAll()).thenReturn(translations);

		ReflectionTestUtils.setField(service, "serviceRandom", mockServiceRandom);
		ReflectionTestUtils.setField(service, "repository", mockRepository);
	}

	@Test
	public void testGetRandomWithFixedResult() {
		assertNotNull(service.getRandom());
		assertEquals(mockT2, service.getRandom());
	}
}
