package pro.xite.game.evekiller.matter;

/**
 * Created by Roman Syrchin on 12/24/17.
 */

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.behaviours.Shooter;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletCluster;
import pro.xite.game.evekiller.abstracts.behaviours.Movable;
import pro.xite.game.evekiller.darkmatter.Singularity;
import pro.xite.game.evekiller.matter.blueprints.AssaultShipBluePrint;
import pro.xite.game.evekiller.matter.blueprints.arsenal.GatlingGun;
import pro.xite.game.evekiller.matter.blueprints.arsenal.PlasmaGun;
import pro.xite.game.evekiller.matter.blueprints.arsenal.Weapon;
import pro.xite.game.evekiller.matter.blueprints.fleet.Ship;
import pro.xite.game.evekiller.matter.blueprints.fleet.WeaponSlot;

/**
 * Created by Roman Syrchin on 12/22/17.
 */

public class Falcon extends Ship implements Movable, Shooter {

    static private final String FALCON_REF_NAME = "main_ship";

    Vector2 velocity = new Vector2();
    boolean moving = false;
    boolean shooting = false;

    Weapon leftWeapon;
    Weapon rightWeapon;
    Weapon centerWeapon;

    protected BulletCluster bulletPool;


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

//        this.bulletPool = new BulletCluster();
//        leftWeapon = new PlasmaGun(this, universe, bulletPool, new Vector2(0,0));
        AssaultShipBluePrint bp = new AssaultShipBluePrint();
        this.weaponSlots = bp.weaponSlots();
        leftWeapon = new PlasmaGun(this, universe, new Vector2(-15f,0), 1/(float)60, 0f);
        rightWeapon = new PlasmaGun(this, universe, new Vector2(15f,0), 1/(float)60, 1f);
        centerWeapon = new GatlingGun(this, universe, new Vector2(0f,0), 6/(float)60, 0f);
        centerWeapon.setFittingType(WeaponSlot.UNIVERSAL);
        leftWeapon.setFittingType(WeaponSlot.UNIVERSAL);
        weaponSlots[0].attach(leftWeapon);

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
//        bulletPool.updateActiveSprites(delta);
//        bulletPool.freeAllDestroyedActiveObjects();
    }

    public void draw() {
        super.draw();
//        bulletPool.draw(universe);
    }

    protected void shoot() {
//        leftWeapon.shoot();
//        rightWeapon.shoot();
//        centerWeapon.shoot();
        weaponSlots[0].weapon().shoot();
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
    public Vector2 getVelocity(Vector2 velocity) {
        return null;
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
