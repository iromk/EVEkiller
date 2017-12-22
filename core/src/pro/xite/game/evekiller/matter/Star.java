package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pro.xite.game.evekiller.abstracts.Rect;
import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public class Star extends GameMatter implements Movable {


    private Rect worldBounds;
//    TextureRegion textureRegion;

    public Star(SpriteBatch batch, Rect worldBounds) {
        super("star");
//        texture = new TextureRegion(new Texture("deathstar.png"));
        this.worldBounds = worldBounds;

//        setWidthProportion(width);
        float stellarMagnitude = Indeterminacy.nextFloat(0.005f, 0.01f);
        setWidth(stellarMagnitude);
        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
        setHeight(stellarMagnitude / aspect);

        universe = batch;
//        this.texture = Singularity.bang("star");
        setVelocity();
//        super.setPosition(0,0);
    }

//    void setPosition() {
//    }

    @Override
    public void resize(Rect worldBounds) {
//        float height = worldBounds.getHeight();
//        setHeight(height);
//        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
//        setWidth(height * aspect);
        super.setPosition(Indeterminacy.nextFloat(worldBounds.getLeft(), worldBounds.getRight()),
                          Indeterminacy.nextFloat(worldBounds.getBottom(), worldBounds.getTop()));
//        float height = worldBounds.getHeight();
//        setHeight(height);
//        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
//        setWidth(height * aspect);
//        this.position.set(worldBounds.position);
//        setPosition();
//        this.position.set(worldBounds.position);
    }

    @Override
    public void draw() {
//        System.out.println(getLeft()
//                + " " +
//                getBottom()
//                + " " +
//                halfWidth
//                + " " +
//                halfHeight
//                + " " +
//                getWidth()
//                + " " +
//                getHeight()
//                + " " +
//                Gdx.graphics.getWidth()
//                + " " +
//                Gdx.graphics.getHeight()
//        );

        universe.draw(
                texture, // текущий регион
                getLeft(), getBottom(), //точка отрисовки
                halfWidth, halfHeight, // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }

    @Override
    public void move(float deltaTime) {
        position.mulAdd(velocity, deltaTime);
        stayInBounds();
    }

    private void stayInBounds() {
        if(getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
        if(getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
        if(getTop() < worldBounds.getBottom()) setTop(worldBounds.getTop());
//        if(getBottom() )
    }

    @Override
    public void setVelocity() {
        float vx = Indeterminacy.nextFloat(-0.5f, 0.5f);
        float vy = Indeterminacy.nextFloat(-0.5f, -0.1f);
        vx = Indeterminacy.nextFloat(-0.05f, 0.05f);
        vy = Indeterminacy.nextFloat(-0.5f, -0.1f);
        velocity.set(vx, vy);
//        velocity.set(Indeterminacy.nextFloat(-0.5f, 0.5f), Indeterminacy.nextFloat(-0.5f, -0.1f));
    }
}
