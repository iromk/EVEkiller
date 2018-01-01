package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletCluster;
import pro.xite.game.evekiller.app.MatterCluster;
import pro.xite.game.evekiller.app.PlasmaCluster;
import pro.xite.game.evekiller.app.SuperClusterIterator;
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
        superCluster = new SuperCluster(this);
    }

    public Universe(Rectangular bounds) {
        super();
        this.bounds = bounds;
    }

    public void set(SuperCluster superCluster) {
        this.superCluster = superCluster;
    }

    public SuperClusterIterator getSuperClusterIterator(Class forClass) {
        return superCluster.getIterator(forClass);
    }

    public void add(MatterCluster matterCluster) {
        superCluster.add(matterCluster);
    }

    public void drawActiveObjects(Class ofClass) {
        superCluster.drawActiveObjects(ofClass);
    }

    public Matter obtainFromSuperCluster(Class objectClass) {
        return superCluster.obtain(objectClass);
    }

    public Rectangular getBounds() {
        return bounds;
    }

    public void setBounds(Rectangular bounds) {
        this.bounds = bounds;
    }



}
