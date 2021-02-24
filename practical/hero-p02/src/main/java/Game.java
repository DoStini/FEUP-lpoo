import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {

    private Screen screen;
    private Arena arena;

    public Game() {
        arena = new Arena(40,20);
        try {
            TerminalSize tSize = new TerminalSize(40, 20);
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

    public void run() {
        try  {
            this.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try  {
                KeyStroke key = screen.readInput();

                arena.processKey(key);
                arena.handleEnemies();
                if(arena.verifyMonsterCollisions())
                    screen.close();

                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                    screen.close();
                else if (key.getKeyType() == KeyType.EOF)
                    break;

                arena.retrieveCoins();

                this.draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw() throws IOException {
        this.screen.clear();
        arena.draw(screen.newTextGraphics());
        this.screen.refresh();
    }
}
