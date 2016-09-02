package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends Game {
	public SpriteBatch batch;
	public static final int V_WIDTH = 1280;
	public static final int V_HEIGHT = 720;
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
