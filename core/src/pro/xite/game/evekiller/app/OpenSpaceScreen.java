package pro.xite.game.evekiller.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import java.util.List;

import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.matter.blueprints.arsenal.Ammo;
import pro.xite.game.evekiller.matter.blueprints.arsenal.Bullet;
import pro.xite.game.evekiller.matter.Enemy;
import pro.xite.game.evekiller.matter.Explosion;
import pro.xite.game.evekiller.matter.FFAGalaxy;
import pro.xite.game.evekiller.matter.Falcon;
import pro.xite.game.evekiller.matter.blueprints.arsenal.Plasma;
import pro.xite.game.evekiller.matter.Star;

/**
 * Created by Roman Syrchin on 12/12/17.
 */

public class OpenSpaceScreen extends Base2DScreen {

    static final float WORLD_HEIGHT_IN_METERS = 600f;
    static final int STARS = 102;

    FFAGalaxy ffaGalaxy;
    Star[] stars;
    Falcon playa;
    Enemy enemy;
    Explosion explosion;


    public OpenSpaceScreen(Game game) {
        super(game);

        universe.bounds.setHeight(WORLD_HEIGHT_IN_METERS);
        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

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
        super.render(delta);

        universe.begin();
//		universe.render();
        if(ffaGalaxy != null)
            ffaGalaxy.draw();
        for (int i = 0; i < STARS; i++) {
            stars[i].move(delta);
            stars[i].draw();
        }
/*
        System.out.println("\n = = = = = = ");
        SuperClusterIterator sci = universe.getSuperClusterIterator(Ammo.class);
        int testcount = 0;
        while(sci.hasNext()) {
            testcount++;
            System.out.println(sci.next().getClass());
        }
        System.out.println("total objs iterated: " + testcount);
*/
        playa.draw();
        enemy.draw();
        if(explosion != null) explosion.draw();

        universe.draw(Ammo.class);
        universe.draw(Explosion.class);

        universe.end();
//        game.setScreen(new MenuScreen(game));
    }

    public void update(float delta) {
        universe.update(delta);

        playa.update(delta);
        enemy.update(delta);

        if(!overlaps(enemy)) {
            enemy = null;
            enemy = new Enemy(universe);
        }

        detectCollision();
    }

    private void detectCollision() {

//        supercluster.detectCollisions(Ammo, Ship);


        for(Bullet bullet : (List<Bullet>)universe.getCluster(Bullet.class).getActiveObjects()) {
            if(bullet.overlaps(enemy)) {
                enemy.dealDamage(bullet.getDamage());
                explosion = (Explosion) universe.obtainFromSupercluster(Explosion.class);
                explosion.setup(universe, enemy, Explosion.XXS, bullet, 30f);
                explosion.setSilent();
                bullet.destroy();
//                enemy.eliminated();
            }
        }
        for(Plasma plasma : (List<Plasma>) universe.getCluster(Plasma.class).getActiveObjects()) {
            if(plasma.overlaps(enemy)) {
                enemy.dealDamage(plasma.getDamage());
                explosion = (Explosion) universe.obtainFromSupercluster(Explosion.class);
                explosion.setup(universe, enemy, Explosion.XS, plasma, 30f);
                explosion.setSilent();
                plasma.destroy();
//                enemy.eliminated();
            }
        }

        if(enemy.isDestroyed()) {
            explosion = (Explosion) universe.obtainFromSupercluster(Explosion.class);
            explosion.setup(universe, enemy, Explosion.L);
            enemy = new Enemy(universe);
        }

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

        if(explosion != null) explosion.resize(universe.bounds);
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
