package io.github.dostini.lpoo.hero.game.screens;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import io.github.dostini.lpoo.hero.datatype.Position;
import io.github.dostini.lpoo.hero.element.*;
import io.github.dostini.lpoo.hero.game.screens.GameScreen;
import io.github.dostini.lpoo.hero.game.screens.GameState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena extends GameScreen {
    public Arena(int width, int height) {
        super(width,height);
        hero = new Hero(10,10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createEnemies();
        this.door = createDoor();
    }

    @Override
    public GameState run(KeyStroke key) throws IOException {
        processKey(key);
        handleEnemies();
        verifyMonsterCollisions();
        retrieveCoins();
        if (!hero.isAlive())
            return GameState.LOSE;
        if (coins.isEmpty()) {
            door.setVisible(true);
            if (door.getPosition().equals(hero.getPosition()))
                return GameState.WIN;
        }

        return GameState.RUNNING;
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

    private Door createDoor() {
        Random random = new Random();
        Position pos;
        do {
            pos = new Position(random.nextInt(width-1), random.nextInt(height-1));
        }
        while (isWall(pos));

        return new Door(pos.getX(), pos.getY());
    }

    private List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();

        Random random = new Random();

        int numCoins = random.nextInt(10)+5;

        for (int i = 0; i < numCoins;) {
            Position pos = new Position(random.nextInt(width-1), random.nextInt(height-1));
            if(!isWall(pos) && !coins.contains(new Coin(pos.getX(), pos.getY())) && !pos.equals(hero.getPosition())) {
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
            if(!isWall(pos) && !pos.equals(hero.getPosition())) {
                enemies.add(new Monster(pos.getX(), pos.getY(), random.nextInt(10)+5));
                i++;
            }
        }

        return enemies;
    }

    public void retrieveCoins () {
        int coin = coinIdx(hero.getPosition());

        if (coin != -1) {
            coins.remove(coin);
            hero.increaseCoins();
        }
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

    public void verifyMonsterCollisions() {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(hero.getPosition())) {
                hero.decreaseHP(monster.getStrenght());
            }
    }

    public boolean verifyEndGame() {
        return !hero.isAlive() || coins.isEmpty();
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

    @Override
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
        door.draw(graphics);

        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#ffffff"));
        graphics.putString(width + 10,height/2 - 3,
                "Score: " + String.valueOf(hero.getCoins()));
        graphics.putString(width + 10,height/2 + 3,
                "Health: " + String.valueOf(hero.getHp()));
    }


    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private Door door;
}
