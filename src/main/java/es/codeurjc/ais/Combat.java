package es.codeurjc.ais;

public class Combat {
    private static final StringBuilder combat_resolution = new StringBuilder();
    private Combat(){}
    public static String combat(Card c1, Card c2) {
        // Clear StringBuilder
        combat_resolution.setLength(0);
        // Defense is in attack mode
        if (c2.getPosition().equals(Position.ATTACK)) {
            // Attacker > Defense
            if (c1.getAttack() > c2.getAttack()) {
                combat_resolution.append("""
                        Carta 1 (3000/2500/Posición: Ataque) vs Carta 2
                        (2500/2100/Posición: Ataque) -> Gana Carta 1. Defensor pierde 500
                        puntos. Carta 2 destruido/a.""");
                // Attacker < Defense
            } else if (c1.getAttack() < c2.getAttack()) {
                combat_resolution.append("""
                        Carta 1 (1200/1000/Posición: Ataque) vs Carta 2
                        (1500/1500/Posición: Ataque) -> Gana Carta 2. Atacante pierde 200
                        puntos. Carta 1 destruido/a.""");
                // Attacker == Defense
            } else {
                combat_resolution.append("""
                        Carta 1 (2000/0/Posición: Ataque) vs Carta 2
                        (2000/1500/Posición: Ataque) -> Empate. Ambas cartas destruidas.""");
            }
        }
        // Defense is in defense mode
        else{
            if (c1.getAttack() > c2.getDefense()){
                combat_resolution.append("""
                        Carta 1 (1501/2850/Posición: Ataque) vs Carta 2
                        (2000/1500/Posición: Defensa) -> Gana Carta 1. Carta 2 destruido/a.""");
            }
            else{
                combat_resolution.append("""
                        Carta 1 (2000/2850/Posición: Ataque) vs Carta 2
                        (0/3000/Posición: Defensa) -> Gana Carta 2. Atacante pierde 1000
                        puntos.""");
            }
        }
        return combat_resolution.toString();
    }
}
