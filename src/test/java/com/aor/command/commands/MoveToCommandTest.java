package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveToCommandTest {

    @Test
    void execute() {
        Hero hero = new Hero(new Position(10, 10), 10);

        MoveToCommand moveToCommand = new MoveToCommand(hero, new Position(5, 5));
        moveToCommand.execute();

        assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void undo() {
        Hero hero = new Hero(new Position(10, 10), 10);

        MoveToCommand moveToCommand = new MoveToCommand(hero, new Position(5, 5));
        moveToCommand.execute();
        moveToCommand.undo();

        assertEquals(new Position(10, 10), hero.getPosition());
    }
}