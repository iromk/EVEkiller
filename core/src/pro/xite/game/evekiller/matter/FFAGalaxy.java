package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.Rect;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class FFAGalaxy extends GameMatter {

    static private final String ffaGalaxyImageFilename = "farfarawaygalaxy.jpg";
    TextureRegion crop;
    private float deltaScaleFactor = 0.2f;

    public FFAGalaxy(SpriteBatch spriteBatch, Rectangular worldBounds) {
        super("");

        Texture texture = new Texture(ffaGalaxyImageFilename);
        this.universe = spriteBatch;
//        position = new Vector2(-200,-200);
        this.texture = getRandomTextureRegion(texture);
    }

    public void draw() {

//        Vector2 center = new Vector2();
//        getCenter(center);
        universe.draw(
                this.texture, // текущий регион
                getLeft(), getBottom(), //точка отрисовки
                getCenterX(), getCenterY(), // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }

    @Override
    public void resize(Rectangular worldBounds) {
        System.out.println("wb: " + worldBounds);
        float height = worldBounds.getHeight();
        setHeight(height);
        float aspect = texture.getRegionHeight() / (float) texture.getRegionWidth();
        setWidth(height * aspect);
//        setCenter(worldBounds.getCenterX(), worldBounds.getCenterY());
        pos.set(worldBounds.pos);
        System.out.println(
                " " + aspect +
                "\n" + getLeft() +
                " " + getBottom() +
                "\n" + getCenterX() +
                " " + getCenterY() +
                "\n" + getWidth() +
                " " + getHeight() +
                "\n" + worldBounds.getCenterX()
                + " " + worldBounds.getCenterY()
        );
    }

    private TextureRegion getRandomTextureRegion(Texture texture) {
        int x = (int)(Math.random() * (texture.getWidth() - Gdx.graphics.getWidth()) - 200) - 100;
        int y = (int)(Math.random() * (texture.getHeight() - Gdx.graphics.getHeight()) - 200) - 100;
//        int x = 0;
//        int y = 0;
//TODO 100 and 200 consts need to replace with calculated values depending on gdx size and scale factor

        return new TextureRegion(texture, x, y, //1000,1000);
                                         Gdx.graphics.getWidth()+400, Gdx.graphics.getHeight()+400);
    }

    public void moveTo(Vector2 delta) {
        Vector2 p = new Vector2();
//        getCenter(p);
        p.sub(delta.scl(deltaScaleFactor));
//        setPosition(p);
    }

}
