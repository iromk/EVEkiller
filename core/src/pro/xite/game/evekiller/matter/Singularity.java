package pro.xite.game.evekiller.matter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Dictionary;
import java.util.HashMap;

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


    public static TextureRegion bang(String s) {
        if(objects.containsKey(s)) return objects.get(s);
        TextureRegion brandnewTexture = atlas.findRegion(s);
        objects.put(s, brandnewTexture);
        return brandnewTexture;
    }

}
