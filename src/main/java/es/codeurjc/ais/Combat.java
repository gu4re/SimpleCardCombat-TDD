package es.codeurjc.ais;

import org.jetbrains.annotations.NotNull;

public class Combat {
    private static final StringBuilder combat_resolution = new StringBuilder();
    private Combat(){}
    public static @NotNull String combat(@NotNull Card c1, @NotNull Card c2) throws IllegalPositionException,
                UnsupportedOperationException {
        final String NSY = "Not supported yet";
        // Clear StringBuilder
        combat_resolution.setLength(0);
        if (c1.getPosition() == Position.DEFENSE)
            throw new IllegalPositionException("La carta atacante no puede estar en una posición de Defensa");
        combat_resolution.append(String.format("Carta 1 (%d/%d/Posición: Ataque", c1.getAttack(), c1.getDefense()));
        //combat_resolution.append(String.format("/Efecto: %s", c1.getEffect().toString() != null ? c1.getEffect().toString() : ""));
        if (c1.getEffect() != null)
            combat_resolution.append(String.format("/Efecto: %s", c1.getEffect().toString()));
        combat_resolution.append(") vs ");
        switch (c2.getPosition()) {
            case ATTACK -> {
                combat_resolution.append(String.format("Carta 2 (%d/%d/Posición: Ataque", c2.getAttack(), c2.getDefense()));
                if (c2.getEffect() != null)
                    combat_resolution.append(String.format("/Efecto: %s", c2.getEffect().toString()));
                combat_resolution.append(") -> ");
                switch (Integer.signum(Integer.compare(c1.getAttack(), c2.getAttack()))) {
                    case -1 -> combat_resolution.append("Gana Carta 2. Atacante pierde 300 puntos. Carta 1 destruido/a.");
                    case 0 -> {
                        if (c1.getEffect() != null && c1.getEffect().equals(Position.EFFECT.IMMORTAL))
                            combat_resolution.append("Empate. Carta 2 destruido/a.");
                        else
                            combat_resolution.append("Empate. Ambas cartas destruidas.");
                    }
                    case 1 -> combat_resolution.append("Gana Carta 1. Defensor pierde 500 puntos. Carta 2 destruido/a.");
                    default -> throw new UnsupportedOperationException(NSY);
                }
            }
            case DEFENSE -> {
                combat_resolution.append(String.format("Carta 2 (%d/%d/Posición: Defensa) -> ", c2.getAttack(), c2.getDefense()));
                switch (Integer.signum(Integer.compare(c1.getAttack(), c2.getDefense()))) {
                    case -1 -> combat_resolution.append("Gana Carta 2. Atacante pierde 1000 puntos.");
                    case 0 -> combat_resolution.append("Empate.");
                    case 1 -> combat_resolution.append("Gana Carta 1. Carta 2 destruido/a.");
                    default -> throw new UnsupportedOperationException(NSY);
                }
            }
            default -> throw new UnsupportedOperationException(NSY);
        }
        return combat_resolution.toString();
    }
}
