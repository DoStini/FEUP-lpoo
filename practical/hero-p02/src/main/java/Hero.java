import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public Hero(int x, int y){
        position = new Position(x,y);
    }

    public void draw(Screen screen) {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
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
}
