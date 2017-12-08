package pro.xite.game.evekiller.darkmatter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.matter.DeathStar;
import pro.xite.game.evekiller.matter.FFAGalaxy;
import pro.xite.game.evekiller.matter.SelfDrawable;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class Universe extends SpriteBatch {

    DeathStar deathStar;
    FFAGalaxy ffaGalaxy;

    public final int width = Gdx.graphics.getWidth();
    public final int height = Gdx.graphics.getHeight();


    public Universe() {
        deathStar = new DeathStar(this);
        ffaGalaxy = new FFAGalaxy(this);
    }

    public void setGravitySource(Vector2 gravity) {
        deathStar.moveTo(gravity);
    }

    public void render() {
        render(ffaGalaxy, deathStar);
    }

    private void render(SelfDrawable... objects) {
        for (SelfDrawable object : objects) {
            object.draw();
        }
    }

}
