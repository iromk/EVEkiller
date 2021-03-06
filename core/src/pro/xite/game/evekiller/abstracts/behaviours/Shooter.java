package pro.xite.game.evekiller.abstracts.behaviours;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.matter.blueprints.arsenal.Weapon;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public interface Shooter {

    public Vector2 getPosition();

    public Vector2 getWeaponSlotPosition();

    int getWeaponSlotsNumber();
    boolean fitWeapon(Weapon weapon);

}
