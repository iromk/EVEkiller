package pro.xite.game.evekiller;

import com.badlogic.gdx.Game;

import pro.xite.game.evekiller.app.OpenSpace;

/**
 * EVEkiller is a spaceshooter game.
 * Created by Roman Syrchin
 * 
 * https://github.com/iromk/EVEkiller
 */

public class EVEkiller extends Game {

	@Override
	public void create() {

		setScreen(new OpenSpace(this));
	}

}
