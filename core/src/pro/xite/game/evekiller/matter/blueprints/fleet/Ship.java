package pro.xite.game.evekiller.matter.blueprints.fleet;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.matter.Matter;
import pro.xite.game.evekiller.abstracts.behaviours.Movable;
import pro.xite.game.evekiller.abstracts.behaviours.Shooter;

/**
 * Created by Roman Syrchin on 12/30/17.
 */

public class Ship extends Matter implements Movable, Shooter {


    @Override
    public void move(float delta) {

    }

    @Override
    public void setVelocity() {

    }

    @Override
    public Vector2 getVelocity(Vector2 velocity) {
        return null;
    }

    @Override
    public Vector2 getPosition() {
        return null;
    }

    @Override
    public Vector2 getWeaponSlotPosition() {
        return null;
    }
}
