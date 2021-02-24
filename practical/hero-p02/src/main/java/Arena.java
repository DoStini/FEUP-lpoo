import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
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

    private boolean canHeroMove(Position position){
        return position.getX() >= 0 &&
                position.getX() < width &&
                position.getY() >= 0 &&
                position.getY() < height;
    }

    private void moveHero(Position position){
        if(canHeroMove(position))
            hero.setPosition(position);
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

    public void draw(Screen screen){
        hero.draw(screen);
    }

    private int width, height;
    Hero hero;
}
