package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

abstract public class GameMatter implements SelfDrawable, Disposable {

    Texture texture;
    SpriteBatch batch;

    public void dispose() {
        texture.dispose();
    }

}
