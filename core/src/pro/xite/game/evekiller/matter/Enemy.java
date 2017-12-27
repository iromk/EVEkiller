package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Enemy extends GameMatter implements Movable, Shooter {

    protected Vector2 velocity;

    public Enemy(Universe batch) {

        super();

        universe = batch;

        textures = Singularity.bangAndDiffuse("enemy0", 1, 2, 2);

        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        setWidth(35f);
        setHeight(35f / aspect);
        setCenter(universe.bounds.getCenter());
        setBottom(500f);
        velocity = new Vector2();

        setVelocity();

    }

    @Override
    public void update(float delta) {
//        if (moving)
            move(delta);
//        if (shooting) shoot();
//        bulletPool.updateActiveSprites(delta);
//        bulletPool.freeAllDestroyedActiveObjects();
    }

    public void draw() {
        super.draw();
//        bulletPool.drawActiveObjects(universe);
    }


    @Override
    public void move(float delta) {
        setCenter(getCenter().sub(velocity));
//        if(velocity.len() > 0) {
//            if (velocity.len() < 3) velocity.setLength(velocity.len()+0.03f);
//            System.out.println(velocity);
//        }
//        fix();
    }


    @Override
    public Vector2 getPosition() {
        return getCenter();
    }

    @Override
    public Vector2 getWeaponSlotPosition() {
        return null;
    }

    @Override
    public void setVelocity() {
        velocity.set(0, 2f);
    }
}
