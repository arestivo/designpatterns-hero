package com.aor.strategy.strategies;

import com.aor.strategy.Arena;
import com.aor.strategy.enemies.Enemy;

public interface MoveStrategy {
    void move(Enemy enemy, Arena arena);
}
