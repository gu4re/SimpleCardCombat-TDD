package es.codeurjc.ais;

public class Combate {
    public static String combatir(Carta c1, Carta c2) {
        return "Carta 1 (3000/2500/Posición: Ataque) vs Carta 2\n" +
                "(2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500\n" +
                "puntos. Carta 2 destruido/a.";
    }
}
