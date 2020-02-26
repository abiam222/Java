import java.util.*;
import java.io.*;

public class SortMountains {
    List<Mountain> mtn = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return one.getName().compareTo(two.getName());
        }
    }

    class HeightCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return one.getHeight().compareTo(two.getHeight());
        }
    }

    public static void main(String[] args) {
        new SortMountains().go();
    }

    public void go() {
        mtn.add(new Mountain("Longs", 14255));
        mtn.add(new Mountain("Elbert", 14433));
        mtn.add(new Mountain("Marron", 14156));
        mtn.add(new Mountain("Castle", 14265));

        System.out.println("as entered:\n");
        displayMountain(mtn);
        
        NameCompare nc = new NameCompare();
        Collections.sort(mtn, nc);

         System.out.println("by name:\n");
         displayMountain(mtn);
         HeightCompare hc = new HeightCompare();

        Collections.sort(mtn, hc);
        Collections.reverse(mtn);
        System.out.println("by height:\n");
        displayMountain(mtn);
    }

    public void displayMountain(List<Mountain> mtnx){
        for (Mountain x: mtnx) {
            System.out.print(x.getName() + " ");
            System.out.println(x.getHeight());
            
        }
        System.out.println();
    }
}

class Mountain {
    String name;
    Integer height;
    //String nameTest;//not string
    //int heightTest;//primitive type

    Mountain(String name, Integer height){
       // System.out.println(this.name.getClass());
       // System.out.println(this.height.getClass());
       // System.out.println(this.nameTest.getClass());
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return this.name;
    }

    public Integer getHeight() {
        return this.height;
    }
}