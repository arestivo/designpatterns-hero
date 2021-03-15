package com.aor.strategy;

public class Hero {
    private final Position position;
    private int energy;

    public Hero(Position position, int energy) {
        this.position = position;
        this.energy = energy;
    }

    public Position getPosition() {
        return position;
    }

    public int getEnergy() {
        return energy;
    }

    public void moveUp() {
        this.position.moveUp();
    }

    public void moveRight() {
        this.position.moveRight();
    }

    public void moveDown() {
        this.position.moveDown();
    }

    public void moveLeft() {
        this.position.moveLeft();
    }

    public void decreaseEnergy(int value) {
        this.energy -= value;
    }
}
