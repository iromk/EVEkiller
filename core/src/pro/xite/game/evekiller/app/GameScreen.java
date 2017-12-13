package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

import pro.xite.game.evekiller.darkmatter.MassEffect;
import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

public class GameScreen extends Base2DScreen {

    Universe universeBatch;
    Game game;


    public GameScreen(Game game) {
        this.game = game;
        universeBatch = new Universe();
        Gdx.input.setInputProcessor(new GestureDetector(new MassEffect(universeBatch)));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        universeBatch.begin();
		universeBatch.render();
        universeBatch.end();
        game.setScreen(new MenuScreen(game));
    }

    @Override
    public void dispose() {
        super.dispose();
        universeBatch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
