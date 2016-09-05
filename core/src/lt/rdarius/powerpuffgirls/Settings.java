package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.math.Vector3;

public class Settings {

    public Vector3 hairColor, clothesColor, eyesColor, accessoriesColor;
    public int hairType, accessoriesType;
    public String name;

    public Settings() {
        this.hairColor = new Vector3(255,255,255);
        this.clothesColor = new Vector3(255,255,255);
        this.eyesColor = new Vector3(255,255,255);
        this.accessoriesColor = new Vector3(255,255,255);
        this.hairType = 0;
        this.accessoriesType = 0;
        this.name = "";
    }

}
