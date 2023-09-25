package arya.enrico.recapiounitTestservlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecapIoUnitTestServletApplicationTests {

	@Test
	@DisplayName("Testing first")
	void contextLoads() {
		String test ="test";
		Assertions.assertEquals("test",test);
	}

}
