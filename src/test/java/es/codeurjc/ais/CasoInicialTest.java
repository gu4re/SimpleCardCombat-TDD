package es.codeurjc.ais;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasoInicialTest {
    @Test
    public void Test1() {
        String expected = "Carta 1 (3000/2500/Posición: Ataque) vs Carta 2\n" +
                "(2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500\n" +
                "puntos. Carta 2 destruido/a.";
        Carta c1 = new Carta("Carta 1", 3000, 2500, Posicion.Ataque, Posicion.Efecto.NA);
        Carta c2 = new Carta("Carta 2", 2500, 2100, Posicion.Ataque, Posicion.Efecto.NA);
        String result = Combate.combatir(c1, c2);
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void Test2() {

    }

}
