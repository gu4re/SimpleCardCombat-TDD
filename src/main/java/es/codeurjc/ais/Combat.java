package es.codeurjc.ais;

import org.jetbrains.annotations.NotNull;

public class Combat {
    // Class Variables
    private static final StringBuilder combat_resolution = new StringBuilder();
    private static final String NOT_SUPPORTED_YET = "Not supported yet";
    private static final String BOTH_CARDS_DESTROYED = " Ambas cartas destruidas.";
    private static final String CARD2_DESTROYED = " Carta 2 destruido/a.";
    private static final String EMPTY = "";
    private static final String CARD1_NAME = "Carta 1";
    private static int lostPoints;
    private Combat(){} // Avoiding creation of a Combat Object
    private static void attackVsAttack(@NotNull Card card1, @NotNull Card card2) throws UnsupportedOperationException{
        lostPoints = (card2.getEffect() != null && card2.getEffect().equals(Position.EFFECT.PRESSURE))
                ? Math.abs(card1.getAttack() - card2.getAttack()) / 2
                : Math.abs(card1.getAttack() - card2.getAttack());
        switch (Integer.signum(Integer.compare(card1.getAttack(), card2.getAttack()))) {
            case -1 -> {
                combat_resolution.append(String.format("Gana Carta 2. Atacante pierde %d puntos.", lostPoints));
                if (card1.getEffect() != null)
                    combat_resolution.append((card1.getEffect().equals(Position.EFFECT.IMMORTAL)
                            ? EMPTY
                            : BOTH_CARDS_DESTROYED));
                else
                    combat_resolution.append(String.format(" %s destruido/a.", CARD1_NAME));
            }
            case 0 -> combat_resolution.append(String.format("Empate.%s",
                        (card1.getEffect() != null && card1.getEffect().equals(Position.EFFECT.IMMORTAL)
                                ? CARD2_DESTROYED
                                : BOTH_CARDS_DESTROYED)));
            case 1 -> combat_resolution.append(String.format("Gana %s. Defensor pierde %d puntos.%s", CARD1_NAME,
                    lostPoints, (card2.getEffect() != null && card2.getEffect().equals(Position.EFFECT.IMMORTAL)
                            ? EMPTY
                            : CARD2_DESTROYED)));
            default -> throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
        }
    }
    private static void attackVsDefense(@NotNull Card card1, @NotNull Card card2) throws UnsupportedOperationException{
        // Local variables
        final int DEFENSE_THRESHOLD = 2000;
        lostPoints = (card1.getEffect() != null && card1.getEffect().equals(Position.EFFECT.PRESSURE))
                ? Math.abs(card1.getAttack() - card2.getDefense()) / 2
                : Math.abs(card1.getAttack() - card2.getDefense());
        switch (Integer.signum(Integer.compare(card1.getAttack(), card2.getDefense()))) {
            case -1 -> combat_resolution.append(String.format("Gana Carta 2. Atacante pierde %d puntos.%s", lostPoints,
                        (card1.getEffect() != null && card1.getEffect().equals(Position.EFFECT.MORTAL_TOUCH)
                                && card2.getDefense() < DEFENSE_THRESHOLD)
                                ? CARD2_DESTROYED
                                : EMPTY));
            case 0 -> combat_resolution.append("Empate.").append((card1.getEffect() != null
                    && card2.getEffect() != null && card1.getEffect().equals(Position.EFFECT.MORTAL_TOUCH)
                    && card2.getEffect().equals(Position.EFFECT.MORTAL_TOUCH))
                    ? BOTH_CARDS_DESTROYED
                    : EMPTY);
            case 1 -> {
                combat_resolution.append(String.format("Gana %s.", CARD1_NAME));
                if (card2.getEffect() == null)
                    combat_resolution.append(CARD2_DESTROYED);
                else if (card2.getEffect().equals(Position.EFFECT.MORTAL_TOUCH)
                        && card1.getDefense() < DEFENSE_THRESHOLD)
                    combat_resolution.append(BOTH_CARDS_DESTROYED);
            }
            default -> throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
        }
    }
    private static @NotNull String effectToString(@NotNull Position.EFFECT effect){
        return switch (effect) {
            case NA -> "N/A";
            case IMMORTAL -> "Inmortal";
            case MORTAL_TOUCH -> "Toque mortal";
            case PRESSURE -> "Presión";
        };
    }
    private static @NotNull String getCardInfo(@NotNull Card card){
        // Local variables
        StringBuilder cardInfoBuilder = new StringBuilder();
        int cardNumber = card.getName().equals(CARD1_NAME) ? 1 : 2;
        cardInfoBuilder.append((String.format("Carta %d (%d/%d/Posición: %s", cardNumber, card.getAttack(),
                card.getDefense(), (card.getPosition().equals(Position.ATTACK) ? "Ataque" : "Defensa"))));
        if (card.getEffect() != null)
            cardInfoBuilder.append(String.format("/Efecto: %s", effectToString(card.getEffect())));
        cardInfoBuilder.append(")");
        return cardInfoBuilder.toString();
    }
    public static @NotNull String combat(@NotNull Card card1, @NotNull Card card2) throws IllegalPositionException,
                UnsupportedOperationException {
        // Local variables
        final String ERROR_MESSAGE = "La carta atacante no puede estar en una posición de Defensa";
        final int ZERO = 0;
        // Clearing StringBuilder at the beginning of the method
        combat_resolution.setLength(ZERO);
        if (card1.getPosition().equals(Position.DEFENSE))
            throw new IllegalPositionException(ERROR_MESSAGE);
        combat_resolution.append(getCardInfo(card1)).append(" vs ").append(getCardInfo(card2)).append(" -> ");
        switch (card2.getPosition()){
            case ATTACK -> attackVsAttack(card1, card2);
            case DEFENSE -> attackVsDefense(card1, card2);
            default -> throw new UnsupportedOperationException(NOT_SUPPORTED_YET);
        }
        return combat_resolution.toString();
    }
}