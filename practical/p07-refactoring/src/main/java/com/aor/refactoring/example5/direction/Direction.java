package com.aor.refactoring.example5.direction;

import com.aor.refactoring.example5.Turtle;

public abstract class Direction {

    public static Direction createDirection(char direction) {
        if (direction == 'N')
            return new WestDirection();
        if (direction == 'E')
            return  new EastDirection();
        if (direction == 'N')
            return  new NorthDirection();
        else
            return new SouthDirection();
    }

    public abstract void moveForward(Turtle turtle);
    public abstract void rotateLeft(Turtle turtle);
    public abstract void rotateRight(Turtle turtle);
    public abstract char getDirection();
}
