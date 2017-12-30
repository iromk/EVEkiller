package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.abstracts.math.MatrixUtils;
import pro.xite.game.evekiller.matter.Universe;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

abstract class Base2DScreen extends Rectangular implements Screen, InputProcessor {

    protected Game game;

//    private Rectangular screenBounds; // границы области рисования в пикселях
//    protected Rectangular worldBounds; // границы проекции мировых координат
    private Rectangular glBounds; // дефолтные границы проекции мир - gl

    private Matrix4 universeToGl;
    private Matrix3 screenToUniverse;

    Vector2 touch = new Vector2();

    protected Universe universe;


    public Base2DScreen(Game game) {
        if (this.universe != null) {
            throw new RuntimeException("Повторная установка screen без dispose");
        }

        this.game = game;
        this.universe = new Universe();

        this.glBounds = new Rectangular(2f, 2f);
        this.universeToGl = new Matrix4();
        this.screenToUniverse = new Matrix3();

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
        set(0,0, width, height);
//        System.out.println("vefore " + universe.bounds);
        universe.bounds.setWidthByAspectRatio(width / (float) height);

        MatrixUtils.calcTransitionMatrix(universeToGl, universe.bounds, glBounds);
        universe.setProjectionMatrix(universeToGl);
        MatrixUtils.calcTransitionMatrix(screenToUniverse, this, universe.bounds);

//        System.out.println(this);
//        System.out.println(universe.bounds);
//        System.out.println(glBounds);

        resize();
    }

    protected void resize() {

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
