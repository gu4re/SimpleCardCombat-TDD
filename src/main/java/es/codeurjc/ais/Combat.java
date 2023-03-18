package es.codeurjc.ais;

public class Combat {
    private static final StringBuilder combat_resolution = new StringBuilder();
    private Combat(){}
    public static String combat(Card c1, Card c2) {
        // Clear StringBuilder
        combat_resolution.setLength(0);
        if (c1.getAttack() > c2.getAttack()) {
            combat_resolution.append("""
                    Carta 1 (3000/2500/Posición: Ataque) vs Carta 2
                    (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                    puntos. Carta 2 destruido/a.""");
        } else {
            combat_resolution.append("""
                    Carta 1 (1200/1000/Posición: Ataque) vs Carta 2
                    (1500/1500/Posición: Ataque) -> Gana Carta 2. Atacante pierde 200
                    puntos. Carta 1 destruido/a.""");
        }
        return combat_resolution.toString();
    }
}
