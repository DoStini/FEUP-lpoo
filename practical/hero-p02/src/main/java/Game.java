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
    private int x = 10;
    private int y = 10;

    public Game() {
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
                x--;
                break;
            case ArrowRight:
                x++;
                break;
            case ArrowDown:
                y++;
                break;
            case ArrowUp:
                y--;
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

        while (true) {
            try  {
                KeyStroke key = screen.readInput();

                if (key.getKeyType() == KeyType.EOF)
                    break;

                processKey(key);
                this.draw();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw() throws IOException {
        this.screen.clear();
        this.screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        this.screen.refresh();
    }
}
