package pro.xite.game.evekiller.darkmatter;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.matter.SelfDrawable;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public interface Movable {

    Vector2 velocity = new Vector2();

    public void move(float delta);

    void setVelocity();

}
