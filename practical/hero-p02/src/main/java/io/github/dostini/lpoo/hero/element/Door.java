package io.github.dostini.lpoo.hero.element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Door extends Element {
    public Door(int x, int y) {
        super(x,y);
        visible = false;
    }

    public void draw (TextGraphics graphics) {
        if (visible) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#fc7703"));
            graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private boolean visible;
}
