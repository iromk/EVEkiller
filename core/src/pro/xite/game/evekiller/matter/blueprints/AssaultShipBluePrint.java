package pro.xite.game.evekiller.matter.blueprints;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.darkmatter.Singularity;
import pro.xite.game.evekiller.matter.blueprints.fleet.WeaponSlot;

/**
 * Created by Roman Syrchin on 1/5/18.
 */

public class AssaultShipBluePrint extends ShipBluePrint {

    @Override
    public String id() {
        return "enemy0";
    }

    @Override
    public String name() {
        return "Assault Frigate";
    }

    public TextureRegion[] model() {
        return Singularity.bangAndDiffuse(id(), 1, 2, 2);
    }

    public float hp() {
        return 25f;
    }

    public float width() {
        return 35f;
    }

    public float height() {
        TextureRegion model = model()[0];
        return width() * model.getRegionHeight() / model.getRegionWidth();
    }

    public int weaponSlotsNumber() {
        return 1;
    }

    public WeaponSlot[] weaponSlots() {
        WeaponSlot[] slots = new WeaponSlot[weaponSlotsNumber()];
        slots[0] = new WeaponSlot(WeaponSlot.TYPE1_ENERGETIC, new Vector2(0, 0));
        return slots;
    }

}
