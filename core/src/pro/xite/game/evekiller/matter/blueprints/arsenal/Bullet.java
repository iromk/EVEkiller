package pro.xite.game.evekiller.matter.blueprints.arsenal;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.abstracts.behaviours.Shooter;

/**
 * Пуля
 */

public class Bullet extends Ammo {

//    private Object owner;

    public Bullet() {
//        textures[0] = Singularity.bang("bulletMainShip");
//        textures = new TextureRegion(); //[1];
    }

    @Override
    public void set(
            Shooter owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rectangular worldBounds,
            int damage
    ) {
        super.set(owner, region, pos0, v0, height, worldBounds, damage);
/*        this.shooter = owner;
        this.textures[0] = region;
//        this.regions[0] = region;
        setCenter(pos0);// fix();
//        this.pos.set(pos0);
        this.v.set(v0);
//        setHeightProportion(height);
        setHeight(height); setWidth(3f);
        this.worldBounds = worldBounds;
        this.damage = damage;*/
        setWidth(3f);
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


}
