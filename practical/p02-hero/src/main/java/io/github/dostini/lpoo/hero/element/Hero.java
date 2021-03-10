package io.github.dostini.lpoo.hero.element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import io.github.dostini.lpoo.hero.element.Element;

public class Hero extends Element {

    public Hero(int x, int y){
        super(x,y);
        hp = 100;
        coins = 0;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void increaseCoins() {
        coins++;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void decreaseHP(int hp) {
        this.hp -= hp;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    private int coins;
    private int hp;
}
