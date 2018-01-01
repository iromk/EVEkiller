package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.behaviours.Movable;
import pro.xite.game.evekiller.abstracts.behaviours.Projectable;
import pro.xite.game.evekiller.darkmatter.Singularity;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class Explosion extends Matter implements Movable {

    public static final float L = 65f;
    public static final float XS = 15f;
    public static final float XXS = 10f;

    protected Vector2 velocity;
    Sound explosionSound;
    boolean playingSound;
    boolean silent;

    public Explosion(Universe universe, Movable explodedObject) {
        setup(universe, explodedObject, 65f);
    }

    public Explosion() {
    }

    public void setup(Universe universe, Movable explodedObject, float width) {
        setup(universe, explodedObject, width, (Vector2) null);
    }

    public void setup(Universe universe, Movable explodedObject, float width, Projectable position, float yshift) {
        setup(universe, explodedObject, width, position.getCenter().add(0, yshift));
    }

    public void setup(Universe universe, Movable explodedObject, float width, Vector2 position) {
        textures = Singularity.bangAndDiffuse("explosion", 9, 9, 74);
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
        playingSound = false;
        frame = 0;
        silent = false;

        this.universe = universe;
        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();

        setWidth(width);
        setHeight(width / aspect);
        if(position != null)
            setCenter(position);
        else
            setCenter(explodedObject.getCenter());

        frame = 0;
        velocity = new Vector2();
        setVelocity(explodedObject.getVelocity(velocity));
    }

    public void setSilent() {
        silent = true;
    }

    @Override
    public void move(float delta) {
        setCenter(getCenter().sub(velocity));
    }

    @Override
    public void draw() {
        super.draw();
        if(!playingSound && !silent) {
            explosionSound.play();
            playingSound = true;
        }
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(frame == textures.length - 1)
            destroy();
        else {
            frame += 1;
            move(delta);
        }
    }

    @Override
    public void setVelocity() {

    }

    public void setVelocity(Vector2 newVelocity) {
        velocity.set(newVelocity.x, newVelocity.y);
    }

    @Override
    public Vector2 getVelocity(Vector2 newVelocity) {
        return newVelocity.set(velocity.x, velocity.y);
    }
}
