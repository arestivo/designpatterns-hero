package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.Position;

public class MoveToCommand extends HeroCommand {
    private final Position oldPosition;
    private final Position newPosition;

    public MoveToCommand(Hero hero, Position position) {
        super(hero);
        this.newPosition = position;
        this.oldPosition = new Position(0, 0);
        this.oldPosition.moveTo(hero.getPosition());
    }

    @Override
    public void execute() {
        getHero().moveTo(newPosition);
    }

    @Override
    public void undo() {
        getHero().moveTo(oldPosition);
    }
}
