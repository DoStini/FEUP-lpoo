package com.aor.refactoring.example5.direction;

import com.aor.refactoring.example5.Turtle;

public class SouthDirection extends Direction {
    @Override
    public void moveForward(Turtle turtle) {
        turtle.incrementRow();
    }

    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new EastDirection());
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new WestDirection());
    }

    @Override
    public char getDirection() {
        return 'S';
    }
}
