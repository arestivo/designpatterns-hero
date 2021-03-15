package com.aor.strategy.strategies;

import com.aor.strategy.Arena;
import com.aor.strategy.Hero;
import com.aor.strategy.Position;
import com.aor.strategy.enemies.Enemy;

public class RunAwayStrategy implements MoveStrategy {
    @Override
    public void move(Enemy enemy, Arena arena) {
        Hero hero = arena.getHero();
        Position position = hero.getPosition();

        if (Math.random() < 0.5) {
            int distance = hero.getPosition().getX() - position.getX();
            if ((distance < 0)) hero.moveLeft();
            else hero.moveRight();
        } else {
            int distance = hero.getPosition().getY() - position.getY();
            if (distance < 0) hero.moveUp();
            else hero.moveDown();
        }
    }
}
