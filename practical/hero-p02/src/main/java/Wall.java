import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {

    public Wall(int x, int y) {
        this.position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void draw (TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#4f000b"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private Position position;
}
