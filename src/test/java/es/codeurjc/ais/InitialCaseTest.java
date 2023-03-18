package es.codeurjc.ais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitialCaseTest {
    @Test
    public void Test1() {
        String expected = """
                Carta 1 (3000/2500/Posición: Ataque) vs Carta 2
                (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                puntos. Carta 2 destruido/a.""";
        Card card_1 = new Card("Carta 1", 3000, 2500, Position.Attack);
        Card card_2 = new Card("Carta 2", 2500, 2100, Position.Attack);
        String result = Combat.combatir(card_1, card_2);
        Assertions.assertEquals(result, expected);
    }
}
