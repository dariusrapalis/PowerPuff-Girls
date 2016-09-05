package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class LoadResources implements Screen {

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private Main game;
    private TargetableCamera cam;
    private Font font, title, text;
    private int progress = 0;

    public LoadResources(Main game) {
        this.game = game;
        batch = game.batch;
        shapeRenderer = game.shapeRenderer;

        cam = new TargetableCamera(Main.V_WIDTH, Main.V_HEIGHT);
        cam.setPosition(Main.V_WIDTH/2, Main.V_HEIGHT/2);
        cam.setMargin(0);

        font = new Font(25, 255/255.0f, 105/255.0f, 180/255.0f, 1.0f);
        text = new Font(60, 0, 0, 0, 1);
        title = new Font(150, Color.ORANGE);

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
        shapeRenderer.setProjectionMatrix(cam.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.TEAL);
        shapeRenderer.rect(0, 0, 1920, 1080);
        shapeRenderer.end();
        batch.begin();
        title.write("PowerPuff Girls!", batch, 450, 1000);
        text.write("Loading resources...", batch, 700, 550);
        switch (progress) {
            case 0:
                font.write("Loading base character...", batch, 50, 50);
                break;
            case 1:
                game.character = new Texture("images/girl.png");
                break;
            case 2:
                font.write("Loading base eyes...", batch, 50, 50);
                break;
            case 3:
                game.eyes = new Texture("images/eyes.png");
                break;
            case 4:
                font.write("Loading base clothes...", batch, 50, 50);
                break;
            case 5:
                game.clothes = new Texture("images/clothes.png");
                break;
            case 6:
                font.write("Loading base accessories...", batch, 50, 50);
                break;
            case 7:
                game.accessories = new Texture[]{
                        new Texture("images/accessories-1.png"),
                        new Texture("images/accessories-2.png")
                };
                break;
            case 8:
                font.write("Loading base hair...", batch, 50, 50);
                break;
            case 9:
                game.hair = new Texture[]{
                        new Texture("images/hair-1.png"),
                        new Texture("images/hair-2.png"),
                        new Texture("images/hair-3.png"),
                        new Texture("images/hair-4.png"),
                        new Texture("images/hair-5.png"),
                        new Texture("images/hair-6.png")
                };
                break;
            case 10:
                font.write("Loading base background images...", batch, 50, 50);
                break;
            case 11:
                game.introBackground = new Texture[]{
                        new Texture("images/Intro BG 1.png"),
                        new Texture("images/Intro BG 2.png"),
                        new Texture("images/Intro BG 3.png"),
                        new Texture("images/Intro BG 4.png"),
                        new Texture("images/Intro BG 5.png"),
                        new Texture("images/Intro BG 6.png"),
                        new Texture("images/Intro BG 7.png")
                };
                break;
            case 12:
                font.write("Loading base character customization background...", batch, 50, 50);
                break;
            case 13:
                game.selectCharacterBG = new Texture("images/SetCharacter.png");
                break;
            case 14:
                font.write("Loading music...", batch, 50, 50);
                break;
            case 15:
                game.music = new Sound[]{
                        Gdx.audio.newSound(Gdx.files.internal("music/ThemeSong-piano.mp3"))
                };
                break;
            default:
                //game.setScreen(new MenuScreen(game));
                break;
        }


        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(44/255.0f, 62/255.0f, 80/255.0f, 1));
        shapeRenderer.rect(150, 150, 1620, 150);
        shapeRenderer.setColor(new Color(52/255.0f, 152/255.0f, 219/255.0f, 1));
        shapeRenderer.rect(170, 170, progress < 15 ? 1580*(progress/15.0f) : 1580, 110);
        shapeRenderer.end();

        progress++;

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
