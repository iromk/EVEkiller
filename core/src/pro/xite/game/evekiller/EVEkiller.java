package pro.xite.game.evekiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import pro.xite.game.evekiller.darkmatter.MassEffect;
import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * EVEkiller is a spaceshooter game.
 * Created by Roman Syrchin
 * 
 * https://github.com/iromk/EVEkiller
 */

public class EVEkiller extends ApplicationAdapter {

	Universe universeBatch;


	@Override
	public void create() {
		universeBatch = new Universe();
		Gdx.input.setInputProcessor(new GestureDetector(new MassEffect(universeBatch)));
	}

	@Override
	public void render() {
		universeBatch.begin();
		universeBatch.render();
        universeBatch.end();
	}

	@Override
	public void dispose() {
		universeBatch.dispose();
	}

}
