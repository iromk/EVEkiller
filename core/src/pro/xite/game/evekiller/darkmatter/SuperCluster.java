package pro.xite.game.evekiller.darkmatter;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import pro.xite.game.evekiller.app.MatterCluster;
import pro.xite.game.evekiller.app.SuperClusterIterator;
import pro.xite.game.evekiller.matter.Matter;

/**
 * Created by Roman Syrchin on 12/30/17.
 */

public class SuperCluster {

    HashMap<List<Class>, MatterCluster> clustersByClasses = new HashMap<List<Class>, MatterCluster>();

    SpriteBatch universe;

    public SuperCluster(SpriteBatch spriteBatch) {
        universe = spriteBatch;
    }

    public void add(MatterCluster matterPool) {
        List<Class> classes = new ArrayList<Class>();

        Class itemClass = matterPool.getItemClass();
        do {
            System.out.println("adding " + itemClass);
            classes.add(itemClass);
            itemClass = itemClass.getSuperclass();
        } while(itemClass != Matter.class);

/*
        System.out.println("added " + matterPool.getItemClass() +
                            " extends " + matterPool.getItemClass().getSuperclass() +
                            " extends " + matterPool.getItemClass().getSuperclass().getSuperclass()
        );
*/
        clustersByClasses.put(classes, matterPool);

    }

    public Set<List<Class>> getClassesList() {
        return clustersByClasses.keySet();
    }

    public SuperClusterIterator getIterator(Class criteria) {
        return new SuperClusterIterator(this, criteria);
    }

    public MatterCluster getCluster(Class clusterClass) {
        for (List<Class> keyClassList: clustersByClasses.keySet())
            if(keyClassList.contains(clusterClass))
                return clustersByClasses.get(keyClassList);
        return null;
    }

    public MatterCluster getCluster(List<Class> key) {
        return clustersByClasses.get(key);
    }

    public void drawActiveObjects(SpriteBatch universe) {
        for (MatterCluster cluster: clustersByClasses.values()) {
            cluster.drawActiveObjects(universe);
        }
    }

    public Matter obtain(Class objectClass) {
        MatterCluster matterCluster = getCluster(objectClass);
        if(matterCluster == null) return null;
        return matterCluster.obtain();
    }

    public void drawActiveObjects(Class ofClass) {
        for(List<Class> classList: clustersByClasses.keySet()) {
            if(classList.contains(ofClass))
                clustersByClasses.get(classList).drawActiveObjects(universe);
        }
    }


}
