package pro.xite.game.evekiller.darkmatter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.matter.DeathStar;
import pro.xite.game.evekiller.matter.FFAGalaxy;
import pro.xite.game.evekiller.matter.SelfDrawable;
import pro.xite.game.evekiller.matter.Star;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class oldUniverse extends SpriteBatch {

    DeathStar deathStar;
    FFAGalaxy ffaGalaxy;
    Star stars[];

    public final int width = Gdx.graphics.getWidth();
    public final int height = Gdx.graphics.getHeight();


    public oldUniverse() {
//        deathStar = new DeathStar(this);
        ffaGalaxy = new FFAGalaxy(this, new Rectangular());
        stars = new Star[11];
//        for (int i = 0; i < stars.length; i++)
//            stars[i] = new Star();

    }

    public void setGravitySource(Vector2 gravity) {
        deathStar.moveTo(gravity);
    }

    public void playerMoved(Vector2 delta) {
        ffaGalaxy.moveTo(delta.cpy());
    }

    public void render() {
//        render(ffaGalaxy, deathStar);
        render(ffaGalaxy);
        for(int i = 0; i < stars.length; i++)
            stars[i].draw();
    }

    private void render(SelfDrawable... objects) {
        for (SelfDrawable object : objects) {
            object.draw();
        }
    }

}
