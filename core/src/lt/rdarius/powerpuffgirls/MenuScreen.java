package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MenuScreen implements Screen {


    private Main game;
    private Settings settings;

    private SpriteBatch batch;

    private TargetableCamera cam;

    private Font smallText, normalText, bigText;

    private String name;


    public MenuScreen(Main game) {
        this.game = game;
        this.batch = game.batch;
        this.settings = game.settings;

        this.cam = new TargetableCamera(Main.V_WIDTH, Main.V_HEIGHT);
        this.cam.setPosition(Main.V_WIDTH/2, Main.V_HEIGHT/2);
        this.cam.setMargin(0);
        smallText = new Font(20, Color.PINK);
        normalText = new Font(35, Color.PINK);
        bigText = new Font(50, Color.PINK);
        this.name = settings.name;
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

        if(settings.name.equals("")) {

            bigText.write("Enter Character's name and press Enter: " + name, batch, 100, 400);
            if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) name = name + "Q";
            if(Gdx.input.isKeyJustPressed(Input.Keys.W)) name = name + "W";
            if(Gdx.input.isKeyJustPressed(Input.Keys.E)) name = name + "E";
            if(Gdx.input.isKeyJustPressed(Input.Keys.R)) name = name + "R";
            if(Gdx.input.isKeyJustPressed(Input.Keys.T)) name = name + "T";
            if(Gdx.input.isKeyJustPressed(Input.Keys.Y)) name = name + "Y";
            if(Gdx.input.isKeyJustPressed(Input.Keys.U)) name = name + "U";
            if(Gdx.input.isKeyJustPressed(Input.Keys.I)) name = name + "I";
            if(Gdx.input.isKeyJustPressed(Input.Keys.O)) name = name + "O";
            if(Gdx.input.isKeyJustPressed(Input.Keys.P)) name = name + "P";
            if(Gdx.input.isKeyJustPressed(Input.Keys.A)) name = name + "A";
            if(Gdx.input.isKeyJustPressed(Input.Keys.S)) name = name + "S";
            if(Gdx.input.isKeyJustPressed(Input.Keys.D)) name = name + "D";
            if(Gdx.input.isKeyJustPressed(Input.Keys.F)) name = name + "F";
            if(Gdx.input.isKeyJustPressed(Input.Keys.G)) name = name + "G";
            if(Gdx.input.isKeyJustPressed(Input.Keys.H)) name = name + "H";
            if(Gdx.input.isKeyJustPressed(Input.Keys.J)) name = name + "J";
            if(Gdx.input.isKeyJustPressed(Input.Keys.K)) name = name + "K";
            if(Gdx.input.isKeyJustPressed(Input.Keys.L)) name = name + "L";
            if(Gdx.input.isKeyJustPressed(Input.Keys.Z)) name = name + "Z";
            if(Gdx.input.isKeyJustPressed(Input.Keys.X)) name = name + "X";
            if(Gdx.input.isKeyJustPressed(Input.Keys.C)) name = name + "C";
            if(Gdx.input.isKeyJustPressed(Input.Keys.V)) name = name + "V";
            if(Gdx.input.isKeyJustPressed(Input.Keys.B)) name = name + "B";
            if(Gdx.input.isKeyJustPressed(Input.Keys.N)) name = name + "N";
            if(Gdx.input.isKeyJustPressed(Input.Keys.M)) name = name + "M";
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) name = name + " ";
            if(Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) name = name.length() > 0 ? name.substring(0, name.length()-1) : "";
            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) settings.name = name;

        } else {
            DrawCharacterSelection();
        }

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
    
    public void DrawCharacterSelection() {

        //HANDLE INPUT
        if(Gdx.input.isKeyPressed(Input.Keys.X)) {
            randomize();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
            randomize();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            settings.hairType = 3;
            settings.accessoriesType = game.accessories.length;
            settings.hairColor.set(255, 233, 101);
            settings.accessoriesColor.set(255, 255, 255);
            settings.clothesColor.set(104, 206, 246);
            settings.eyesColor.set(104, 206, 246);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.N)) {
            settings.hairType = 1;
            settings.accessoriesType = 0;
            settings.hairColor.set(249, 162, 59);
            settings.accessoriesColor.set(226, 57, 64);
            settings.clothesColor.set(245, 150, 158);
            settings.eyesColor.set(245, 150, 158);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            settings.hairType = 2;
            settings.accessoriesType = game.accessories.length;
            settings.hairColor.set(0, 0, 0);
            settings.accessoriesColor.set(0, 0, 0);
            settings.clothesColor.set(185, 218, 137);
            settings.eyesColor.set(185, 218, 137);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
        }

        if(Gdx.input.justTouched()) {
            float x = cam.getProjectedX(Gdx.input.getX());
            float y = cam.getProjectedY(-Gdx.input.getY());

            if(x > 900 && x < 930) {
                // - 0.1
                int off = 0;
                if(y > 630+off && y < 655+off) settings.hairColor.x -= 10;
                if(y > 600+off && y < 625+off) settings.hairColor.y -= 10;
                if(y > 570+off && y < 595+off) settings.hairColor.z -= 10;
                off = -150;
                if(y > 630+off && y < 655+off) settings.accessoriesColor.x -= 10;
                if(y > 600+off && y < 625+off) settings.accessoriesColor.y -= 10;
                if(y > 570+off && y < 595+off) settings.accessoriesColor.z -= 10;
                off = -300;
                if(y > 630+off && y < 655+off) settings.eyesColor.x -= 10;
                if(y > 600+off && y < 625+off) settings.eyesColor.y -= 10;
                if(y > 570+off && y < 595+off) settings.eyesColor.z -= 10;
                off = -450;
                if(y > 630+off && y < 655+off) settings.clothesColor.x -= 10;
                if(y > 600+off && y < 625+off) settings.clothesColor.y -= 10;
                if(y > 570+off && y < 595+off) settings.clothesColor.z -= 10;
            }
            if(x > 930 && x < 955) {
                // - 0.01
                int off = 0;
                if(y > 630+off && y < 655+off) settings.hairColor.x -= 1;
                if(y > 600+off && y < 625+off) settings.hairColor.y -= 1;
                if(y > 570+off && y < 595+off) settings.hairColor.z -= 1;
                off = -150;
                if(y > 630+off && y < 655+off) settings.accessoriesColor.x -= 1;
                if(y > 600+off && y < 625+off) settings.accessoriesColor.y -= 1;
                if(y > 570+off && y < 595+off) settings.accessoriesColor.z -= 1;
                off = -300;
                if(y > 630+off && y < 655+off) settings.eyesColor.x -= 1;
                if(y > 600+off && y < 625+off) settings.eyesColor.y -= 1;
                if(y > 570+off && y < 595+off) settings.eyesColor.z -= 1;
                off = -450;
                if(y > 630+off && y < 655+off) settings.clothesColor.x -= 1;
                if(y > 600+off && y < 625+off) settings.clothesColor.y -= 1;
                if(y > 570+off && y < 595+off) settings.clothesColor.z -= 1;
            }
            if(x > 1100 && x < 1125) {
                // + 0.01
                int off = 0;
                if(y > 630+off && y < 655+off) settings.hairColor.x += 1;
                if(y > 600+off && y < 625+off) settings.hairColor.y += 1;
                if(y > 570+off && y < 595+off) settings.hairColor.z += 1;
                off = -150;
                if(y > 630+off && y < 655+off) settings.accessoriesColor.x += 1;
                if(y > 600+off && y < 625+off) settings.accessoriesColor.y += 1;
                if(y > 570+off && y < 595+off) settings.accessoriesColor.z += 1;
                off = -300;
                if(y > 630+off && y < 655+off) settings.eyesColor.x += 1;
                if(y > 600+off && y < 625+off) settings.eyesColor.y += 1;
                if(y > 570+off && y < 595+off) settings.eyesColor.z += 1;
                off = -450;
                if(y > 630+off && y < 655+off) settings.clothesColor.x += 1;
                if(y > 600+off && y < 625+off) settings.clothesColor.y += 1;
                if(y > 570+off && y < 595+off) settings.clothesColor.z += 1;
            }
            if(x > 1125 && x < 1160) {
                // + 0.1
                int off = 0;
                if(y > 630+off && y < 655+off) settings.hairColor.x += 10;
                if(y > 600+off && y < 625+off) settings.hairColor.y += 10;
                if(y > 570+off && y < 595+off) settings.hairColor.z += 10;
                off = -150;
                if(y > 630+off && y < 655+off) settings.accessoriesColor.x += 10;
                if(y > 600+off && y < 625+off) settings.accessoriesColor.y += 10;
                if(y > 570+off && y < 595+off) settings.accessoriesColor.z += 10;
                off = -300;
                if(y > 630+off && y < 655+off) settings.eyesColor.x += 10;
                if(y > 600+off && y < 625+off) settings.eyesColor.y += 10;
                if(y > 570+off && y < 595+off) settings.eyesColor.z += 10;
                off = -450;
                if(y > 630+off && y < 655+off) settings.clothesColor.x += 10;
                if(y > 600+off && y < 625+off) settings.clothesColor.y += 10;
                if(y > 570+off && y < 595+off) settings.clothesColor.z += 10;
            }
            if(x > 700 && x < 750) {
                if(y > 620 && y < 640) settings.hairType--;
                if(y > 470 && y < 490) settings.accessoriesType--;
            }
            if(x > 750 && x < 800) {
                if(y > 620 && y < 640) settings.hairType++;
                if(y > 470 && y < 490) settings.accessoriesType++;
            }


            if(settings.hairColor.x > 255)
                settings.hairColor.x = 255;
            if(settings.hairColor.x < 0)
                settings.hairColor.x = 0;

            if(settings.hairColor.y > 255)
                settings.hairColor.y = 255;
            if(settings.hairColor.y < 0)
                settings.hairColor.y = 0;

            if(settings.hairColor.z > 255)
                settings.hairColor.z = 255;
            if(settings.hairColor.z < 0)
                settings.hairColor.z = 0;


            if(settings.accessoriesColor.x > 255)
                settings.accessoriesColor.x = 255;
            if(settings.accessoriesColor.x < 0)
                settings.accessoriesColor.x = 0;

            if(settings.accessoriesColor.y > 255)
                settings.accessoriesColor.y = 255;
            if(settings.accessoriesColor.y < 0)
                settings.accessoriesColor.y = 0;

            if(settings.accessoriesColor.z >255)
                settings.accessoriesColor.z = 255;
            if(settings.accessoriesColor.z < 0)
                settings.accessoriesColor.z = 0;


            if(settings.eyesColor.x > 255)
                settings.eyesColor.x = 255;
            if(settings.eyesColor.x < 0)
                settings.eyesColor.x = 0;

            if(settings.eyesColor.y > 255)
                settings.eyesColor.y = 255;
            if(settings.eyesColor.y < 0)
                settings.eyesColor.y = 0;

            if(settings.eyesColor.z > 255)
                settings.eyesColor.z = 255;
            if(settings.eyesColor.z < 0)
                settings.eyesColor.z = 0;


            if(settings.clothesColor.x > 255)
                settings.clothesColor.x = 255;
            if(settings.clothesColor.x < 0)
                settings.clothesColor.x = 0;

            if(settings.clothesColor.y > 255)
                settings.clothesColor.y = 255;
            if(settings.clothesColor.y < 0)
                settings.clothesColor.y = 0;

            if(settings.clothesColor.z > 255)
                settings.clothesColor.z = 255;
            if(settings.clothesColor.z < 0)
                settings.clothesColor.z = 0;

            if(settings.hairType >= game.hair.length) settings.hairType = 0;
            if(settings.hairType < 0) settings.hairType = game.hair.length - 1;
            if(settings.accessoriesType > game.accessories.length) settings.accessoriesType = 0;
            if(settings.accessoriesType < 0) settings.accessoriesType = game.accessories.length;

        }
        //END OF: HANDLE INPUT



        batch.setColor(1,1,1,1);
        batch.draw(game.selectCharacterBG, 0, 0);
        batch.setColor(settings.eyesColor.x/255, settings.eyesColor.y/255, settings.eyesColor.z/255, 1);
        batch.draw(game.eyes, 100, 50);
        batch.setColor(settings.clothesColor.x/255, settings.clothesColor.y/255, settings.clothesColor.z/255, 1);
        batch.draw(game.clothes, 100, 50);
        batch.setColor(1, 1, 1, 1);
        batch.draw(game.character, 100, 50);
        batch.setColor(settings.hairColor.x/255, settings.hairColor.y/255, settings.hairColor.z/255, 1);
        batch.draw(game.hair[settings.hairType], 100, 50);
        batch.setColor(settings.accessoriesColor.x/255, settings.accessoriesColor.y/255, settings.accessoriesColor.z/255, 1);
        if(settings.accessoriesType < game.accessories.length)
            batch.draw(game.accessories[settings.accessoriesType], 100, 50);


        Vector2 offset = new Vector2(0,0);

        // HAIR
        offset.set(600, 700);
        normalText.write("Hair Style: " + settings.hairType, batch, offset.x, offset.y);
        normalText.write("Color", batch, offset.x+400, offset.y);
        normalText.write("<--    -->", batch, offset.x+100, offset.y-50);
        smallText.write("-10   -1   Red:" + settings.hairColor.x, batch, offset.x+300, offset.y-50);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-50);
        smallText.write("-10   -1   Green:" + settings.hairColor.y, batch, offset.x+300, offset.y-80);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-80);
        smallText.write("-10   -1   Blue:" + settings.hairColor.z, batch, offset.x+300, offset.y-110);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-110);

        // Accessiries
        offset.set(600, 550);
        normalText.write("Accessory Style: " + settings.accessoriesType, batch, offset.x, offset.y);
        normalText.write("Color", batch, offset.x+400, offset.y);
        normalText.write("<--    -->", batch, offset.x+100, offset.y-50);
        smallText.write("-10   -1   Red:" + settings.accessoriesColor.x, batch, offset.x+300, offset.y-50);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-50);
        smallText.write("-10   -1   Green:" + settings.accessoriesColor.y, batch, offset.x+300, offset.y-80);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-80);
        smallText.write("-10   -1   Blue:" + settings.accessoriesColor.z, batch, offset.x+300, offset.y-110);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-110);

        // Eyes
        offset.set(600, 400);
        normalText.write("Eyes", batch, offset.x, offset.y);
        normalText.write("Color", batch, offset.x+400, offset.y);
        smallText.write("-10   -1   Red:" + settings.eyesColor.x, batch, offset.x+300, offset.y-50);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-50);
        smallText.write("-10   -1   Green:" + settings.eyesColor.y, batch, offset.x+300, offset.y-80);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-80);
        smallText.write("-10   -1   Blue:" + settings.eyesColor.z, batch, offset.x+300, offset.y-110);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-110);

        // Clothes
        offset.set(600, 250);
        normalText.write("Clothes", batch, offset.x, offset.y);
        normalText.write("Color", batch, offset.x+400, offset.y);
        smallText.write("-10   -1   Red:" + settings.clothesColor.x, batch, offset.x+300, offset.y-50);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-50);
        smallText.write("-10   -1   Green:" + settings.clothesColor.y, batch, offset.x+300, offset.y-80);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-80);
        smallText.write("-10   -1   Blue:" + settings.clothesColor.z, batch, offset.x+300, offset.y-110);
        smallText.write("+1   +10", batch, offset.x+500, offset.y-110);

        smallText.write("Press B - Bubbles, N - Blossom, M - Buttercup, Z - Random. Hold X - Random", batch, 30, 30);
    }

    public void randomize() {

        settings.hairColor.set((int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255));
        settings.accessoriesColor.set((int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255));
        settings.eyesColor.set((int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255));
        settings.clothesColor.set((int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255), (int) Math.floor(Math.random()*255));

        settings.hairType = (int) Math.floor(Math.random()*game.hair.length);
        settings.accessoriesType = (int) Math.floor(Math.random()*game.accessories.length);
    }
}
