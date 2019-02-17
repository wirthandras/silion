package hu.wirthandras.silion.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class RandomServiceTest {

	private RandomService service;

	@Before
	public void setUp() {
		service = new RandomService();

		Random r = mock(Random.class);
		when(r.nextInt(anyInt())).thenReturn(1);

		ReflectionTestUtils.setField(service, "r", r);
	}

	@Test
	public void test() {
		assertEquals(1, service.nextInt(anyInt()));
	}

}
