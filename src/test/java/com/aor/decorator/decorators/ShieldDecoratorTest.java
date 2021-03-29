package com.aor.decorator.decorators;

import com.aor.decorator.BasicHero;
import com.aor.decorator.Monster;
import com.aor.decorator.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShieldDecoratorTest {
    private Hero hero;
    private Monster monster;

    @BeforeEach
    void setUp() {
        hero = new ShieldDecorator(new BasicHero(new Position(10, 10), 10));
        monster = new Monster(10, 3);
    }

    @Test
    void attack() {
        hero.attack(monster);
        assertEquals(9, monster.getEnergy());
    }

    @Test
    void defend() {
        hero.defend(monster);
        assertEquals(9, hero.getEnergy());
    }

    @Test
    void decreaseEnergy() {
        hero.decreaseEnergy(2);
        assertEquals(8, hero.getEnergy());
    }

}