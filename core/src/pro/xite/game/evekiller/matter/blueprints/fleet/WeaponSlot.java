package pro.xite.game.evekiller.matter.blueprints.fleet;

import com.badlogic.gdx.math.Vector2;

import org.w3c.dom.ranges.RangeException;

import pro.xite.game.evekiller.abstracts.behaviours.Shooter;
import pro.xite.game.evekiller.matter.blueprints.arsenal.Weapon;

/**
 * Created by Roman Syrchin on 1/5/18.
 */

public class WeaponSlot {

    /**
     * Slot types as a binary value.
     */
    public static int UNIVERSAL = ~0;
    public static int TYPE1_ENERGETIC = 0x1;
    public static int TYPE2_KINETIC = 0x2;
    public static int TYPE3_LAUNCHER = 0x4;

    int type;
    Weapon weapon;

    /**
     * Relative shift on a ship model center point.
     */
    Vector2 position;

    public WeaponSlot(int type) {
        this.type = type;
    }

    public WeaponSlot(Vector2 position) {
        this.position = position;
        this.type = UNIVERSAL;
    }

    public WeaponSlot(int type, Vector2 position) {
        this.position = position;
        this.type = type;
    }

    public Vector2 shift() {
        return position;
    }

    boolean fits(Weapon weapon) {
        return 0 != (this.type & weapon.getFittingType());
    }

    public void attach(Weapon weapon) {
        if(!fits(weapon))
            throw new RuntimeException("Given Weapon doesn't match the slot.");
        detach();
        this.weapon = weapon;
        weapon.arm(this);
    }

    public Weapon weapon() {
        return weapon;
    }

    void detach() {
        if(weapon != null) {
            weapon.unarm();
            weapon = null;
        }
    }
}
