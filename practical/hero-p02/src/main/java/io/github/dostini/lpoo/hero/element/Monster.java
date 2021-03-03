package io.github.dostini.lpoo.hero.element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import io.github.dostini.lpoo.hero.datatype.Position;

import java.util.Random;

public class Monster extends Element {

    public Monster(int x, int y, int strenght) {
        super(x, y);
        this.strenght = strenght;
    }

    public Position move() {
        Random random = new Random();
        Position mov = new Position(random.nextInt(3)-1, random.nextInt(3)-1);
        return new Position(position.getX() + mov.getX(), position.getY() + mov.getY());
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffaa00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "^");
    }

    private final int strenght;

    public int getStrenght() {
        return strenght;
    }
}
