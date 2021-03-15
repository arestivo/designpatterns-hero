package com.aor.strategy.strategies;

import com.aor.strategy.Arena;
import com.aor.strategy.Position;
import com.aor.strategy.enemies.Spider;
import com.aor.strategy.weapons.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UseWeaponFirstStrategyTest {

    @Test
    void noWeapon() {
        Arena arena = new Arena();

        Spider spider = new Spider(new Position(10, 10), null, new UseWeaponFirstStrategy());
        spider.attack(arena);

        assertEquals(9, arena.getHero().getEnergy());
    }

    @Test
    void weapon() {
        Arena arena = new Arena();

        Spider spider = new Spider(new Position(10, 10), null, new UseWeaponFirstStrategy());
        spider.pick(new Sword());

        spider.attack(arena);

        assertEquals(8, arena.getHero().getEnergy());
    }

}