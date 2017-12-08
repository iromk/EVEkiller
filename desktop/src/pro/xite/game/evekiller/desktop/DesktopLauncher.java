package pro.xite.game.evekiller.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pro.xite.game.evekiller.EVEkiller;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = true;
//		config.width = 1024;
//		config.height = 1024;
		new LwjglApplication(new EVEkiller(), config);
	}
}
