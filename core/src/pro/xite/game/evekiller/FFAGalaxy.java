package pro.xite.game.evekiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by nnm on 12/8/17.
 */

public class FFAGalaxy extends TextureRegion {

    private final String ffaGalaxyImageFilename = "farfarawaygalaxy.jpg";
    Texture texture;
    TextureRegion crop;
    SpriteBatch spriteBatch;

    public FFAGalaxy(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        texture = new Texture(ffaGalaxyImageFilename);
        crop = getRandomTextureRegion();
    }

    public void render() {
        spriteBatch.draw(crop, 0,0);
    }

    public void dispose() {
        texture.dispose();
    }

    private TextureRegion getRandomTextureRegion() {
        int x = (int) (Math.random() * (texture.getWidth() - Gdx.graphics.getWidth()));
        int y = (int) (Math.random() * (texture.getHeight() - Gdx.graphics.getHeight()));
        return new TextureRegion(texture, x, y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

}
