package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * Created by Roman Syrchin on 12/6/17.
 */

public class DeathStar extends GameMatter {

    private static final String deathstarImageFilename = "deathstar.png";

    /**
     * Center of gravity vector
     */
    private Vector2 cg;

    /**
     * Current position, central point related
     */
    Vector2 position;

    Vector2 delta;
    Vector2 slowdown;

    Vector2 destination;
    float v,a;

    public DeathStar(Universe spriteBatch) {
        this.texture = new Texture(deathstarImageFilename);
        cg = new Vector2(texture.getWidth()/2, texture.getHeight()/2);
        this.universe = spriteBatch;
        position = new Vector2(universe.width, universe.height).scl(0.5f).sub(cg);
        v = 0f; a = 0f; delta = new Vector2();
        System.out.println(position.toString());
        destination = new Vector2();
        slowdown = new Vector2();
    }

    @Override
    public void draw() {
        move();
        universe.draw(texture, position.x, position.y);
    }

    private void move() {
        if(delta.len() > 0)
            if(position.epsilonEquals(destination, 1f)) {
                position.set(destination.x, destination.y);
                v = 0f;
                delta.setZero();
                destination.setZero();
            } else {
                delta.setLength(v);
                updateVelocity();
                position.add(delta);
                universe.playerMoved(delta);
            }
    }

    private void updateVelocity() {
        if(a > 0 && position.epsilonEquals(slowdown, 5f))
            a = -0.2f;
        v += a;
    }

    public void moveTo(Vector2 dst) {
        destination = dst.sub(cg);
        delta = destination.cpy().sub(position);
        slowdown = delta.cpy().scl(0.66f).add(position);
        v = 1f; a = 0.1f;
    }


}
