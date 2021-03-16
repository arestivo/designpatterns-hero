package com.aor.strategy.enemies;

import com.aor.strategy.Arena;
import com.aor.strategy.Position;
import com.aor.strategy.strategies.AlwaysPunchStrategy;
import com.aor.strategy.strategies.FindHeroStrategy;
import com.aor.strategy.strategies.UseWeaponFirstStrategy;
import com.aor.strategy.weapons.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiderTest {
    @Test
    void testSpiderWithSword() {
        Arena arena = new Arena();

        Spider spider = new Spider(new Position(5, 5), new FindHeroStrategy(), new UseWeaponFirstStrategy());
        spider.pick(new Sword());

        // Spider should find hero in less than 20 moves
        int remaining = 20;
        while (remaining-- > 0 && !spider.getPosition().equals(arena.getHero().getPosition()))
            spider.move(arena);

        // 5 attacks from the sword should be enough
        for (int i = 0; i < 5; i++)
            spider.attack(arena);

        assertEquals(0, arena.getHero().getEnergy());
    }

    @Test
    void testSpiderWithoutSword() {
        Arena arena = new Arena();

        Spider spider = new Spider(new Position(5, 5), new FindHeroStrategy(), new UseWeaponFirstStrategy());

        // Spider should find hero in less than 20 moves
        int remaining = 20;
        while (remaining-- > 0 && !spider.getPosition().equals(arena.getHero().getPosition()))
            spider.move(arena);

        // 5 punches should not be enough
        for (int i = 0; i < 5; i++)
            spider.attack(arena);

        assertEquals(5, arena.getHero().getEnergy());
    }

    @Test
    void punchySpider() {
        Arena arena = new Arena();

        Spider spider = new Spider(new Position(5, 5), new FindHeroStrategy(), new AlwaysPunchStrategy());
        spider.pick(new Sword());

        // Spider should find hero in less than 20 moves
        int remaining = 20;
        while (remaining-- > 0 && !spider.getPosition().equals(arena.getHero().getPosition()))
            spider.move(arena);

        // should punch even with a sword
        for (int i = 0; i < 5; i++)
            spider.attack(arena);

        assertEquals(5, arena.getHero().getEnergy());
    }
}