package pro.xite.game.evekiller.matter;

/**
 * Created by Roman Syrchin on 12/24/17.
 */

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletPool;
import pro.xite.game.evekiller.darkmatter.Movable;

import pro.xite.game.evekiller.app.Regions;

/**
 * Created by Roman Syrchin on 12/22/17.
 */

public class Falcon extends GameMatter implements Movable {

    private Rectangular worldBounds;
    Vector2 velocity = new Vector2();

    protected BulletPool bulletPool;
    protected TextureRegion bulletRegion;


    public Falcon(SpriteBatch batch, Rectangular worldBounds) {
        super("main_ship");
        bulletRegion = Singularity.bang("bulletMainShip");
        TextureRegion[] regions = Regions.split(texture, 1, 2,2);
        texture = regions[0];
        universe = batch;
        this.worldBounds = worldBounds;
        setWidth(35f);
        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
        setHeight(35f / aspect);
//        setCenter(worldBounds.getCenter());
        getCenter().set(worldBounds.getCenter());
        fix();
        setBottom(15f);
        System.out.println(worldBounds);
        System.out.println(this);

        universe = batch;
        setVelocity();

        this.bulletPool = new BulletPool();

    }

    @Override
    public void resize(Rectangular worldBounds) {
//        getCenter().set(worldBounds.getCenter());
//        fix();
    }

    @Override
    public void update(float delta) {
        getCenter().add(velocity);
        if(velocity.len() > 0) {
            if (velocity.len() < 3) velocity.setLength(velocity.len()+0.03f);
//            System.out.println(velocity);
        }
        fix();
        bulletPool.updateActiveSprites(delta);
        bulletPool.freeAllDestroyedActiveObjects();
    }

    public void draw() {
        super.draw();
        bulletPool.drawActiveObjects(universe);
    }

    protected void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, getCenter(), new Vector2(0,500f), 35f, worldBounds, 1);
//        if (shootSound.play() == -1) {
//            throw new RuntimeException("shootSound.play() == -1");
//        }
    }

    public void stopActions() {
        velocity.setZero();
    }

    public void actionLeft() {
        velocity.set(-1f, 0f);
    }

    public void actionRight() {
        velocity.set(1f, 0f);
    }

    public void actionPiupiu() {
        shoot();
    }

    @Override
    public void move(float delta) {

    }

    @Override
    public void setVelocity() {
        velocity.setZero();
    }
}
