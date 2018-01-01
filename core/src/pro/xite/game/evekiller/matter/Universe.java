package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.BulletCluster;
import pro.xite.game.evekiller.app.ExplosionCluster;
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

//    public PlasmaCluster plasmaPool;
//    public BulletCluster bulletPool;

    public Universe() {
        super();
        bounds = new Rectangular();
        superCluster = new SuperCluster(this);

        setupClusters();
    }

    private void setupClusters() {
        superCluster.add(
                new BulletCluster(),
                new PlasmaCluster(),
                new ExplosionCluster()
//                new StarCluster()
//                new EnemyCluster(),

                );
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

    public MatterCluster getCluster(Class clusterClass) {
        return superCluster.getCluster(clusterClass);
    }

    public void add(MatterCluster matterCluster) {
        superCluster.add(matterCluster);
    }

    public void draw(Class ofClass) {
        superCluster.drawActiveObjects(ofClass);
    }

    public void update(float delta) {
        superCluster.update(delta);
    }

    public Matter obtainFromSupercluster(Class objectClass) {
        return superCluster.obtain(objectClass);
    }

    public Rectangular getBounds() {
        return bounds;
    }

    public void setBounds(Rectangular bounds) {
        this.bounds = bounds;
    }



}
