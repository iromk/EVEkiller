package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

abstract public class GameMatter implements SelfDrawable, Disposable {

    Texture texture;
    Universe universe;

    public void dispose() {
        texture.dispose();
    }

}
