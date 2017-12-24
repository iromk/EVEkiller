package pro.xite.game.evekiller.abstracts.shapes;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Roman Syrchin on 12/24/17.
 */

public class Rectangular extends Rectangle implements Projectable {

    private Vector2 vcenter = new Vector2();

    public Rectangular() {
    }

    public Rectangular(float width, float height) {
        super(-width / 2, -height / 2, width, height);
    }


    public void fix() {
        x = vcenter.x - width / 2;
        y = vcenter.y - height / 2;
    }

    @Override
    public float getLeft() {
        return x;
    }

    @Override
    public void setLeft(float left) {
        x = left;
    }

    @Override
    public float getRight() {
        return x + width;
    }

    @Override
    public void setRight(float right) {
        width = right - x;
    }

    @Override
    public float getCenterX() {
        return x + width / 2;
    }

    @Override
    public float getCenterY() {
        return y + height / 2;
    }

    @Override
    public Vector2 getCenter() {
        return getCenter(vcenter);
    }

    @Override
    public float getTop() {
        return y + height;
    }

    @Override
    public void setTop(float top) {
        height = top - y;
    }

    @Override
    public float getBottom() {
        return y;
    }

    @Override
    public void setBottom(float bottom) {
        y = bottom;
    }
}
