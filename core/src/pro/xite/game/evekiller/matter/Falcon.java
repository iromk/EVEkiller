package pro.xite.game.evekiller.matter;

/**
 * Created by Roman Syrchin on 12/24/17.
 */

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletPool;
import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/22/17.
 */

public class Falcon extends GameMatter implements Movable, Shooter {

    static private final String FALCON_REF_NAME = "main_ship";

    Vector2 velocity = new Vector2();
    boolean moving = false;
    boolean shooting = false;

    Weapon mainWeapon;

    protected BulletPool bulletPool;


    public Falcon(Universe batch) {
        super();
//        super(REF_NAME);
        universe = batch;


        textures = Singularity.bangAndDiffuse(FALCON_REF_NAME,1,2,2);

        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        System.out.println(universe.bounds.getCenter());
        setWidth(35f);
        setHeight(35f / aspect);
        setCenter(universe.bounds.getCenter()); // FIXME possible bug point
        setBottom(15f);

//        universe = batch;
        setVelocity();

        this.bulletPool = new BulletPool();
        mainWeapon = new PlasmaGun(this, universe, bulletPool, new Vector2(0,0));

    }

    @Override
    public void resize(Rectangular worldBounds) {
//        getCenter().set(worldBounds.getCenter());
//        fix();
    }

    @Override
    public void update(float delta) {
        if (moving) move(delta);
        if (shooting) shoot();
        bulletPool.updateActiveSprites(delta);
        bulletPool.freeAllDestroyedActiveObjects();
    }

    public void draw() {
        super.draw();
        bulletPool.drawActiveObjects(universe);
    }

    protected void shoot() {
        mainWeapon.shoot();
    }

    public void stopAction(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
            case Input.Keys.RIGHT:
                velocity.setZero();
                moving = false;
                break;
            case Input.Keys.UP:
                shooting = false;
                break;
        }
    }

    public void actionLeft() {
        moving = true;
        velocity.set(-1f, 0f);
    }

    public void actionRight() {
        moving = true;
        velocity.set(1f, 0f);
    }

    public void actionPiupiu() {
        shooting = true;
        shoot();
    }

    @Override
    public void move(float delta) {
        setCenter(getCenter().add(velocity));
        if(velocity.len() > 0) {
            if (velocity.len() < 3) velocity.setLength(velocity.len()+0.03f);
//            System.out.println(velocity);
        }
//        fix();
    }

    @Override
    public void setVelocity() {
        velocity.setZero();
    }

    @Override
    public Vector2 getPosition() {
        return getCenter();
    }

    @Override
    public Vector2 getWeaponSlotPosition() {
        return null;
    }
}
