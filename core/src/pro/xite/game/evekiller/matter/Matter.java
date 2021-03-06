package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

import pro.xite.game.evekiller.abstracts.behaviours.SelfDrawable;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Singularity;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

abstract public class Matter extends Rectangular implements SelfDrawable, Disposable {

    public TextureRegion[] textures;
    protected int frame;
    protected Universe universe;
    protected  float scale = 1f;
    protected float angle;
    private boolean isDestroyed;


//    final Vector2 position = new Vector2();

    public void dispose() {
//        textures.dispose();
    }

    public Matter() {
        textures = new TextureRegion[1];
    }

    public Matter(String matterName) {
        textures = new TextureRegion[1];
        frame = 0;
        textures[0] = Singularity.bang(matterName);
    }


    public void draw(SpriteBatch spriteBatch) {

        spriteBatch.draw(
                this.textures[frame], // текущий регион
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

    public void resize(Rectangular worldBounds) {

    }


    public  void setHeightProportion(float height) {
        setHeight(height);
        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
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
