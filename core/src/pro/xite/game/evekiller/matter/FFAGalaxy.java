package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.abstracts.shapes.Rectangular;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class FFAGalaxy extends GameMatter {

    static private final String ffaGalaxyImageFilename = "farfarawaygalaxy.jpg";
    TextureRegion crop;
    private float deltaScaleFactor = 0.2f;

    public FFAGalaxy(Universe batch) {
        super("");

        Texture texture = new Texture(ffaGalaxyImageFilename);
        this.universe = batch;
//        position = new Vector2(-200,-200);
        this.textures[frame] = getRandomTextureRegion(texture);
    }

    @Override
    public void resize(Rectangular worldBounds) {
        float height = worldBounds.getHeight();
        setHeight(height);
        float aspect = textures[frame].getRegionWidth() / (float) textures[frame].getRegionHeight();
        setWidth(height * aspect);
        getCenter().set(worldBounds.getCenter());
        fix();
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
        getCenter().sub(delta.scl(deltaScaleFactor));
        fix();
    }

}
