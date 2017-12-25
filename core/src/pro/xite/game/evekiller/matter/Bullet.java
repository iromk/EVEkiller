package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Пуля
 */

public class Bullet extends GameMatter {

    private Rectangular worldBounds;
    private final Vector2 v = new Vector2();
    private  int damage;
    private Object owner;

    public Bullet() {
        super("bulletMainShip");
//        texture = new TextureRegion(); //[1];
    }

    public void set(
            Object owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rectangular worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.texture = region;
//        this.regions[0] = region;
        getCenter().set(pos0); fix();
//        this.pos.set(pos0);
        this.v.set(v0);
//        setHeightProportion(height);
        setHeight(35f); setWidth(5f);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    @Override
    public void update(float deltaTime) {
        getCenter().mulAdd(v, deltaTime);
        fix();
//        if (isOutside(worldBounds)) {
        if (!worldBounds.contains(this)) {
            destroy();
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }
}
