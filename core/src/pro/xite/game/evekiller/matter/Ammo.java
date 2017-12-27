package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Created by Roman Syrchin on 12/26/17.
 */

public class Ammo extends GameMatter {

    protected float damage;

    protected Rectangular worldBounds;

    protected final Vector2 v = new Vector2();

    Shooter shooter;

    public void set(
            Shooter owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rectangular worldBounds,
            int damage
    ) {
        this.shooter = owner;
        this.textures[0] = region;
//        this.regions[0] = region;
        setCenter(pos0);// fix();
//        this.pos.set(pos0);
        this.v.set(v0);
//        setHeightProportion(height);
        setHeight(height); setWidth(5f);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    @Override
    public void update(float deltaTime) {
        setCenter(getCenter().mulAdd(v, deltaTime));
//        fix();
//        if (isOutside(worldBounds)) {
        if (!worldBounds.contains(this)) {
            destroy();
        }
    }

    @Override
    public void draw() {
        super.draw();
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Shooter getOwner() {
        return shooter;
    }

    public void setOwner(Shooter owner) {
        this.shooter = owner;
    }
}
