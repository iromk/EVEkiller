package pro.xite.game.evekiller.matter;

/**
 * Created by Roman Syrchin on 12/24/17.
 */

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Movable;

import pro.xite.game.evekiller.app.Regions;

/**
 * Created by Roman Syrchin on 12/22/17.
 */

public class Falcon extends GameMatter implements Movable {

//    private Rectangular worldBounds;
    Vector2 velocity = new Vector2();


    public Falcon(SpriteBatch batch, Rectangular worldBounds) {
        super("main_ship");
        TextureRegion[] regions = Regions.split(texture, 1, 2,2);
        texture = regions[0];
        universe = batch;
//        this.worldBounds = worldBounds;
        setWidth(35f);
        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
        setHeight(35f / aspect);
        setCenter(worldBounds.getCenter());
        fix();

        universe = batch;
        setVelocity();

    }

    @Override
    public void resize(Rectangular worldBounds) {
        getCenter().set(worldBounds.getCenter());
        fix();
    }

    public void update() {
        getCenter().add(velocity);
        fix();
    }

    public void stopActions() {
        velocity.setZero();
    }

    public void actionLeft() {
        velocity.set(-1f, 0f);
    }

    public void actionRight() {
        velocity.set(1f, 0f);
    }

    public void actionPiupiu() {

    }

    @Override
    public void move(float delta) {

    }

    @Override
    public void setVelocity() {
        velocity.setZero();
    }
}
