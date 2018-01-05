package pro.xite.game.evekiller.matter.blueprints;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pro.xite.game.evekiller.matter.blueprints.fleet.WeaponSlot;

/**
 * Created by Roman Syrchin on 1/5/18.
 */

abstract class ShipBluePrint implements BluePrint {

    abstract float hp();
    abstract TextureRegion[] model();
    abstract float width();
    abstract float height();

    public int weaponSlotsNumber() {
        return 0;
    }

    public WeaponSlot[] weaponSlots() {
        return null;
    }

    public String toString() {
        return "Spaceship " + name();
    }

}
