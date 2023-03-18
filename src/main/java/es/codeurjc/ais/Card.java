package es.codeurjc.ais;

public class Card {
    private final int attack;
    public Card(String name, int attack, int defense, Position position) {
        this.attack = attack;
    }
    public int getAttack() {
        return attack;
    }
}
