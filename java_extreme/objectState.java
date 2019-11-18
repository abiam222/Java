import java.io.*;

public class objectState implements Serializable {
    private int width;
    private int height;
    //these values above will be saved

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main (String[] args) {
        objectState myOS = new objectState();
        myOS.setWidth(50);
        myOS.setHeight(20);

        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myOS);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



/*

Objects in java have state. You can save it
1) serialization
2) Write a plain text file
3) Save it in other ways 

writing a serilized object to a file
1) make a FileOutputStream
2) Make an ObjectOutputStream
3) Write the object
4) Close the ObjectOutputStream

What really happens to an object when it's serialized?
1) Object on the heap
2) Object serialized

When an object is serizlied, all the objects it refres to from
ivars are also serialized. And all the objects those object
refere to are serlialized and over and over

If you want your class to be serializable
implement "Serializable"

The Serializable interface is known as a marker or tag interface,
because the interface doen't have any methods to implement. Its
sole purpose is to announce that the class implementing it is, well
serializable. 



*/
