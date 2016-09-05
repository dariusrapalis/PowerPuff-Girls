package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {

    private Main game;
    private Settings settings;

    private SpriteBatch batch;

    private Texture bg[];

    private TargetableCamera cam;

    public GameScreen(Main game) {
        this.game = game;
        this.settings = game.settings;
        this.batch = game.batch;

        cam = new TargetableCamera(Main.V_WIDTH, Main.V_HEIGHT);
        cam.setPosition(Main.V_WIDTH/2, Main.V_HEIGHT/2);
        cam.setMargin(0);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        cam.update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);

        batch.begin();

        batch.draw(game.introBackground[(int) Math.floor(Math.random()*game.introBackground.length)], 0, 0);

        batch.end();


    }

    @Override
    public void resize(int width, int height) {
        cam.updateViewport();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
