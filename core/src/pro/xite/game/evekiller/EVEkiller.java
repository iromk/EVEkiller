package pro.xite.game.evekiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EVEkiller extends ApplicationAdapter {
	SpriteBatch batch;
	String ffaGalaxyImageFilename = "farfarawaygalaxy.jpg";
	Texture ffaGalaxy;
	TextureRegion ffaGalaxyCrop;
	DeathStar deathStar;


	@Override
	public void create () {
		batch = new SpriteBatch();
		ffaGalaxy = new Texture(ffaGalaxyImageFilename);
		ffaGalaxyCrop = getRandomTextureRegion(ffaGalaxy);
		deathStar = new DeathStar();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        batch.draw(ffaGalaxyCrop, 0f, 0f);
        batch.draw(deathStar, deathStar.getCurX(), deathStar.getCurY());
        batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ffaGalaxy.dispose();
	}

	private TextureRegion getRandomTextureRegion(Texture texture) {
	    int x = (int) (Math.random() * (texture.getWidth() - Gdx.graphics.getWidth()));
        int y = (int) (Math.random() * (texture.getHeight() - Gdx.graphics.getHeight()));
	    return new TextureRegion(texture, x, y, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
