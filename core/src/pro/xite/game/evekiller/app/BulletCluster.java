package pro.xite.game.evekiller.app;


import pro.xite.game.evekiller.matter.blueprints.arsenal.Bullet;

public class BulletCluster extends MatterCluster<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    public Class getItemClass() {
        return Bullet.class;
    }

    @Override
    protected void debugLog() {
//        System.out.println("Bullet pool change active/free : " + activeObjects.size() + " / " + freeObjects.size());
    }
}
