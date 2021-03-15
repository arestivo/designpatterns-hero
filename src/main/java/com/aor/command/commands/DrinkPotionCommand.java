package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.potions.Potion;

public class DrinkPotionCommand extends HeroCommand {
    private final Potion potion;
    private final int originalEnergy;

    public DrinkPotionCommand(Hero hero, Potion potion) {
        super(hero);
        this.potion = potion;
        this.originalEnergy = hero.getEnergy();
    }

    @Override
    public void execute() {
        potion.giveTo(getHero());
    }

    @Override
    public void undo() {
        getHero().setEnergy(this.originalEnergy);
    }
}
