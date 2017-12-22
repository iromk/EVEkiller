package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

import pro.xite.game.evekiller.abstracts.Rect;
import pro.xite.game.evekiller.darkmatter.oldUniverse;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

abstract public class GameMatter extends Rect implements SelfDrawable, Disposable {

    TextureRegion texture;
    SpriteBatch universe;
    protected  float scale = 1f;
    protected float angle;

//    final Vector2 position = new Vector2();

    public void dispose() {
//        texture.dispose();
    }

    public GameMatter(String matterName) {
        texture = Singularity.bang(matterName);
//        System.out.println("class >" + getClass().getName().split(".") );
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
    }

    public void resize(Rect worldBounds) {

    }

}
