package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PlayScreen implements Screen {

    private Main game;

    private OrthographicCamera gameCam;
    private Viewport gamePort;


    public PlayScreen(Main game) {
        this.game = game;
        gameCam = new OrthographicCamera();
        gamePort = new FitViewport(Main.V_WIDTH, Main.V_HEIGHT, gameCam);
        gameCam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
    }

    public void handleInput(float dt) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP)) {

        }
    }

    public void update(float dt) {
        handleInput(dt);
        gameCam.update();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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
