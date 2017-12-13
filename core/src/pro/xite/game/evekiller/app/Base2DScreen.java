package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

abstract class Base2DScreen implements Screen, InputProcessor {

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }


    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
