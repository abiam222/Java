import java.io.*;

public class GameSaver {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] { "bear hands", "big ax" } );
        GameCharacter three = new GameCharacter(120, "Magician", new String[] { "spells", "invisibility" });

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            System.out.println("Ones type: " + oneRestore.getType()); 
            System.out.println("Twos type: " + twoRestore.getType()); 
            System.out.println("Threes type: " + threeRestore.getType()); 

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}