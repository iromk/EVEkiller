package pro.xite.game.evekiller.darkmatter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class MassEffect implements GestureDetector.GestureListener {

//    DeathStar deathStar;
    Universe universe;

//    public MassEffect(DeathStar deathStar) {
//        this.deathStar = deathStar;
//    }

    public MassEffect(Universe universe) {
        this.universe = universe;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
//        System.out.println("touchDown!");
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        universe.setGravitySource(new Vector2(x, universe.height - y));
//        System.out.printf("%f, %f, %d, %d", x,y,count,button);
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
