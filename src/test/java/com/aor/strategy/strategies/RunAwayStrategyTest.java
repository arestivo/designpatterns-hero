package com.aor.strategy.strategies;

import com.aor.strategy.Arena;
import com.aor.strategy.Hero;
import com.aor.strategy.Position;
import com.aor.strategy.enemies.Spider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RunAwayStrategyTest {

    @Test
    void move() {
        Arena arena = new Arena();
        Hero hero = arena.getHero();

        Spider spider = new Spider(new Position(5, 5), new RunAwayStrategy(), null);

        for (int i = 0; i < 3; i++) {
            double distanceBefore = spider.getPosition().distanceTo(hero.getPosition());
            spider.move(arena);
            double distanceAfter = spider.getPosition().distanceTo(hero.getPosition());

            assertTrue(distanceAfter > distanceBefore);
        }
    }
}