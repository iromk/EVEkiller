package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public class Star extends GameMatter implements Movable {

    Vector2 velocity = new Vector2();


//    TextureRegion textureRegion;

    public Star(Universe batch) {
//        super("star");
        super();
//        textures = new TextureRegion(new Texture("deathstar.png"));
        textures[0] = Singularity.bang("star");

        float stellarMagnitude = Indeterminacy.nextFloat(3.005f, 5.01f);
        setWidth(stellarMagnitude);
        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        setHeight(stellarMagnitude / aspect);

        universe = batch;
        setVelocity();
    }


    @Override
    public void resize(Rectangular worldBounds) {
        super.setPosition(Indeterminacy.nextFloat(worldBounds.getLeft(), worldBounds.getRight()),
                          Indeterminacy.nextFloat(worldBounds.getBottom(), worldBounds.getTop()));
    }

    @Override
    public void move(float deltaTime) {
        setCenter(getCenter().mulAdd(velocity, deltaTime));
//        fix();
        stayInBounds();
    }

    private void stayInBounds() {
//        if(getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
//        if(getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if(getTop() < universe.bounds.getBottom()) setTop(universe.bounds.getTop());
//        if(getBottom() )
    }

    @Override
    public void setVelocity() {
        float vx;
        float vy;
        vx = 0; //Indeterminacy.nextFloat(-0.05f, 0.05f);
        vy = Indeterminacy.nextFloat(-105.5f, -95.1f);
        velocity.set(vx, vy);
//        velocity.set(Indeterminacy.nextFloat(-0.5f, 0.5f), Indeterminacy.nextFloat(-0.5f, -0.1f));
    }

    @Override
    public Vector2 getVelocity(Vector2 velocity) {
        return null;
    }
}
