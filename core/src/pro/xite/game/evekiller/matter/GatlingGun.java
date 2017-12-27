package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.app.BulletPool;
import pro.xite.game.evekiller.app.PlasmaPool;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class GatlingGun extends Weapon {
    protected TextureRegion bulletRegion;

    BulletPool bulletPool;
    Universe universe;
    Vector2 slot;

    public GatlingGun(Shooter shooter, Universe universe, BulletPool bulletPool, Vector2 slot,
                     float rate, float reloaing) {
        bulletRegion = Singularity.bang("bulletMainShip");
        this.shooter = shooter;
        this.universe = universe;
        this.bulletPool = bulletPool;
        this.reloading = reloaing;
        this.shootingRate = rate;
        this.slot = slot;
    }

    @Override
    public void shoot() {
        super.shoot();
        if (reloading <= 0f) {
            reloading = 1f;
            Bullet bullet = bulletPool.obtain();
            bullet.set(shooter, bulletRegion,
                    shooter.getPosition().add(slot), new Vector2(0, 800f),
                    12f,
                    universe.bounds, 1);
        } else {
            reloading -= shootingRate;
        }
        //        if (shootSound.play() == -1) {
        //            throw new RuntimeException("shootSound.play() == -1");
        //        }
    }

}
