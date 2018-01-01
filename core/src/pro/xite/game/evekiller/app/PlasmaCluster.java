package pro.xite.game.evekiller.app;

import pro.xite.game.evekiller.matter.blueprints.arsenal.Plasma;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class PlasmaCluster extends MatterCluster<Plasma> {
    @Override
    protected Plasma newObject() {
        return new Plasma();
    }

    public Class getItemClass() {
        return Plasma.class;
    }
}
