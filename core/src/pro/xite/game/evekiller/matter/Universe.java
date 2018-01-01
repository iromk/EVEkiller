package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletCluster;
import pro.xite.game.evekiller.app.PlasmaCluster;
import pro.xite.game.evekiller.darkmatter.SuperCluster;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Universe extends SpriteBatch {

    public Rectangular bounds;

    SuperCluster superCluster;

    public PlasmaCluster plasmaPool;
    public BulletCluster bulletPool;

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
