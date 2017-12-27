package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletPool;
import pro.xite.game.evekiller.app.PlasmaPool;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Universe extends SpriteBatch {

    public Rectangular bounds;

    public PlasmaPool plasmaPool;
    public BulletPool bulletPool;

    public Universe() {
        super();
        bounds = new Rectangular();
    }

    public Universe(Rectangular bounds) {
        super();
        this.bounds = bounds;
    }

    public Rectangular getBounds() {
        return bounds;
    }

    public void setBounds(Rectangular bounds) {
        this.bounds = bounds;
    }



}
