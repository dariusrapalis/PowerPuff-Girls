package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Main extends Game {
	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;
	public static final int V_WIDTH = 1920;
	public static final int V_HEIGHT = 1080;
	public static final int FONT_SIZE = 25;
	public Settings settings;

	//TEXTURES

	public Texture character, hair[], accessories[], clothes, eyes, introBackground[], selectCharacterBG;

	//END OF TEXTURES

	public Sound music[];

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		this.settings = new Settings();
		this.setScreen(new LoadResources(this));
	}

	@Override
	public void render () {
		super.render();
	}
}