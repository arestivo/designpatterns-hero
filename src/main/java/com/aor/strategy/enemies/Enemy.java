package com.aor.strategy.enemies;

import com.aor.strategy.Arena;
import com.aor.strategy.Hero;
import com.aor.strategy.Position;
import com.aor.strategy.strategies.AttackStrategy;
import com.aor.strategy.strategies.MoveStrategy;
import com.aor.strategy.weapons.Weapon;

public abstract class Enemy {
    private final Position position;
    private final MoveStrategy moveStrategy;
    private final AttackStrategy attackStrategy;
    private Weapon weapon;

    public Enemy(Position position, MoveStrategy moveStrategy, AttackStrategy attackStrategy) {
        this.position = position;
        this.moveStrategy = moveStrategy;
        this.attackStrategy = attackStrategy;
    }

    /**
     * Moves according to the current move strategy.
     * @param arena The arena the enemy is moving on.
     */
    public void move(Arena arena) {
        this.moveStrategy.move(this, arena);
    }

    /**
     * Attacks the hero according to the current attack strategy.
     * @param arena The arena the enemy is attacking on.
     */
    public void attack(Arena arena) {
        this.attackStrategy.attack(this, arena.getHero());
    }

    public void pick(Weapon weapon) {
        this.weapon = weapon;
    }

    public void moveTo(Position position) {
        position.moveTo(position);
    }

    public Position getPosition() {
        return position;
    }

    public boolean hasWeapon() {
        return weapon != null;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void punch(Hero hero) {
        hero.decreaseEnergy(1);
    }

    public void moveUp() {
        this.position.moveUp();
    }

    public void moveRight() {
        this.position.moveRight();
    }

    public void moveDown() {
        this.position.moveDown();
    }

    public void moveLeft() {
        this.position.moveLeft();
    }
}
