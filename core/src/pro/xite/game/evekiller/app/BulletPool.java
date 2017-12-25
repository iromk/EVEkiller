package pro.xite.game.evekiller.app;


import pro.xite.game.evekiller.matter.Bullet;

public class BulletPool extends MatterPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void debugLog() {
        System.out.println("Bullet pool change active/free : " + activeObjects.size() + " / " + freeObjects.size());
    }
}
