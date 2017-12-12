package pro.xite.game.evekiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

import pro.xite.game.evekiller.app.GameScreen;
import pro.xite.game.evekiller.darkmatter.MassEffect;
import pro.xite.game.evekiller.darkmatter.Universe;

/**
 * EVEkiller is a spaceshooter game.
 * Created by Roman Syrchin
 * 
 * https://github.com/iromk/EVEkiller
 */

public class EVEkiller extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}

}
