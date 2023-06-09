package es.codeurjc.ais;

import org.junit.jupiter.api.*;

@DisplayName("Initial Case examples ...")
public class InitialCaseTest {
    private static String expected;
    private static String result;
    protected static Card card_1;
    protected static Card card_2;
    @BeforeEach
    public void setUp(){
        expected = "";
        result = "";
        card_1 = null;
        card_2 = null;
    }
    @Test
    @DisplayName("First Example")
    public void test1() {
        expected = "Carta 1 (3000/2500/Posición: Ataque) vs Carta 2 (2500/2100/Posición: Ataque) " +
                "-> Gana Carta 1. Defensor pierde 500 puntos. " +
                "Carta 2 destruido/a.";
        card_1 = new Card("Carta 1", 3000, 2500, Position.ATTACK);
        card_2 = new Card("Carta 2", 2500, 2100, Position.ATTACK);
        Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
    }
    @Test
    @DisplayName("Second Example")
    public void test2(){
        expected = "Carta 1 (1200/1000/Posición: Ataque) vs Carta 2 (1500/1500/Posición: Ataque) " +
                "-> Gana Carta 2. Atacante pierde 300 " +
                "puntos. Carta 1 destruido/a.";
        card_1 = new Card("Carta 1", 1200, 1000, Position.ATTACK);
        card_2 = new Card("Carta 2", 1500, 1500, Position.ATTACK);
        Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
    }
    @Test
    @DisplayName("Third Example")
    public void test3(){
        expected = "Carta 1 (2000/0/Posición: Ataque) vs Carta 2 " +
                "(2000/1500/Posición: Ataque) -> Empate. Ambas cartas destruidas.";
        card_1 = new Card("Carta 1", 2000, 0, Position.ATTACK);
        card_2 = new Card("Carta 2", 2000, 1500, Position.ATTACK);
        Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
    }
    @Test
    @DisplayName("Fourth Example")
    public void test4(){
        expected = "Carta 1 (1501/2850/Posición: Ataque) vs Carta 2 " +
                "(2000/1500/Posición: Defensa) -> Gana Carta 1. Carta 2 destruido/a.";
        card_1 = new Card("Carta 1", 1501, 2850, Position.ATTACK);
        card_2 = new Card("Carta 2", 2000, 1500, Position.DEFENSE);
        Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
    }
    @Test
    @DisplayName("Fifth Example")
    public void test5(){
        expected = "Carta 1 (2000/2850/Posición: Ataque) vs Carta 2 " +
                "(0/3000/Posición: Defensa) -> Gana Carta 2. Atacante pierde 1000 puntos.";
        card_1 = new Card("Carta 1", 2000, 2850, Position.ATTACK);
        card_2 = new Card("Carta 2", 0, 3000, Position.DEFENSE);
        Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
    }
    @Test
    @DisplayName("Sixth Example")
    public void test6(){
        expected = "Carta 1 (1500/2850/Posición: Ataque) vs Carta 2 " +
                "(2000/1500/Posición: Defensa) -> Empate.";
        card_1 = new Card("Carta 1", 1500, 2850, Position.ATTACK);
        card_2 = new Card("Carta 2", 2000, 1500, Position.DEFENSE);
        Assertions.assertDoesNotThrow(() -> {
            result = Combat.combat(card_1, card_2);
            Assertions.assertEquals(expected, result);
        });
    }
    @Nested
    @DisplayName("Seventh Example")
    // Avoided the usage of unused variables as 'expected' or 'result' here
    class SeventhExample {
        @BeforeEach
        public void setUp(){
            card_1 = null;
            card_2 = null;
        }
        @Test
        @DisplayName("Exception thrown")
        public void test7(){
            card_1 = new Card("Carta 1", 1500, 2850, Position.DEFENSE);
            card_2 = new Card("Carta 2", 2000, 1500, Position.DEFENSE);
            Assertions.assertThrows(IllegalPositionException.class, () ->
                    Combat.combat(card_1, card_2)
            );
        }
    }
}