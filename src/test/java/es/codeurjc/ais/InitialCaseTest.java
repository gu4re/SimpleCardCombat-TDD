package es.codeurjc.ais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Initial Case examples ...")
public class InitialCaseTest {
    static String expected;
    static String result;
    static Card card_1;
    static Card card_2;
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
        expected = """
                Carta 1 (3000/2500/Posición: Ataque) vs Carta 2
                (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                puntos. Carta 2 destruido/a.""";
        card_1 = new Card("Carta 1", 3000, 2500, Position.Attack);
        card_2 = new Card("Carta 2", 2500, 2100, Position.Attack);
        result = Combat.combat(card_1, card_2);
        Assertions.assertEquals(expected, result);
    }
    @Test
    @DisplayName("Second Example")
    public void test2(){
        expected = """
                Carta 1 (1200/1000/Posición: Ataque) vs Carta 2
                (1500/1500/Posición: Ataque) -> Gana Carta 2. Atacante pierde 200
                puntos. Carta 1 destruido/a.""";
        card_1 = new Card("Carta 1", 1200, 1000, Position.Attack);
        card_2 = new Card("Carta 2", 1500, 1500, Position.Attack);
        result = Combat.combat(card_1, card_2);
        Assertions.assertEquals(expected, result);
    }
}