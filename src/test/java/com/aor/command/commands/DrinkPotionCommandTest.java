package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;
import com.aor.command.potions.EnergyPotion;
import com.aor.command.potions.PoisonPotion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrinkPotionCommandTest {

    @Test
    void executeEnergy() {
        Hero hero = new Hero(new Position(10, 10), 10);

        DrinkPotionCommand drinkPotionCommand = new DrinkPotionCommand(hero, new EnergyPotion());
        drinkPotionCommand.execute();

        assertEquals(12, hero.getEnergy());
    }

    @Test
    void executePoison() {
        Hero hero = new Hero(new Position(10, 10), 10);

        DrinkPotionCommand drinkPotionCommand = new DrinkPotionCommand(hero, new PoisonPotion());
        drinkPotionCommand.execute();

        assertEquals(5, hero.getEnergy());
    }

    @Test
    void undo() {
        Hero hero = new Hero(new Position(10, 10), 10);

        DrinkPotionCommand drinkEnergyPotionCommand = new DrinkPotionCommand(hero, new EnergyPotion());
        DrinkPotionCommand drinkPoisonPotionCommand = new DrinkPotionCommand(hero, new PoisonPotion());

        drinkPoisonPotionCommand.execute();
        drinkEnergyPotionCommand.execute();

        assertEquals(7, hero.getEnergy());

        drinkEnergyPotionCommand.undo();
        drinkPoisonPotionCommand.undo();

        assertEquals(10, hero.getEnergy());
    }
}