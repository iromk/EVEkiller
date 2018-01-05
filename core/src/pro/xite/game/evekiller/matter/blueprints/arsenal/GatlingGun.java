package pro.xite.game.evekiller.matter.blueprints.arsenal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.behaviours.Shooter;
import pro.xite.game.evekiller.darkmatter.Singularity;
import pro.xite.game.evekiller.matter.Universe;
import pro.xite.game.evekiller.matter.blueprints.fleet.WeaponSlot;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class GatlingGun extends Weapon {
    protected TextureRegion bulletRegion;

    Sound bulletSound;

    Universe universe;
    Vector2 slot;

    public GatlingGun(Shooter shooter, Universe universe, Vector2 slot,
                      float rate, float reloaing) {
        bulletRegion = Singularity.bang("bulletMainShip");
        bulletSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gun.wav"));

        this.shooter = shooter;
        this.universe = universe;
        this.reloading = reloaing;
        this.shootingRate = rate;
        this.slot = slot;
        this.fittingType = WeaponSlot.TYPE2_KINETIC;
    }

    @Override
    public void shoot() {
        super.shoot();
        if (reloading <= 0f) {
            reloading = 1f;
            Bullet bullet = (Bullet) universe.obtainFromSupercluster(Bullet.class);
            bullet.set(shooter, bulletRegion,
                    shooter.getPosition().add(slot), new Vector2(0, 800f),
                    12f,
                    universe.bounds, 1);
            bulletSound.play(0.4f);
        } else {
            reloading -= shootingRate;
        }
        //        if (shootSound.play() == -1) {
        //            throw new RuntimeException("shootSound.play() == -1");
        //        }
    }

}
