package com.aor.refactoring.example5.direction;

import com.aor.refactoring.example5.Turtle;

public class WestDirection extends Direction {
    @Override
    public void moveForward(Turtle turtle) {
        turtle.decreaseColumn();
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new SouthDirection());
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new NorthDirection());
    }

    @Override
    public char getDirection() {
        return 'W';
    }
}
