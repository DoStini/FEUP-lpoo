package io.github.dostini.lpoo.hero.element;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import io.github.dostini.lpoo.hero.element.Element;

public class Wall extends Element {

    public Wall(int x, int y) {
        super(x,y);
    }

    public void draw (TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#4f000b"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
    }
}
