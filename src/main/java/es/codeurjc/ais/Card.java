package es.codeurjc.ais;

import org.jetbrains.annotations.NotNull;

public class Card {
    private final int attack;
    private final int defense;
    @NotNull
    private final Position position;
    private Position.EFFECT effect;
    public Card(String name, int attack, int defense, @NotNull Position position) {
        this.attack = attack;
        this.position = position;
        this.defense = defense;
        this.effect = Position.EFFECT.NA;
    }
    public Card(String name, int attack, int defense, @NotNull Position position,
                Position.EFFECT effect) {
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
    public Position.EFFECT getEffect(){
        return effect;
    }
}
