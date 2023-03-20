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
		expected = "Carta 1 (2000/2850/Posición: Ataque/Efecto: IMMORTAL) vs Carta 2 " +
				"(2000/1500/Posición: Ataque/Efecto: NA) -> Empate. Carta 2 destruido/a.";
        card_1 = new Card("Carta 1", 2000, 2850,
		        Position.ATTACK, Position.EFFECT.IMMORTAL);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.ATTACK, Position.EFFECT.NA);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
}
