package pro.xite.game.evekiller.matter.blueprints.arsenal;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.behaviours.Shooter;
import pro.xite.game.evekiller.matter.blueprints.fleet.WeaponSlot;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Weapon {

    int fittingType;

    int ammoMax;
    int ammoRemains;
    WeaponSlot slot;

    public Ammo ammo;
    public Shooter shooter;

    public float shootingRate = 3/(float)60;
    public float reloading = 0f;


    public int getFittingType() {
        return fittingType;
    }

    public void setFittingType(int fittingType) {
        this.fittingType = fittingType;
    }

    public Vector2 getPosition() {
        return shooter.getPosition().add(slot.shift());
    }

    public void arm(WeaponSlot weaponSlot) {
        slot = weaponSlot;
    }

    public void unarm() {
        slot = null;
        shooter = null;
    }

    public void reload() {

    }

    public void shoot() {

    }
}
