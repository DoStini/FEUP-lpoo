import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createEnemies();
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

    private int coinIdx(Position position) {
        for (int i = 0; i < coins.size(); i++){
            if(position.equals(coins.get(i).getPosition()))
                return i;
        }
        return -1;
    }

    private boolean isCoin(Position position) {
        return coinIdx(position) != -1;
    }

    private boolean canMoveElement(Position position){

        return position.getX() >= 0 &&
                position.getX() < width &&
                position.getY() >= 0 &&
                position.getY() < height
                && !isWall(position);
    }

    private void moveHero(Position position){
        if(canMoveElement(position))
            hero.setPosition(position);
    }

    private List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();

        Random random = new Random();

        int numCoins = random.nextInt(10)+5;

        for (int i = 0; i < numCoins;) {
            Position pos = new Position(random.nextInt(width-1), random.nextInt(height-1));
            if(!isWall(pos) && !coins.contains(new Coin(pos.getX(), pos.getY())) && !pos.equals(hero.position)) {
                coins.add(new Coin(pos.getX(), pos.getY()));
                i++;
            }
        }

        return coins;
    }

    private List<Monster> createEnemies() {
        List<Monster> enemies = new ArrayList<>();

        Random random = new Random();

        int numEnemies = random.nextInt(15)+5;

        for (int i = 0; i < numEnemies;) {
            Position pos = new Position(random.nextInt(width-1), random.nextInt(height-1));
            if(!isWall(pos) && !pos.equals(hero.position)) {
                enemies.add(new Monster(pos.getX(), pos.getY()));
                i++;
            }
        }

        return enemies;
    }

    public void retrieveCoins () {
        int coin = coinIdx(hero.position);

        if (coin != -1) {
            coins.remove(coin);
        }

        hero.increaseCoins();
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

    public void handleEnemies() {
        for (Monster monster : monsters) {
            Position pos = monster.move();
            if (canMoveElement(pos))
                monster.setPosition(pos);
        }
    }

    public boolean verifyMonsterCollisions() {
        for (Monster monster : monsters)
            if (monster.position.equals(hero.position))
                return true;
        return false;
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
        for (Monster monster : monsters)
            monster.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
    }


    private int width, height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
}
