package com.aor.command.commands;

import com.aor.command.Hero;
import com.aor.command.weapons.Weapon;

public class PickWeaponCommand extends HeroCommand {
    private final Weapon weapon;

    public PickWeaponCommand(Hero hero, Weapon weapon) {
        super(hero);
        this.weapon = weapon;
    }

    @Override
    public void execute() {
        getHero().addWeapon(this.weapon);
    }

    @Override
    public void undo() {
        getHero().removeWeapon(this.weapon);
    }
}
