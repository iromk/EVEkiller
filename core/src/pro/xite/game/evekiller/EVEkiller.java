package pro.xite.game.evekiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EVEkiller extends ApplicationAdapter {
	SpriteBatch batch;
	DeathStar deathStar;
	FFAGalaxy ffaGalaxy;


	@Override
	public void create () {
		batch = new SpriteBatch();
		ffaGalaxy = new FFAGalaxy(batch);
		deathStar = new DeathStar(batch);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        ffaGalaxy.render();
        deathStar.render();
        batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ffaGalaxy.dispose();
		deathStar.dispose();
	}

}
