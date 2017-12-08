package pro.xite.game.evekiller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pro.xite.game.evekiller.matter.DeathStar;
import pro.xite.game.evekiller.matter.FFAGalaxy;
import pro.xite.game.evekiller.matter.SelfDrawable;

public class EVEkiller extends ApplicationAdapter {
	SpriteBatch batch;
	DeathStar deathStar;
	FFAGalaxy ffaGalaxy;


	@Override
	public void create() {
		batch = new SpriteBatch();
		ffaGalaxy = new FFAGalaxy(batch);
		deathStar = new DeathStar(batch);
	}

	@Override
	public void render() {
		batch.begin();
		render(
		       ffaGalaxy,
               deathStar
            );
        batch.end();
	}

	private void render(SelfDrawable... objects) {
	    for (SelfDrawable object : objects) {
	        object.draw();
        }
    }

	@Override
	public void dispose() {
		ffaGalaxy.dispose();
		deathStar.dispose();
		batch.dispose();
	}

}
