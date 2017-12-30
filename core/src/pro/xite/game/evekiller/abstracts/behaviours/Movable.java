package pro.xite.game.evekiller.abstracts.behaviours;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public interface Movable {


    public void move(float delta);

    void setVelocity();
    Vector2 getVelocity(Vector2 velocity);
    Vector2 getCenter();

}
