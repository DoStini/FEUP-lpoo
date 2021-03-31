package com.aor.refactoring.example5.direction;

import com.aor.refactoring.example5.Turtle;

public class EastDirection extends Direction {
    @Override
    public void moveForward(Turtle turtle) {
        turtle.incrementColumn();
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new NorthDirection());
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new SouthDirection());
    }

    @Override
    public char getDirection() {
        return 'E';
    }
}
