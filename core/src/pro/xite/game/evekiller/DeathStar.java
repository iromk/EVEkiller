package pro.xite.game.evekiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Roman Syrchin on 12/6/17.
 */

public class DeathStar extends Texture {

    private static final String deathstarImageFilename = "deathstar.png";
    private final float speedXmin = 2f;
    private final float speedXmax = 6f;
    private final float speedYmin = 0.5f;
    private final float speedYmax = 2f;

    float curX, curY;
    float speedX, speedY;

    public DeathStar() {
        super(deathstarImageFilename);
        resetPosition();
    }

    public float getCurX() {
        if (curX > Gdx.graphics.getWidth() || curX < -64f) resetPosition();
        else curX += speedX;
        return curX;
    }

    public float getCurY() {
        if (curY > Gdx.graphics.getHeight() || curY < -64f) resetPosition();
        else curY += speedY;
        return curY;
    }

    private void resetPosition() {
        curX = -64f;
        curY = Gdx.graphics.getHeight() / 2 - 32f;
        speedX = (float)(Math.random() * (speedXmax - speedXmin)) + speedXmin;
        speedY = (float)((Math.random() - 0.5f) * (speedYmax - speedYmin));
        speedY += (speedY > 0 ? speedYmin : -speedYmin);
    }
}
