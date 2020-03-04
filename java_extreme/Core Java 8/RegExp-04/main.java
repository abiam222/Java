import java.nio.file.Files;
import java.util.StringJoiner;
import java.nio.file.Paths;
import java.nio.*;
import java.util.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class main {
    public static void main(String[] args) {
        // StringJoiner sj = new StringJoiner(", ");
        // StringJoiner sj2 = new StringJoiner(", ", "{", "}");
        //sj.add("alpha");
        //sj.add("theta");
        //sj.add("gamma");

        //or I can use chaining
        // sj.add("alpha").add("theta").add("gamma");
        // sj2.add("alpha").add("theta").add("gamma");
        // sj.merge(sj2);

        // System.out.println(sj.toString());
        // System.out.println(sj2.toString());
        // System.out.println(sj.toString());

        //Concat vs Format
        //Printf writes stdout and Format returns a String object
        //if you just want to display printf is good, if you need object Format is better
        int david=13, dawson=11, dillon=4, gordon=2;
        double avgDiff = ((david -dawson)+(dawson-dillon)+(dillon-gordon)) / 3.0d;

        String s1 = "My newphwes are" + david + ", " + dawson
        + ", " + dillon + ", and" + gordon + " years old";

        String s2 = String.format("My nephwes are %d, %d, %d, and %d years old", 
        david, dawson, dillon, gordon);

        String s3 = "The average age between each is " + avgDiff + " years";
        String s4 = String.format("The average age between each is %.1f years", avgDiff);

        // try {
        //     doWrite(david, dawson, dillon, gordon,avgDiff);
        // } catch(Exception e) {

        // }

        //RegExpressions    
        String s7 = "apple, apple, and orange please";

        String[] parts = s7.split("\\b");

        // for (String thePart: parts) 
        //     if (thePart.matches("\\w+"))
        //         System.out.println(thePart);

        //or using Pattern and Matcher
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(s7);

        System.out.println(pattern);
        System.out.println(matcher);

        while (matcher.find()) System.out.println(matcher.group());

    }

    //writing formatted content to a stream
    public static void doWrite(int david, int dawson, int dillon, int gordon, double avgDiff) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("myFile.txt"));

        try (Formatter f = new Formatter(writer)) {
            f.format("My nephews are %d, %d, %d, and %d years old", david, dawson, dillon, gordon);
            //f.format("The average age between each is %.1f years", avgDiff);
            //System.out.println(f);
            //System.out.println("Here");
        } catch(Exception e) {
            
        }
    }
}
