package io.github.dostini.lpoo.hero.element;

import com.googlecode.lanterna.graphics.TextGraphics;
import io.github.dostini.lpoo.hero.datatype.Position;

public abstract class Element {

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public abstract void draw(TextGraphics graphics);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveUp() {
        return position.moveUp();
    }
    public Position moveDown() {
        return position.moveDown();
    }
    public Position moveLeft() {
        return position.moveLeft();
    }
    public Position moveRight() {
        return position.moveRight();
    }

    protected Position  position;
}
