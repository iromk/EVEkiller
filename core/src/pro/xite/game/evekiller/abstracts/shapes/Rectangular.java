package pro.xite.game.evekiller.abstracts.shapes;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Roman Syrchin on 12/23/17.
 */
public class Rectangular {

    public final Vector2 pos = new Vector2(); // позиция по центру
    protected float halfWidth; // половина ширины
    protected float halfHeight; // половина высоты

    public Rectangular() {

    }

    public Rectangular(Rectangular from) {
        this(from.pos.x, from.pos.y, from.getHalfWidth(), from.getHalfHeight());
    }

    public Rectangular(float x, float y, float halfWidth, float halfHeight) {
        pos.set(x, y);
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
    }

    public float getCenterX() {
        return halfWidth;
    }

    public float getCenterY() {
        return halfHeight;
    }

    public float getLeft() {
        return pos.x - halfWidth;
    }

    public float getTop() {
        return pos.y + halfHeight;
    }

    public float getRight() {
        return pos.x + halfWidth;
    }

    public float getBottom() {
        return pos.y - halfHeight;
    }

    public float getHalfWidth() {
        return halfWidth;
    }

    public float getHalfHeight() {
        return halfHeight;
    }

    public float getWidth() {
        return halfWidth * 2f;
    }

    public float getHeight() {
        return halfHeight * 2f;
    }

    public void set(Rectangular from) {
        pos.set(from.pos);
        halfWidth = from.halfWidth;
        halfHeight = from.halfHeight;
    }

    public void setLeft(float left) {
        pos.x = left + halfWidth;
    }

    public void setTop(float top) {
        pos.y = top - halfHeight;
    }

    public void setRight(float right) {
        pos.x = right - halfWidth;
    }

    public void setBottom(float bottom) {
        pos.y = bottom + halfHeight;
    }

    public void setWidth(float width) {
        this.halfWidth = width / 2f;
    }

    public void setHeight(float height) {
        this.halfHeight = height / 2f;
    }

    public void setSize(float width, float height) {
        this.halfWidth = width / 2f;
        this.halfHeight = height / 2f;
    }

    public boolean isMe(Vector2 touch) {
        return touch.x >= getLeft() && touch.x <= getRight() && touch.y >= getBottom() && touch.y <= getTop();
    }

    public boolean isOutside(Rectangular other) {
        return getLeft() > other.getRight() || getRight() < other.getLeft() || getBottom() > other.getTop() || getTop() < other.getBottom();
    }

    @Override
    public String toString() {
        return "Rectangle: pos" + pos + " size(" + getWidth() + ", " + getHeight() + ")";
    }
}
/*
public class Rectangular extends Rectangle {

//    Vector2 position = new Vector2();
//
//    public Rectangular(Vector2 position) {
//        this.position = position;
//    }
    protected Vector2 position = new Vector2();

    public Rectangular() {
    }

    public Rectangular(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public Vector2 getCenter() {
        return position.set(getCenterX(), getCenterY());
    }

    public float getCenterX() {
        return x + width/2;
    }

    public float getRight() {
        return width / 2;
    }

    public float getBottom() {
        return -height / 2;
    }

    public float getLeft() {
        return -width / 2;
    }

    public float getCenterY() {
        return y + height/2;
    }
}
*/