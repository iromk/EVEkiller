package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

abstract public class GameMatter extends Rectangular implements SelfDrawable, Disposable {

    TextureRegion texture;
    SpriteBatch universe;
    protected  float scale = 1f;
    protected float angle;
    private boolean isDestroyed;


//    final Vector2 position = new Vector2();

    public void dispose() {
//        texture.dispose();
    }

    public GameMatter() {

    }

    public GameMatter(String matterName) {
        texture = Singularity.bang(matterName);
//        System.out.println("class >" + getClass().getName().split(".") );
    }


    public void draw(SpriteBatch spriteBatch) {

        spriteBatch.draw(
                this.texture, // текущий регион
                getLeft(), getBottom(), //точка отрисовки
                getCenterX(), getCenterY(), // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }

    public void draw() {
        draw(universe);
    }

    public void update(float delta) {

    }

//    public void setPosition(float x, float y) {
//        position.set(x, y);
//    }

    public void resize(Rectangular worldBounds) {

    }


    public  void setHeightProportion(float height) {
        setHeight(height);
        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
        setWidth(height * aspect);
    }

    public void destroy() {
        this.isDestroyed = true;
    }

    public void flushDestroy() {
        this.isDestroyed = false;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

}
