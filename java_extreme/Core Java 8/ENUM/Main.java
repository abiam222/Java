import java.util.*;
import java.lang.*;

enum Level {
    LOW,
    MEDIUM,
    HIGH
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hey");
        Level myVar = Level.MEDIUM;
        System.out.println(myVar);

        switch(myVar) {
            case LOW:
                System.out.println("low level");
                break;
            case MEDIUM:
                System.out.println("medium level");
                break;
        }

        for (Level var : Level.values()) {
            System.out.println(var);
        }

    }
}