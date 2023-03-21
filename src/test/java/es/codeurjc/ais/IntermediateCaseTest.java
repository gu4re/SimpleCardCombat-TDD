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
		expected = "Carta 1 (2000/2850/Posición: Ataque/Efecto: Inmortal) vs Carta 2 " +
				"(2000/1500/Posición: Ataque/Efecto: N/A) -> Empate. Carta 2 destruido/a.";
        card_1 = new Card("Carta 1", 2000, 2850,
		        Position.ATTACK, Position.EFFECT.IMMORTAL);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.ATTACK, Position.EFFECT.NA);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Ninth Example")
	public void test9(){
		expected = "Carta 1 (1800/2850/Posición: Ataque/Efecto: Inmortal) vs Carta 2 " +
				"(2000/1500/Posición: Ataque/Efecto: N/A) -> Gana Carta 2. Atacante pierde 200 puntos.";
        card_1 = new Card("Carta 1", 1800, 2850,
		        Position.ATTACK, Position.EFFECT.IMMORTAL);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.ATTACK, Position.EFFECT.NA);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Tenth Example")
	public void test10(){
		expected = "Carta 1 (2100/2850/Posición: Ataque/Efecto: N/A) vs Carta 2 " +
				"(2000/1500/Posición: Ataque/Efecto: Inmortal) -> Gana Carta 1. Defensor pierde 100 puntos.";
        card_1 = new Card("Carta 1", 2100, 2850,
		        Position.ATTACK, Position.EFFECT.NA);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.ATTACK, Position.EFFECT.IMMORTAL);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Eleventh Example")
	public void test11(){
		expected = "Carta 1 (1800/2850/Posición: Ataque/Efecto: N/A) vs Carta 2 " +
				"(2000/1500/Posición: Defensa/Efecto: Inmortal) -> Gana Carta 1.";
        card_1 = new Card("Carta 1", 1800, 2850,
		        Position.ATTACK, Position.EFFECT.NA);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.DEFENSE, Position.EFFECT.IMMORTAL);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Twelfth Example")
	public void test12(){
		expected = "Carta 1 (1000/2850/Posición: Ataque/Efecto: Toque mortal) vs Carta 2 " +
				"(2000/1500/Posición: Defensa/Efecto: N/A) -> Gana Carta 2. Atacante pierde 500 puntos. Carta 2 " +
				   "destruido/a.";
        card_1 = new Card("Carta 1", 1000, 2850,
		        Position.ATTACK, Position.EFFECT.MORTAL_TOUCH);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.DEFENSE, Position.EFFECT.NA);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Thirteenth Example")
	public void test13(){
		expected = "Carta 1 (2000/1000/Posición: Ataque/Efecto: N/A) vs Carta 2 (2000/1500/Posición: Defensa/Efecto: Toque mortal) " +
				"-> Gana Carta 1. Ambas cartas destruidas.";
        card_1 = new Card("Carta 1", 2000, 1000,
		        Position.ATTACK, Position.EFFECT.NA);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.DEFENSE, Position.EFFECT.MORTAL_TOUCH);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Fourteenth Example")
	public void test14(){
		expected = "Carta 1 (1000/1000/Posición: Ataque/Efecto: Toque mortal) vs Carta 2 (0/1000/Posición: " +
				"Defensa/Efecto: Toque mortal) -> Empate. Ambas cartas destruidas.";
        card_1 = new Card("Carta 1", 1000, 1000,
		        Position.ATTACK, Position.EFFECT.MORTAL_TOUCH);
        card_2 = new Card("Carta 2", 0, 1000,
		        Position.DEFENSE, Position.EFFECT.MORTAL_TOUCH);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Fifteenth Example")
	public void test15(){
		expected = "Carta 1 (1500/1000/Posición: Ataque/Efecto: Toque mortal) vs Carta 2 (2000/1500/Posición: " +
				"Ataque/Efecto: N/A) -> Gana Carta 2. Atacante pierde 500 puntos. Ambas cartas destruidas.";
        card_1 = new Card("Carta 1", 1500, 1000,
		        Position.ATTACK, Position.EFFECT.MORTAL_TOUCH);
        card_2 = new Card("Carta 2", 2000, 1500,
		        Position.ATTACK, Position.EFFECT.NA);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Sixteenth Example")
	public void test16(){
		expected = "Carta 1 (1000/0/Posición: Ataque/Efecto: Presión) vs Carta 2 (0/3000/Posición: " +
				"Defensa/Efecto: N/A) -> Gana Carta 2. Atacante pierde 1000 puntos.";
        card_1 = new Card("Carta 1", 1000, 0,
		        Position.ATTACK, Position.EFFECT.PRESSURE);
        card_2 = new Card("Carta 2", 0, 3000,
		        Position.DEFENSE, Position.EFFECT.NA);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
	@Test
	@DisplayName("Seventeenth Example")
	public void test17(){
		expected = "Carta 1 (2000/0/Posición: Ataque/Efecto: N/A) vs Carta 2 (1500/0/Posición: " +
				"Ataque/Efecto: Presión) -> Gana Carta 1. Defensor pierde 250 puntos. Carta 2 destruido/a.";
        card_1 = new Card("Carta 1", 2000, 0,
		        Position.ATTACK, Position.EFFECT.NA);
        card_2 = new Card("Carta 2", 1500, 0,
		        Position.ATTACK, Position.EFFECT.PRESSURE);
		Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
	}
}
