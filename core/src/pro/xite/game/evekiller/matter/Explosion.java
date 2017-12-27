package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class Explosion extends GameMatter implements Movable {

    protected Vector2 velocity;

    public Explosion(Universe universe, Movable object) {
        textures = Singularity.bangAndDiffuse("explosion", 9, 9, 74);
        System.out.println(textures.length);
        this.universe = universe;
        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        setWidth(65f);
        setHeight(65f / aspect);
        setCenter(object.getCenter());
        frame = 0;
        velocity = new Vector2();
        setVelocity(object.getVelocity(velocity));
    }

    @Override
    public void move(float delta) {
        setCenter(getCenter().sub(velocity));
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(frame == textures.length - 1) destroy();
        frame += 1;
        move(delta);
        System.out.println(getCenter());
    }

    @Override
    public void setVelocity() {

    }

    public void setVelocity(Vector2 newVelocity) {
        velocity.set(newVelocity.x, newVelocity.y);
    }

    @Override
    public Vector2 getVelocity(Vector2 newVelocity) {
        return newVelocity.set(velocity.x, velocity.y);
    }
}
