package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.app.Regions;
import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/22/17.
 */

public class MillenniumFalcon extends GameMatter implements Movable {

    private Rectangular worldBounds;
    Vector2 velocity = new Vector2();


    public MillenniumFalcon(SpriteBatch batch, Rectangular worldBounds) {
        super("main_ship");
        TextureRegion[] regions = Regions.split(texture, 1, 2,2);
        texture = regions[0];
        universe = batch;
        this.worldBounds = worldBounds;
        setWidth(35f);
        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
        setHeight(35f / aspect);
        setCenter(0+worldBounds.width/2, 0+worldBounds.height/2);

        universe = batch;
        setVelocity();

    }

    @Override
    public void draw() {
//        System.out.println(universe.getProjectionMatrix());
//        System.out.println(universe.setProjectionMatrix(););
        Vector2 center = new Vector2();
        getCenter(center);

        universe.draw(
                texture, // текущий регион
                getX(), getY(), //точка отрисовки
                center.x, center.y, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }

    public void moveLeft() {
//        System.out.println(velocity);
        Vector2 position = new Vector2();
        getCenter(position);
        System.out.println(position);
        position.add(velocity);
        setCenter(position);
        System.out.println(position);
    }

    @Override
    public void move(float delta) {

    }

    @Override
    public void setVelocity() {
        velocity.set(1f, 0f);
        System.out.println("----");
        System.out.println(velocity);
        System.out.println("----");

    }
}
