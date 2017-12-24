package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;
import pro.xite.game.evekiller.abstracts.*;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

abstract class Base2DScreen implements Screen, InputProcessor {

    protected Game game;
    private Rectangular screenBounds; // границы области рисования в пикселях
    protected Rectangular worldBounds; // границы проекции мировых координат
    private Rectangular glBounds; // дефолтные границы проекции мир - gl

    protected Matrix4 worldToGl;
    protected Matrix3 screenToWorld;

    Vector2 touch = new Vector2();
    Rectangle a;
    protected SpriteBatch batch;

    public Base2DScreen(Game game) {
        this.game = game;
        this.screenBounds = new Rectangular();
        this.worldBounds = new Rectangular();
        this.glBounds = new Rectangular(-1f, -1f,2f,2f);
        this.worldToGl = new Matrix4();
        this.screenToWorld = new Matrix3();
        if (this.batch != null) {
            throw new RuntimeException("Повторная установка screen без dispose");
        }
        this.batch = new SpriteBatch();
//        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
        screenBounds.pos.x = 0;
        screenBounds.pos.y = 0;
//        System.out.println("scrn bnds\n" + screenBounds);
//        System.out.println(batch.getProjectionMatrix());
//        System.out.println(batch.getTransformMatrix());
        float aspect = width / (float) height;
        worldBounds.setHeight(600f);
        worldBounds.setWidth(600f * aspect);
//        worldBounds.set(-600f / 2, -(600f * aspect) / 2, 600f, 600f * aspect );
//        worldBounds.setWidth(600f * aspect);
        MatrixUtils.calcTransitionMatrix(worldToGl, worldBounds, glBounds);
//        System.out.println(worldToGl);
        batch.setProjectionMatrix(worldToGl);

        MatrixUtils.calcTransitionMatrix(screenToWorld, screenBounds, worldBounds);
        resize(worldBounds);
    }

    protected void resize(Rectangular worldBounds) {

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
