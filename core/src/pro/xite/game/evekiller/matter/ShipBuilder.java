package pro.xite.game.evekiller.matter;

import pro.xite.game.evekiller.matter.blueprints.arsenal.Weapon;
import pro.xite.game.evekiller.matter.blueprints.fleet.Ship;

/**
 * Created by Roman Syrchin on 1/5/18.
 */

public class ShipBuilder {

    private Ship spaceShip;

    public ShipBuilder() {
        spaceShip = new Ship();
    }

    public Ship make() {
        return spaceShip;
    }

    public ShipBuilder type() {
        return this;
    }

    public ShipBuilder add(Weapon w) {
        return this;
    }

    public ShipBuilder hp(float hp) {
        return this;
    }

    public ShipBuilder shield(float shield) {
        return this;
    }

}
