package es.codeurjc.ais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Intermediate Case examples ...")
public class IntermediateCaseTest {
    private static String expected;
    private static String result;
    private static Card card_1;
    private static Card card_2;
    @BeforeEach
    public void setUp(){
        expected = "";
        result = "";
        card_1 = null;
        card_2 = null;
    }
	@Test
    @DisplayName("Eighth Example")
	public void test8(){
		Assertions.assertTrue(true);
	}
}
