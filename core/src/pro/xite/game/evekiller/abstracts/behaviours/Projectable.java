package pro.xite.game.evekiller.abstracts.behaviours;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Roman Syrchin on 12/24/17.
 */

public interface Projectable {


    float getLeft();
    void setLeft(float left);
    float getRight();
    void setRight(float right);
    float getCenterX();
    float getCenterY();
    Vector2 getCenter();
    float getTop();
    void setTop(float top);
    float getBottom();
    void setBottom(float bottom);
    float getWidth();
    float getHeight();


}
