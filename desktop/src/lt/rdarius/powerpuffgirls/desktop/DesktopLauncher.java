package lt.rdarius.powerpuffgirls.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import lt.rdarius.powerpuffgirls.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1280;
		config.height = 720;
		config.title = "PowerPuff Girls";
		config.fullscreen = false;
		new LwjglApplication(new Main(), config);
	}
}
