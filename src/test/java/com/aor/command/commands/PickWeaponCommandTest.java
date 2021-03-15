package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;
import com.aor.command.weapons.Staff;
import com.aor.command.weapons.Sword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PickWeaponCommandTest {

    @Test
    void execute() {
        Hero hero = new Hero(new Position(10, 10), 10);

        PickWeaponCommand pickWeaponCommand = new PickWeaponCommand(hero, new Sword());
        pickWeaponCommand.execute();

        assertEquals(1, hero.getInventory().size());
    }

    @Test
    void undo() {
        Hero hero = new Hero(new Position(10, 10), 10);

        PickWeaponCommand pickWeaponCommand1 = new PickWeaponCommand(hero, new Sword());
        PickWeaponCommand pickWeaponCommand2 = new PickWeaponCommand(hero, new Staff());

        pickWeaponCommand1.execute();
        pickWeaponCommand2.execute();

        assertEquals(2, hero.getInventory().size());

        pickWeaponCommand2.undo();
        assertEquals(1, hero.getInventory().size());

        pickWeaponCommand1.undo();
        assertEquals(0, hero.getInventory().size());
    }
}