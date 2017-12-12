package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

import pro.xite.game.evekiller.darkmatter.MassEffect;
import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

public class GameScreen extends Base2DScreen {

    Universe universeBatch;


    public GameScreen() {
        universeBatch = new Universe();
        Gdx.input.setInputProcessor(new GestureDetector(new MassEffect(universeBatch)));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        universeBatch.begin();
		universeBatch.render();
        universeBatch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        universeBatch.dispose();
    }
}
