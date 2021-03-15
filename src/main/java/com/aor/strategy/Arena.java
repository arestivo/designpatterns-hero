package com.aor.strategy;

import com.aor.strategy.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final Hero hero;
    private final List<Enemy> enemies;

    public Arena() {
        this.hero = new Hero(new Position(10, 10), 10);
        this.enemies = new ArrayList<>();
    }

    public Hero getHero() {
        return hero;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
