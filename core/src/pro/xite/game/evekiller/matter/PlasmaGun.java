package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.app.BulletPool;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class PlasmaGun extends Weapon {

    protected TextureRegion bulletRegion;

    BulletPool bulletPool;
    Universe universe;
    Vector2 slot;

    public PlasmaGun(Shooter shooter, Universe universe, BulletPool bulletPool, Vector2 slot) {
        bulletRegion = Singularity.bang("bulletMainShip");
        this.shooter = shooter;
        this.universe = universe;
        this.bulletPool = bulletPool;
        this.slot = slot;
    }

    @Override
    public void shoot() {
        super.shoot();
        if (reloading <= 0f) {
            reloading = 1f;
            Bullet bullet = bulletPool.obtain();
            bullet.set(this, bulletRegion,
                    shooter.getPosition().add(slot), new Vector2(0, 500f),
                    35f,
                    universe.bounds, 1);
        } else {
            reloading -= shootingRate;
        }
    //        if (shootSound.play() == -1) {
    //            throw new RuntimeException("shootSound.play() == -1");
    //        }
    }


}
