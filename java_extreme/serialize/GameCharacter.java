import java.io.*;

public class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;
    
    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return this.power;
    }

    public String getType() {
        return this.type;
    }

    public String getWeapons() {
        String weaponList = "";

        for (int i=0;i<weapons.length;i++) {
            weaponList += weapons[i] + " ";
        }
        return weaponList;
    }
}