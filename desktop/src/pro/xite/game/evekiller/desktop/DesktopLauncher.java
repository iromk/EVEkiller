package pro.xite.game.evekiller.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pro.xite.game.evekiller.EVEkiller;

public class DesktopLauncher {

	private static float aspectRatio = 3f / 4f;
	private static int HEIGHT = 800;
	private static int WIDTH  = (int) (HEIGHT * aspectRatio);

	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.height = HEIGHT;
		config.width = WIDTH;
		new LwjglApplication(new EVEkiller(), config);
	}
}
