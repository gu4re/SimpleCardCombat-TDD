package es.codeurjc.ais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Initial Case examples ...")
public class InitialCaseTest {
    static String expected;
    @BeforeEach
    public void setUp(){
        expected = "";
    }
    @Test
    @DisplayName("First Example")
    public void test1() {
        String expected = """
                Carta 1 (3000/2500/Posición: Ataque) vs Carta 2
                (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                puntos. Carta 2 destruido/a.""";
        Card card_1 = new Card("Carta 1", 3000, 2500, Position.Attack);
        Card card_2 = new Card("Carta 2", 2500, 2100, Position.Attack);
        String result = Combat.combat(card_1, card_2);
        Assertions.assertEquals(expected, result);
    }
    @Test
    @DisplayName("Second Example")
    public void test2(){
        expected = """
                Carta 1 (1200/1000/Posición: Ataque) vs Carta 2
                (1500/1500/Posición: Ataque) -> Gana Carta 2. Atacante pierde 200
                puntos. Carta 1 destruido/a.""";
        es.codeurjc.ais.Card card_1 = new es.codeurjc.ais.Card("Carta 1", 3000, 2500, es.codeurjc.ais.Position.Attack);
        es.codeurjc.ais.Card card_2 = new es.codeurjc.ais.Card("Carta 2", 2500, 2100, es.codeurjc.ais.Position.Attack);
        String result = es.codeurjc.ais.Combat.combat(card_1, card_2);
        Assertions.assertEquals(expected, result);
    }
}
