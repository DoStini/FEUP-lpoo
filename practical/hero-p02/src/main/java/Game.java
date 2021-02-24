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
    private Hero hero;


    public Game() {
        hero = new Hero(10,10);
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

    private void processKey(KeyStroke key) throws IOException {
        KeyType keyType = key.getKeyType();

        switch (keyType) {
            case ArrowLeft:
                hero.moveLeft();
                break;
            case ArrowRight:
                hero.moveRight();
                break;
            case ArrowDown:
                hero.moveDown();
                break;
            case ArrowUp:
                hero.moveUp();
                break;
            case Character:
                if (key.getCharacter() == 'q'){
                    screen.close();
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + keyType);
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

                processKey(key);

                if (key.getKeyType() == KeyType.EOF)
                    break;

                this.draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw() throws IOException {
        this.screen.clear();
        hero.draw(screen);
        this.screen.refresh();
    }
}
