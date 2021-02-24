import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
        this.walls = createWalls();
    }

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

    private boolean isWall(Position position) {
        for (Wall wall : walls){
            if(position.equals(wall.getPosition()))
                return true;
        }
        return false;
    }

    private boolean canHeroMove(Position position){

        return position.getX() >= 0 &&
                position.getX() < width &&
                position.getY() >= 0 &&
                position.getY() < height
                && !isWall(position);
    }

    private void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++){
            walls.add(new Wall(c,0));
            walls.add(new Wall(c, height-1));
        }

        for (int r = 0; r < height; r++) {
            walls.add(new Wall(0,r));
            walls.add(new Wall(width-1,r));
        }

        return walls;
    }

    public void processKey(KeyStroke key) throws IOException {
        KeyType keyType = key.getKeyType();

        switch (keyType) {
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
        }
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#8C2D19"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
    }

    private int width, height;
    private Hero hero;
    private List<Wall> walls;
}
