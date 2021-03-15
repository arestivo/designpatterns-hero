# Design Pattern Examples

A set of design pattern examples all about heroes, arenas, and monsters, completely unit-tested.

## Factory-Method

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/factorymethod) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/factorymethod)

How *enemies* can use a **factory method** to decide what weapon they use in battle. 
The *abstract* **Enemy** class has an *abstract* **createWeapon** method overridden 
by the concrete enemy classes; each returning a different weapon. When attacking 
the hero, enemies use whichever weapon was selected by the **createWeapon** method.

```
public abstract class Enemy {
  private final Weapon weapon;
  public Enemy() { this.weapon = createWeapon(); }
  protected abstract Weapon createWeapon();
  public void attack(Hero hero) { weapon.attack(hero); }
}
```

Concrete enemy class **Spider** overriding the **createWeapon** method and returning two 
dangerous fangs as its weapon of choice:

```
public class Spider extends Enemy {
    @Override
    protected Weapon createWeapon() {
        return new Fang(2);
    }
}
```

## Composite

[Code](https://github.com/arestivo/designpatterns-hero/tree/master/src/main/java/com/aor/composite) | [Tests](https://github.com/arestivo/designpatterns-hero/tree/master/src/test/java/com/aor/composite)

How a hoard of enemies can behave as a single enemy by using the *composite* pattern.
A hoard of enemies contains a list of enemies (that can be of many different types) 
but is also itself an enemy.

```
public Hoard(Position position) {
  super(position);
    this.enemies = new ArrayList<>();
  }
}
```

When moving, all enemies in the hoard move at the same time, when attacking they unite
as a single foe:

```
public void moveUp() {
  super.moveUp();
    for (Enemy enemy : enemies) enemy.getPosition().moveTo(getPosition());
}

public void attack(Hero hero) {
  for (Enemy enemy : enemies)
    enemy.attack(hero);
}
```
