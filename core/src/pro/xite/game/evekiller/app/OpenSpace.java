package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.matter.Enemy;
import pro.xite.game.evekiller.matter.FFAGalaxy;
import pro.xite.game.evekiller.matter.Falcon;
import pro.xite.game.evekiller.matter.Star;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

public class OpenSpace extends Base2DScreen {

    static final float WORLD_HEIGHT_IN_METERS = 600f;
    static final int STARS = 102;

    FFAGalaxy ffaGalaxy;
    Star[] stars;
    Falcon playa;
    Enemy enemy;

    public OpenSpace(Game game) {
        super(game);

        universe.bounds.setHeight(WORLD_HEIGHT_IN_METERS);
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        System.out.println("openspace " + universe.bounds);

        ffaGalaxy = new FFAGalaxy(universe);
        playa = new Falcon(universe);
        stars = new Star[STARS];
        enemy = new Enemy(universe);

        for (int i = 0; i < STARS; i++) {
            Indeterminacy.nextFloat(-1f, 1f);
            stars[i] = new Star(universe);
        }
//        this.game = game;
//        universe = new SpriteBatch();
//        Gdx.input.setInputProcessor(new GestureDetector(new MassEffect(universeBatch)));
    }

    @Override
    public void render(float delta) {
        update(delta);
        deleteAllDestroyed();
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        universe.begin();
//		universe.render();
        if(ffaGalaxy != null)
            ffaGalaxy.draw();
        for (int i = 0; i < STARS; i++) {
            stars[i].move(delta);
            stars[i].draw();
        }
        playa.draw();
        enemy.draw();
        universe.end();
//        game.setScreen(new MenuScreen(game));
    }

    public void update(float delta) {
        playa.update(delta);
        enemy.update(delta);
    }

    @Override
    protected void resize() {
        if(ffaGalaxy != null)
            ffaGalaxy.resize(universe.bounds);
        if(playa != null) playa.resize(universe.bounds);

//        buttonExit.resize(worldBounds);
//        buttonNewGame.resize(worldBounds);
        if(stars != null)
        for (int i = 0; i < STARS; i++) {
            if(stars[i] != null)
                stars[i].resize(universe.bounds);
        }
        if(enemy != null) enemy.resize(universe.bounds);
    }

    /**
     * Удаление помеченных объектов
     */
    public void deleteAllDestroyed() {
//        bulletPool.freeAllDestroyedActiveObjects();
//        explosionPool.freeAllDestroyedActiveObjects();
    }


    @Override
    public void dispose() {
        super.dispose();
        universe.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == 22) playa.actionRight();
        if(keycode == 21) playa.actionLeft();
        if(keycode == 19) playa.actionPiupiu();
//        System.out.println(keycode);
        return false;
    }


    @Override
    public boolean keyUp(int keycode) {
        playa.stopAction(keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
//        System.out.println("keyTyped character = " + character);
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
