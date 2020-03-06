import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class Main{

    public static void main(String[] args) {
        //doTryCatchFinally
       // doTryWithResources();
       doTryWithResourcesMulti();
       //doCloseThing()
    }


    public static void doTryCatchFinally(){
        char[] buff = new char[8];
        int length;
        Reader reader = null;
        try {
            reader = Helper.openReader("file.txt");
            while((length=reader.read(buff))>=0) {
                System.out.println("\nlength: " + length);
                for (int i=0;i<length;i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -  " + e.getMessage());
        } finally {
            try {
                if (reader!=null) reader.close();
            } catch(IOException e2) {
                System.out.println(e2.getClass().getSimpleName() + " -  " + e2.getMessage());
            }
        }
    }

    public static void doTryWithResources(){
        char[] buff = new char[8];
        int length;
        //putting Reader here says that you want it automatically closed
        try (Reader reader = Helper.openReader("file.txt") ) {
            while((length=reader.read(buff))>=0) {
                System.out.println("\nlength: " + length);
                for (int i=0;i<length;i++) {
                    System.out.println(buff[i]);
                }
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -  " + e.getMessage());
        }
    }

    public static void doTryWithResourcesMulti(){
        char[] buff = new char[26];
        int length;
        //putting Reader here says that you want it automatically closed
        try (
            Reader reader = Helper.openReader("file.txt");
            Writer writer = Helper.openWriter("file2.txt");
            BufferedReader reader2 = new BufferedReader(new FileReader("file.txt"));
        ) {
            // while((length=reader.read(buff))>=0) {
            //     System.out.println("\nlength: " + length);
            //     writer.write(buff, 0, length);
            // }
            String line = null;
            while((line=reader2.readLine())!=null) {
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " -  " + e.getMessage());
        }
    }

    private static void doCloseThing() {
        try(MyAutoCloseable ac = new MyAutoCloseable()) {
            ac.saySomething();
        } catch(IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
            for (Throwable t: e.getSuppressed())
                System.out.println("Suppressed: " + t.getMessage());
        }
    }
}

class Helper {
    static public Reader openReader(String fileName) throws IOException {
        return Files.newBufferedReader(Paths.get(fileName));
    }

    static public Writer openWriter(String fileName) throws IOException {
        return Files.newBufferedWriter(Paths.get(fileName));
    }

}

class MyAutoCloseable implements AutoCloseable {
    public void saySomething() throws IOException {
        throw new IOException("Exception from saySomething");
       // System.out.println("Something");
    }
    
    @Override
    public void close() throws IOException {
        System.out.println("close");
    }
}