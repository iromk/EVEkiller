package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Dictionary;
import java.util.HashMap;

import pro.xite.game.evekiller.app.Regions;

/**
 * Created by Roman Syrchin on 12/21/17.
 */

public class Singularity {

    private static HashMap<String, TextureRegion> objects = new HashMap<String, TextureRegion>();


    private static String mainAtlasTpack = "textures/mainAtlas.tpack";
    static TextureAtlas atlas = new TextureAtlas(mainAtlasTpack);

//    {
//        atlas = new TextureAtlas("textures/mainAtlas.tpack"); //new TextureAtlas(mainAtlasTpack);
//        System.out.println("aa : " + atlas);
//
//    }


    public static TextureRegion bang(String name) {
        if(objects.containsKey(name))
            return objects.get(name);

        TextureRegion brandnewTexture = atlas.findRegion(name);
        objects.put(name, brandnewTexture);

        return brandnewTexture;
    }

    public static TextureRegion[] bangAndDiffuse(String name, int rows, int cols, int count) {

        return Regions.split(bang(name), rows, cols, count);
    }

}
