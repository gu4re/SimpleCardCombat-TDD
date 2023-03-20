package es.codeurjc.ais;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Card {
    private final int attack;
    private final int defense;
    @NotNull
    private final Position position;
    @Nullable
    private Position.EFFECT effect;
    public Card(String name, int attack, int defense, @NotNull Position position) {
        this.attack = attack;
        this.position = position;
        this.defense = defense;
        this.effect = null;
    }
    public Card(String name, int attack, int defense, @NotNull Position position,
                @Nullable Position.EFFECT effect) {
        this(name,attack,defense,position);
        this.effect = effect;
    }
    public int getAttack() {
        return attack;
    }
    @NotNull
    public Position getPosition(){
        return position;
    }
    public int getDefense(){
        return defense;
    }
    @Nullable
    public Position.EFFECT getEffect(){
        return effect;
    }
}
