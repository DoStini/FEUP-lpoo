package com.aor.refactoring.example5;

import com.aor.refactoring.example5.direction.*;

public class Turtle {
    private int row;
    private int column;

    private Direction direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = Direction.createDirection(direction);
    }

    public int getRow() {
        return row;
    }

    public void incrementRow() {
        this.row++;
    }

    public void decreaseRow() {
        this.row--;
    }

    public void incrementColumn() {
        this.column++;
    }

    public void decreaseColumn() {
        this.column--;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction.getDirection();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void execute(char command) {
        if (command == 'L') {
            rotateLeft();
        } else if (command == 'R') {
            rotateRight();
        } else if (command == 'F'){
            moveForward();
        }
    }

    private void moveForward() {
        direction.moveForward(this);
    }

    private void rotateRight() {
        direction.rotateRight(this);
    }

    private void rotateLeft() {
        direction.rotateLeft(this);
    }
}
