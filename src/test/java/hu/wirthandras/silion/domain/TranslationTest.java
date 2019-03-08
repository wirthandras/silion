package hu.wirthandras.silion.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TranslationTest {
	
	private String base = "base";
	private String translation = "translation";
	
	private Translation t; 
	
	@Before
	public void setup() {
		t = new Translation(base, translation);
	}

	@Test
	public void testDefaultState() {
		Assert.assertEquals(0, t.getOccurences());
		Assert.assertEquals(0, t.getAnswered());
		Assert.assertEquals(0, t.getCorrect());
	}
	
	@Test
	public void testDisplayedOnce() {
		t.incrementOccurences();
		Assert.assertEquals(1, t.getOccurences());
		Assert.assertEquals(0, t.getAnswered());
		Assert.assertEquals(0, t.getCorrect());
		Assert.assertEquals(0, t.getPercent());
	}
	
	@Test
	public void testAnsweredOnceButFailed() {
		t.incrementOccurences();
		t.incrementAnswered();
		Assert.assertEquals(1, t.getOccurences());
		Assert.assertEquals(1, t.getAnswered());
		Assert.assertEquals(0, t.getCorrect());
		Assert.assertEquals(0, t.getPercent());
	}
	
	@Test
	public void testDisplayedAnsweredAndCorrect() {
		t.incrementOccurences();
		t.incrementAnswered();
		t.incrementCorrect();
		Assert.assertEquals(1, t.getOccurences());
		Assert.assertEquals(1, t.getAnswered());
		Assert.assertEquals(1, t.getCorrect());
		Assert.assertEquals(100, t.getPercent());
	}
	
	@Test
	public void testDisplayedTenAnsweredSixAndCorrectThree() {
		for(int i = 0; i < 10; i++)
			t.incrementOccurences();
		for(int i = 0; i < 6; i++)
			t.incrementAnswered();
		for(int i = 0; i < 3; i++)
			t.incrementCorrect();
		Assert.assertEquals(10, t.getOccurences());
		Assert.assertEquals(6, t.getAnswered());
		Assert.assertEquals(3, t.getCorrect());
		Assert.assertEquals(50, t.getPercent());
	}
	
	@Test
	public void testGetterSetter() {
		PojoClass pojoclass = PojoClassFactory.getPojoClass(Translation.class);
		Validator validator = ValidatorBuilder.create()
				.with(new SetterMustExistRule())
				.with(new GetterMustExistRule())
				.with(new SetterTester())
				.with(new GetterTester())
				.build();
		validator.validate(pojoclass);
	}

}
