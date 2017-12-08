package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
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
    Vector2 cur;

    Vector2 delta;

    Vector2 destiny;
    float v,a;

    public DeathStar(Universe spriteBatch) {
        this.texture = new Texture(deathstarImageFilename);
        cg = new Vector2(texture.getWidth()/2, texture.getHeight()/2);
        this.universe = spriteBatch;
        cur = new Vector2(universe.width, universe.height).scl(0.5f).sub(cg);
        v = 1f; delta = new Vector2();
        System.out.println(cur.toString());
        destiny = new Vector2();
    }

    @Override
    public void draw() {
        move();
        universe.draw(texture, cur.x, cur.y);
    }

    private void move() {
        if(destiny.len() >0 && !cur.epsilonEquals(destiny, 1f)) {
            delta.setLength(v);
            v+=0.1f;
            cur.add(delta);
        }
    }

    public void moveTo(Vector2 dst) {
        destiny = dst.sub(cg);
        delta = destiny.cpy().sub(cur);//.setLength(v);
    }


}
