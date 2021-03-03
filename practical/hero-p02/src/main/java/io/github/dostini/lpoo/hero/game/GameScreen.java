package io.github.dostini.lpoo.hero.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public abstract class GameScreen {
    public GameScreen(int width, int height) {
        this.width = width;
        this.height = height;
    }
    abstract void init();
    abstract GameState run(KeyStroke key) throws IOException;
    abstract void draw(TextGraphics graphics);

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    protected int width, height;
}
