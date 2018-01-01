package pro.xite.game.evekiller.app;

import pro.xite.game.evekiller.matter.Explosion;
import pro.xite.game.evekiller.matter.Matter;

/**
 * Created by Roman Syrchin on 1/1/18.
 */

public class ExplosionCluster extends MatterCluster<Explosion> {

    @Override
    protected Explosion newObject() {
        return new Explosion();
    }

    @Override
    public Class getItemClass() {
        return Explosion.class;
    }
}
