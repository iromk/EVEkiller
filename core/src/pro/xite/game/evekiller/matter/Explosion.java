package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.behaviours.Movable;
import pro.xite.game.evekiller.darkmatter.Singularity;

/**
 * Created by Roman Syrchin on 12/27/17.
 */

public class Explosion extends Matter implements Movable {

    protected Vector2 velocity;
    Sound explosionSound;
    boolean playingSound;

    public Explosion(Universe universe, Movable object) {
        textures = Singularity.bangAndDiffuse("explosion", 9, 9, 74);
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
        playingSound = false;
        this.universe = universe;
        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        setWidth(65f);
        setHeight(65f / aspect);
        setCenter(object.getCenter());
        frame = 0;
        velocity = new Vector2();
        setVelocity(object.getVelocity(velocity));
    }

    @Override
    public void move(float delta) {
        setCenter(getCenter().sub(velocity));
    }

    @Override
    public void draw() {
        super.draw();
        if(!playingSound) {
            explosionSound.play();
            playingSound = true;
        }
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        if(frame == textures.length - 1) destroy();
        frame += 1;
        move(delta);
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
