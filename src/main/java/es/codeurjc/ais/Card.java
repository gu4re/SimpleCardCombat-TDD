package es.codeurjc.ais;

public class Card {
    private final int attack;
    private final int defense;
    private final Position position;
    public Card(String name, int attack, int defense, Position position) {
        this.attack = attack;
        this.position = position;
        this.defense = defense;
    }
    public int getAttack() {
        return attack;
    }
    public Position getPosition(){
        return position;
    }
    public int getDefense(){
        return defense;
    }
}
