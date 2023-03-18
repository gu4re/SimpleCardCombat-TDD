package es.codeurjc.ais;

public class Combat {
    private static final StringBuilder combat_resolution = new StringBuilder();
    private Combat(){}
    public static String combat(Card c1, Card c2) {
        if (c1.getAttack() > c2.getAttack()) {
            combat_resolution.append("""
                    Carta 1 (3000/2500/Posición: Ataque) vs Carta 2
                    (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                    puntos. Carta 2 destruido/a.""");
        } else if (c2.getAttack() > c1.getAttack()) {
            combat_resolution.append("""
                    Carta 1 (1000/2500/Posición: Ataque) vs Carta 2
                    (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                    puntos. Carta 2 destruido/a.""");
        } else{
            return null;
        }
        return combat_resolution.toString();
    }
}
