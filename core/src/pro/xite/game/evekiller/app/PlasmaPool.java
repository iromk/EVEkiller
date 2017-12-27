package pro.xite.game.evekiller.app;

import pro.xite.game.evekiller.matter.Plasma;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class PlasmaPool extends MatterPool<Plasma> {
    @Override
    protected Plasma newObject() {
        return new Plasma();
    }
}
