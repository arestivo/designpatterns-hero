package com.aor.command.potions;

import com.aor.command.Hero;

public class EnergyPotion extends Potion {

    @Override
    public void giveTo(Hero hero) {
        hero.setEnergy(hero.getEnergy() + 2);
    }
}
