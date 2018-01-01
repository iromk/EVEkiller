package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.behaviours.Shooter;
import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.abstracts.behaviours.Movable;
import pro.xite.game.evekiller.darkmatter.Singularity;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Enemy extends Matter implements Movable, Shooter {

    protected Vector2 velocity;
    float hitPoints;

    public Enemy(Universe batch) {

        super();

        universe = batch;

        textures = Singularity.bangAndDiffuse("enemy0", 1, 2, 2);

        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        setWidth(35f);
        setHeight(35f / aspect);
//        setCenter(universe.bounds.getCenter());
        setX(Indeterminacy.nextFloat(35f, -35f + universe.bounds.width));
        setBottom(600f);
        velocity = new Vector2();
        hitPoints = 15;

        setVelocity();
        System.out.println("HOLD FIRE!!");

    }

    @Override
    public void update(float delta) {
        if(isDestroyed()) return;
//        if (moving)
            move(delta);
//        if (shooting) shoot();
//        bulletPool.updateActiveSprites(delta);
//        bulletPool.freeAllDestroyedActiveObjects();
    }

    public void draw() {
        if(isDestroyed()) return;
        super.draw();
//        bulletPool.draw(universe);
    }

    public void dealDamage(float damage) {

        System.out.println(hitPoints);

        hitPoints -= damage;

        if(hitPoints <= 0) destroy();

        return;

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

    @Override
    public Vector2 getVelocity(Vector2 newVelocity) {
        return newVelocity.set(velocity.x, velocity.y);
    }
}
