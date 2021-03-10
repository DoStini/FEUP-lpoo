package io.github.dostini.lpoo.hero.game.screens;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class EndScreen extends GameScreen {

    public EndScreen(int width, int height, String text) {
        super(width, height);
        this.text = text;
    }

    @Override
    public GameState run(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'r')
            return GameState.RESTART;
        return GameState.RUNNING;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8C2D19"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(width/2-text.length()/2, height/2, text);
    }

    String text;
}
