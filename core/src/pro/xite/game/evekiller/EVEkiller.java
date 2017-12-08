package pro.xite.game.evekiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;

import pro.xite.game.evekiller.darkmatter.MassEffect;
import pro.xite.game.evekiller.darkmatter.Universe;
import pro.xite.game.evekiller.matter.DeathStar;
import pro.xite.game.evekiller.matter.FFAGalaxy;

public class EVEkiller extends ApplicationAdapter {
	Universe universeBatch;
	DeathStar deathStar;
	FFAGalaxy ffaGalaxy;


	@Override
	public void create() {
		universeBatch = new Universe();
//		ffaGalaxy = new FFAGalaxy(universeBatch);
//		deathStar = new DeathStar(universeBatch);
		Gdx.input.setInputProcessor(new GestureDetector(new MassEffect(universeBatch)));
	}

	@Override
	public void render() {
		universeBatch.begin();
		universeBatch.render();
//		render(
//		       ffaGalaxy,
//               deathStar
//            );
        universeBatch.end();
	}

//	private void render(SelfDrawable... objects) {
//	    for (SelfDrawable object : objects) {
//	        object.draw();
//        }
//    }

	@Override
	public void dispose() {
//		ffaGalaxy.dispose();
//		deathStar.dispose();
		universeBatch.dispose();
	}

}
