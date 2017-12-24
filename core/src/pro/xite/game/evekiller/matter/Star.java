package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.Rect;
import pro.xite.game.evekiller.abstracts.shapes.Rectangular;
import pro.xite.game.evekiller.darkmatter.Indeterminacy;
import pro.xite.game.evekiller.darkmatter.Movable;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public class Star extends GameMatter implements Movable {


    private Rectangular worldBounds;
    Vector2 velocity = new Vector2();

//    TextureRegion textureRegion;

    public Star(SpriteBatch batch, Rectangular worldBounds) {
        super("star");
//        texture = new TextureRegion(new Texture("deathstar.png"));
        this.worldBounds = worldBounds;

//        setWidthProportion(width);
        float stellarMagnitude = Indeterminacy.nextFloat(1f, 5f);
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
    public void resize(Rectangular worldBounds) {
//        float height = worldBounds.getHeight();
//        setHeight(height);
//        float aspect = texture.getRegionWidth() / (float) texture.getRegionHeight();
//        setWidth(height * aspect);
//        System.out.println(worldBounds);
     /*   super.setCenter(Indeterminacy.nextFloat(worldBounds.getX(), worldBounds.getRight()),
                          Indeterminacy.nextFloat(worldBounds.getY(), worldBounds.getBottom()));
         System.out.println(worldBounds + " " + getCenterX() + ":" + getCenterY()
                        + " " + getX() + ":" + getY()
                        + " " + getWidth() + ":" + getHeight());*/
//        System.out.println();
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

        universe.draw(
                texture, // текущий регион
                getLeft(), getBottom(), //точка отрисовки
                getCenterX(), getCenterY(), // точка вращения
                getWidth(), getHeight(), // ширина и высота
                scale, scale, // масштаб по x и y
                angle // угол вращения
        );
    }

    @Override
    public void move(float deltaTime) {
        /*
        System.out.println("vel " + velocity);
        Vector2 position = getCenter().cpy();
//        position.add(velocity);
        System.out.println(position);
        position.add(velocity);
//        position.mulAdd(velocity, deltaTime);
        System.out.println(position);
        setCenter(position);

        stayInBounds();*/
    }

    private void stayInBounds() {
//        if(getRight() < worldBounds.getLeft()) setLeft(worldBounds.getRight());
//        if(getLeft() > worldBounds.getRight()) setRight(worldBounds.getLeft());
//        if(getTop() < worldBounds.getBottom()) setTop(worldBounds.getTop());
//        if(!worldBounds.contains(this)) this.y = worldBounds.getHeight();
//        if(getBottom() )
    }

    @Override
    public void setVelocity() {
        float vx = Indeterminacy.nextFloat(-0.5f, 0.5f);
        float vy = Indeterminacy.nextFloat(-0.5f, -0.1f);
//        vx = Indeterminacy.nextFloat(-1f, -1f);
        vy = Indeterminacy.nextFloat(-0.3f, -0.1f);
        velocity.set(0.00f, -0f);
//        velocity.set(Indeterminacy.nextFloat(-0.5f, 0.5f), Indeterminacy.nextFloat(-0.5f, -0.1f));
    }
}
