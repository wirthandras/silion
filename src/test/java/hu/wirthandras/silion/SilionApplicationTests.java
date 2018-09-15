package hu.wirthandras.silion;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SilionApplicationTests {

	@Test
	@Ignore (value = "Database parameters passed througn enviroment variables")
	public void contextLoads() {
	}

}
