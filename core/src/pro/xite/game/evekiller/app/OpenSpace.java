package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Rectangle;


import pro.xite.game.evekiller.abstracts.Rect;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.darkmatter.MassEffect;
import pro.xite.game.evekiller.darkmatter.oldUniverse;
import pro.xite.game.evekiller.matter.FFAGalaxy;
import pro.xite.game.evekiller.matter.MillenniumFalcon;
import pro.xite.game.evekiller.matter.Star;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

public class OpenSpace extends Base2DScreen {

//    oldUniverse universeBatch;
//    Game game;

    FFAGalaxy ffaGalaxy;
    MillenniumFalcon player;
    Star[] stars;
    static final int STARS = 102;

    public OpenSpace(Game game) {
        super(game);
        ffaGalaxy = new FFAGalaxy(batch, worldBounds);
//        stars = new Star[STARS];
//        player = new MillenniumFalcon(batch, worldBounds);
//        for (int i = 0; i < STARS; i++) {
//            stars[i] = new Star(batch, worldBounds);
//        }
//        this.game = game;
//        batch = new SpriteBatch();
//        Gdx.input.setInputProcessor(new GestureDetector(new MassEffect(universeBatch)));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
//		batch.render();
        if(ffaGalaxy != null)
            ffaGalaxy.draw();
//        for (int i = 0; i < STARS; i++) {
//            stars[i].move(delta);
//            stars[i].draw();
//        }
//        player.draw();
        batch.end();
//        game.setScreen(new MenuScreen(game));
    }

    @Override
    protected void resize(Rectangular worldBounds) {
        if(ffaGalaxy != null)
            ffaGalaxy.resize(worldBounds);
//        buttonExit.resize(worldBounds);
//        buttonNewGame.resize(worldBounds);
        if(stars != null)
        for (int i = 0; i < STARS; i++) {
            if(stars[i] != null)
                stars[i].resize(worldBounds);
        }
        if(player != null)
        player.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("key");

        player.moveLeft();
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
