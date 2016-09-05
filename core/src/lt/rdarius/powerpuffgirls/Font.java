package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Font {

    private BitmapFont mBitmapFont;

    private FileHandle fontFile = Gdx.files.internal("font/Blenda Script.otf");

    public Font(int fontSize, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        if(fontSize == 0)
            parameter.size = Main.FONT_SIZE;
        else
            parameter.size = fontSize;
        if(color != null)
            parameter.color = color;
        else
            parameter.color = Color.CYAN;
        mBitmapFont = (BitmapFont) generator.generateFont(parameter);
        generator.dispose();
    }

    public Font(int fontSize, float r, float g, float b, float a) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        if(fontSize == 0)
            parameter.size = Main.FONT_SIZE;
        else
            parameter.size = fontSize;
        if(r >= 0 && g >= 0 && b >= 0 && a >= 0)
            parameter.color = new Color(r, g, b, a);
        else
            parameter.color = Color.CYAN;
        mBitmapFont = (BitmapFont) generator.generateFont(parameter);
        generator.dispose();
    }

    public void write(String str, SpriteBatch batch, float x, float y) {
        this.mBitmapFont.draw(batch, str, x, y);
    }

}