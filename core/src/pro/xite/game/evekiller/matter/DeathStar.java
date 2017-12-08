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
    private final float speedXmin = 2f;
    private final float speedXmax = 6f;
    private final float speedYmin = 0.5f;
    private final float speedYmax = 2f;

    /**
     * Center of gravity vector
     */
    private Vector2 cg;

    /**
     * Current position, central point related
     */
    Vector2 cur;
    float v,a;
    float speedX, speedY;

    public DeathStar(Universe spriteBatch) {
        this.texture = new Texture(deathstarImageFilename);
        cg = new Vector2(texture.getWidth()/2, texture.getHeight()/2);
        this.universe = spriteBatch;
        cur = new Vector2(universe.width, universe.height).scl(0.5f).sub(cg);
//        cur = new Vector2((universe.width-texture.getWidth())/2, (universe.height-texture.getHeight())/2);
//        resetPosition();
    }

    @Override
    public void draw() {
        universe.draw(texture, getCurX(), getCurY());
    }

    public float getCurX() {
//        if (cur.x > Gdx.graphics.getWidth() || cur.x < -64f) resetPosition();
//        else cur.x += speedX;
        return cur.x;
    }

    public void moveTo(Vector2 dst) {
        cur = dst.sub(cg);
    }

    public float getCurY() {
//        if (cur.y > Gdx.graphics.getHeight() || cur.y < -64f) resetPosition();
//        else cur.y += speedY;
        return cur.y;
    }

    private void resetPosition() {
        cur.x = -64f;
        cur.y = Gdx.graphics.getHeight() / 2 - 32f;

        speedX = (float)(Math.random() * (speedXmax - speedXmin)) + speedXmin;
        speedY = (float)((Math.random() - 0.5f) * (speedYmax - speedYmin));
        speedY += (speedY > 0 ? speedYmin : -speedYmin);
    }

}
