package com.aor.command.commands;

import com.aor.command.Hero;

public abstract class HeroCommand {
    private final Hero hero;

    public HeroCommand(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public abstract void execute();

    public abstract void undo();
}
