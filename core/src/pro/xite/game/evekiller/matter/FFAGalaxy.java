package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class FFAGalaxy extends GameMatter {

    static private final String ffaGalaxyImageFilename = "farfarawaygalaxy.jpg";
    TextureRegion crop;

    public FFAGalaxy(SpriteBatch spriteBatch) {

        this.texture = new Texture(ffaGalaxyImageFilename);
        this.batch = spriteBatch;
        crop = getRandomTextureRegion();
    }

    public void draw() {
        batch.draw(crop, 0,0);
    }

    private TextureRegion getRandomTextureRegion() {
        int x = (int) (Math.random() * (texture.getWidth() - Gdx.graphics.getWidth()));
        int y = (int) (Math.random() * (texture.getHeight() - Gdx.graphics.getHeight()));
        return new TextureRegion(texture, x, y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

}
