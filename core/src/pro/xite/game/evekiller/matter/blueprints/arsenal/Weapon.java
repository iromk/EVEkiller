package pro.xite.game.evekiller.matter.blueprints.arsenal;

import pro.xite.game.evekiller.abstracts.behaviours.Shooter;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Weapon {

    int ammoMax;
    int ammoRemains;

    public Ammo ammo;
    public Shooter shooter;

    public float shootingRate = 3/(float)60;
    public float reloading = 0f;


    public void reload() {

    }

    public void shoot() {

    }
}
