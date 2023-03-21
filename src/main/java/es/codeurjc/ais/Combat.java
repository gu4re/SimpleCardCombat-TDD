package es.codeurjc.ais;

import org.jetbrains.annotations.NotNull;

public class Combat {
    private static final StringBuilder combat_resolution = new StringBuilder();
    private static final String NOT_SUPPORTED_YET = "Not supported yet";
    private Combat(){}
    private static void attackVsAttack(@NotNull Card card1, @NotNull Card card2){
        switch (Integer.signum(Integer.compare(card1.getAttack(), card2.getAttack()))) {
            case -1 -> {
                 if (card1.getEffect() != null && card1.getEffect().equals(Position.EFFECT.IMMORTAL))
                     combat_resolution.append("Gana Carta 2. Atacante pierde 200 puntos.");
                 else
                    combat_resolution.append("Gana Carta 2. Atacante pierde 300 puntos. Carta 1 destruido/a.");
            }
            case 0 -> {
                if (card1.getEffect() != null && card1.getEffect().equals(Position.EFFECT.IMMORTAL))
                    combat_resolution.append("Empate. Carta 2 destruido/a.");
                else
                    combat_resolution.append("Empate. Ambas cartas destruidas.");
            }
            case 1 -> {
                if (card2.getEffect() != null && card2.getEffect().equals(Position.EFFECT.IMMORTAL))
                    combat_resolution.append("Gana Carta 1. Defensor pierde 100 puntos.");
                else
                    combat_resolution.append("Gana Carta 1. Defensor pierde 500 puntos. Carta 2 destruido/a.");
            }
            default -> throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
        }
    }
    private static void attackVsDefense(@NotNull Card card1, @NotNull Card card2){
        switch (Integer.signum(Integer.compare(card1.getAttack(), card2.getDefense()))) {
            case -1 -> combat_resolution.append("Gana Carta 2. Atacante pierde 1000 puntos.");
            case 0 -> combat_resolution.append("Empate.");
            case 1 -> combat_resolution.append("Gana Carta 1. Carta 2 destruido/a.");
            default -> throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
        }
    }
    /*private static @NotNull String processEffect(@NotNull Card card){
        if (card.getEffect().toString().equals("NA"))
            return "N/A";
        else if(card.getEffect().toString().equals("IMMORTAL"))
            return "Inmortal";
        return card.getEffect().toString();
    }*/
    private static @NotNull String getCardInfo(@NotNull Card card){
        // Local variables
        final String CARD1_NAME = "Carta 1";
        StringBuilder cardInfoBuilder = new StringBuilder();
        int cardNumber = card.getName().equals(CARD1_NAME) ? 1 : 2;
        cardInfoBuilder.append((String.format("Carta %d (%d/%d/Posición: %s", cardNumber, card.getAttack(),
                card.getDefense(), (card.getPosition().equals(Position.ATTACK) ? "Ataque" : "Defensa"))));
        if (card.getEffect() != null)
            cardInfoBuilder.append(String.format("/Efecto: %s", card.getEffect().toString()));
            //cardInfoBuilder.append(String.format("/Efecto: %s", processEffect(card)));
        cardInfoBuilder.append(")");
        return cardInfoBuilder.toString();
    }
    public static @NotNull String combat(@NotNull Card card1, @NotNull Card card2) throws IllegalPositionException,
                UnsupportedOperationException {
        // Local variables
        final String ERROR_MESSAGE = "La carta atacante no puede estar en una posición de Defensa";
        final int ZERO = 0;
        // Clear StringBuilder
        combat_resolution.setLength(ZERO);
        if (card1.getPosition().equals(Position.DEFENSE))
            throw new IllegalPositionException(ERROR_MESSAGE);
        combat_resolution.append(getCardInfo(card1))
                .append(" vs ").append(getCardInfo(card2)).append(" -> ");
        switch (card2.getPosition()){
            case ATTACK -> attackVsAttack(card1, card2);
            case DEFENSE -> attackVsDefense(card1, card2);
            default -> throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
        }
        return combat_resolution.toString();
    }
}