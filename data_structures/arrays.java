import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Object;
import java.util.stream.*;

class arrays {
    //arrays, arraylist, 2d
    int[] val = new int[5];
    int[] val8 = new int[5];
    Integer[] val2 = new Integer[5];
    Integer[] val9 = new Integer[5];
    List<Integer> val3 = new ArrayList<>();
    int[] val4 = {1,2,4,6,7};
    //List<integer> val5 = new ArrayList<>();YOU CAN"T DO THIS
    //List<Integer> val6 = Arrays.asList(5,6,7,8,9);//don't return actual ArrayList
    List<Integer> val6 = new ArrayList<>(Arrays.asList(5,6,7,8,9));
    List<Integer> val7 = new ArrayList<>();

    public static void main(String[] args) {
        //forEach, for of, for(;;)
        //new arrays().arrs();//algo can only be called by an instance
        //hence an instance of this class
        
        arrays myObj = new arrays();
        //myObj.arrs();
        //myObj.strings();
        myObj.maths();
    }

    public void arrs() {
        val[0] = 5;
        val8[0] =  6;
        val2[0] = 20;
        val3.add(13);
        val3.add(14);
        val7.add(15);
        val7.add(16);
        val9[0]=17;
        val9[1]=18;
        // System.out.println(val[0]);
        // System.out.println(val2[0]);
        // System.out.println(val3.get(0));
        // System.out.println(val4[0]);
        // System.out.println(val6.get(0));//can't do val6[0]
        //Integer[] both = ArrayUtils.addAll(val2, val9);
        //System.out.println(Arrays.toString(list.toArray()));

        //Java 8
        Integer[] both = Stream.concat(Arrays.stream(val2), Arrays.stream(val9)).toArray(Integer[]::new);

        for (Integer x:both) {
            //System.out.println(x + " ");
        }

        for (int i=0;i<val4.length;i++) {
            //System.out.print(val4[i] + " ");
        }
        //System.out.println();

        for (int i=0;i<val6.size();i++) {
            //System.out.print(val6.get(i) + " ");
        }
        
        //merge two list together
        val3.addAll(val6);
        //Stream.of(val3, val7).forEach(val3::addAll);

        //System.out.println();
        //val3.forEach(x -> System.out.print(x + " "));

        //System.out.println();
        for (int x: val3) {
            //System.out.print(x + " ");
        }

        val3.forEach(x -> System.out.print(x + " "));
        System.out.println();

        Collections.sort(val3);
        val3.forEach(x -> System.out.print(x + " "));
        System.out.println();

        Collections.reverse(val3);
        val3.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public void strings() {
        String str = new String("Welcome to Tutorialspoint.com");
        System.out.println(str.toUpperCase() );
        System.out.println(str.toLowerCase() );
    }

    public void maths() {
        int val = 5;
        System.out.println(val);
        System.out.println(val/2);//rounds down
        System.out.println(Math.ceil(val/2));//down with decimal
        System.out.println((int)Math.ceil(val/2));//down with decimal
    }

}