package pro.xite.game.evekiller.darkmatter;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.HashMap;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public class Singularity {

    private static HashMap<String, TextureRegion> objects = new HashMap<String, TextureRegion>();


    private static String mainAtlasTpack = "textures/mainAtlas.tpack";
    static TextureAtlas atlas = new TextureAtlas(mainAtlasTpack);

    public static TextureRegion bang(String name) {
        if(objects.containsKey(name))
            return objects.get(name);

        TextureRegion brandnewTexture = atlas.findRegion(name);
        objects.put(name, brandnewTexture);

        return brandnewTexture;
    }

    public static TextureRegion[] bangAndDiffuse(String name, int rows, int cols, int frames) {

            TextureRegion region = bang(name);
            if(region == null) throw new RuntimeException("Split null region");

            TextureRegion[] regions = new TextureRegion[frames];
            int tileWidth = region.getRegionWidth() / cols;
            int tileHeight = region.getRegionHeight() / rows;

            int frame = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    regions[frame] = new TextureRegion(region, tileWidth * j, tileHeight * i, tileWidth, tileHeight);
                    if(frame == frames - 1) return regions;
                    frame++;
                }
            }
            return regions;
    }

}
