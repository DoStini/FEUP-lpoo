package io.github.dostini.lpoo.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;
import io.github.dostini.lpoo.hero.game.screens.Arena;
import io.github.dostini.lpoo.hero.game.screens.EndScreen;
import io.github.dostini.lpoo.hero.game.screens.GameScreen;
import io.github.dostini.lpoo.hero.game.screens.GameState;

import java.io.IOException;

public class Game {

    private Screen screen;
    private GameScreen gameScreen;
    private int currLevel = 0;
    private int maxLevels;

    public Game() {
        this(1);
    }

    public Game(int maxLevels) {
        this.maxLevels = maxLevels;
        gameScreen = new Arena(40,20);
        try {
            TerminalSize tSize = new TerminalSize(80, 20);
            DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(tSize);

            Terminal terminal = defaultTerminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleState (GameState state) {
        switch (state) {
            case RESTART:
                gameScreen = new Arena(40,20);
                break;
            case WIN:
                currLevel++;
                if (currLevel == maxLevels) {
                    gameScreen = new EndScreen(40,20,"You Win");
                    currLevel = 0;
                }
                else
                    gameScreen = new Arena(40,20);
                break;
            case LOSE:
                gameScreen = new EndScreen(40,20,"You Lose");
                currLevel = 0;
                break;
        }
    }

    public void run() {
        try  {
            this.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try  {
                KeyStroke key = screen.readInput();

               handleState(gameScreen.run(key));

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                    screen.close();
                else if (key.getKeyType() == KeyType.EOF)
                    break;
                
                this.draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw() throws IOException {
        this.screen.clear();
        gameScreen.draw(screen.newTextGraphics());
        this.screen.refresh();
    }
}
