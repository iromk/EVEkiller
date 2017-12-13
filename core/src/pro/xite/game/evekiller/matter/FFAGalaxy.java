package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * Created by Roman Syrchin on 12/8/17.
 */

public class FFAGalaxy extends GameMatter {

    static private final String ffaGalaxyImageFilename = "farfarawaygalaxy.jpg";
    TextureRegion crop;
    Vector2 position;
    private float deltaScaleFactor = 0.2f;

    public FFAGalaxy(Universe spriteBatch) {

        this.texture = new Texture(ffaGalaxyImageFilename);
        this.universe = spriteBatch;
        position = new Vector2(-200,-200);
        crop = getRandomTextureRegion();
    }

    public void draw() {
        universe.draw(crop, position.x, position.y);
    }

    private TextureRegion getRandomTextureRegion() {
//        int x = (int)(Math.random() * (texture.getWidth() - Gdx.graphics.getWidth()) - 200) - 100;
//        int y = (int)(Math.random() * (texture.getHeight() - Gdx.graphics.getHeight()) - 200) - 100;
        int x = 0;
        int y = 0;
//TODO 100 and 200 consts need to replace with calculated values depending on gdx size and scale factor

        return new TextureRegion(texture, x, y, //1000,1000);
                                         Gdx.graphics.getWidth()+400, Gdx.graphics.getHeight()+400);
    }

    public void moveTo(Vector2 delta) {
        position.sub(delta.scl(deltaScaleFactor));
    }

}
