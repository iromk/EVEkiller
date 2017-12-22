package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import pro.xite.game.evekiller.abstracts.*;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

abstract class Base2DScreen implements Screen, InputProcessor {

    protected Game game;
    private Rect screenBounds; // границы области рисования в пикселях
    protected Rect worldBounds; // границы проекции мировых координат
    private Rect glBounds; // дефолтные границы проекции мир - gl

    protected Matrix4 worldToGl;
    protected Matrix3 screenToWorld;

    Vector2 touch = new Vector2();

    protected SpriteBatch batch;


    public Base2DScreen(Game game) {
        this.game = game;
        this.screenBounds = new Rect();
        this.worldBounds = new Rect();
        this.glBounds = new Rect(0,0,1f,1f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        if (this.batch != null) {
            throw new RuntimeException("Повторная установка screen без dispose");
        }
        this.batch = new SpriteBatch();
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        screenBounds.setSize(width, height);
        screenBounds.setLeft(0);
        screenBounds.setBottom(0);

        float aspect = width / (float) height;
        worldBounds.setHeight(1f);
        worldBounds.setWidth(1f * aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
        batch.setProjectionMatrix(worldToGl);

        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        resize(worldBounds);
    }

    protected void resize(Rect worldBounds) {

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
