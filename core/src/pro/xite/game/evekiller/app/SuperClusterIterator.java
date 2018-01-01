package pro.xite.game.evekiller.app;

import java.util.Iterator;
import java.util.List;

import pro.xite.game.evekiller.darkmatter.SuperCluster;
import pro.xite.game.evekiller.matter.Matter;

/**
 * Created by Roman Syrchin on 12/31/17.
 */

public class SuperClusterIterator implements Iterator {

    SuperCluster superCluster;
    Class criteria;
    int currentIndex;
    Iterator<Matter> matterClusterIterator;
    Iterator<List<Class>> classListIterator;


    public SuperClusterIterator(SuperCluster superCluster, Class criteria) {
        this.superCluster = superCluster;
        this.criteria = criteria;
        classListIterator = superCluster.getClassesList().iterator();

//        MatterCluster matterCluster = superCluster.getClusterByClass(ofClass);
//        matterClusterIterator = matterCluster.getActiveObjects().iterator();
    }

    @Override
    public boolean hasNext() {
        if(matterClusterIterator != null && matterClusterIterator.hasNext()) return true;

        while(classListIterator.hasNext()) {
            List<Class> nextClass = classListIterator.next();
            if(nextClass.contains(criteria)) {
                matterClusterIterator = superCluster.getCluster(nextClass).getActiveObjects().iterator();
                if(hasNext()) return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        return matterClusterIterator.next();
    }
}
