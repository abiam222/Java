import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


//There is no such thing as an object variable
//There are only object reference variables.

//Hence Dog d = new Dog(); this opens a new
//memory in ram for "d" to point to Dog object
class Dog {
    //if you write private your ivars can't be accessed 
        int size = 4;
        String breed;
        String name = "Dog";
    public  String specific = "Spec";
        String test = new String(); //You can do this becase "String" is an object. So is "Integer"
        // int[] nums = new int[7];//arr are obects too, in a sense
        List<Integer> myList = new ArrayList<>();// no size required, though you can
       // this above perferred over ArrayList on both sides
 
    private String nonSpecific = "non Spec";

    // Set<String> names = new HashSet<String>();
    int[] nums = new int[7];

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void myPrivateMethod() {
        System.out.println("This is a private method");
        System.out.println("This is my private var: " + nonSpecific);
    }

    public void myPublicMethod() {
        System.out.println("This is a public method");
        this.myPrivateMethod();
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void bark() {
        System.out.println("Ruff Ruff!");
    }

    public void getNewList() {
        myList.add(3);
        myList.add(8);
        myList.add(133);
        List<Integer> myNewList = new ArrayList<>();

        for (int itr : myList) {
            // System.out.println(itr);
            // int index = itr;
            itr += 1;//adding one to put in new list
            //System.out.println(itr);
            // myList.remove(index);
            myNewList.add(itr);
        }

        System.out.print(myNewList + "\n");
    }
}

class Canine extends Dog {
        int ivar = 4;
        String name = "Canine";

    // Pet[] i = new Pet[3];

    @Override
    public String getName() {
        return this.name;
    }

    @Override // if overriding the method needs to have the same type
    public void bark() {
        super.bark();//calls the parents class bark method
        System.out.println("I's a canine \n");
    }

    public void bigTeeth() {
        System.out.println("I have big teeth");
    }
}

class Lab extends Dog implements Pet {
    int ivar = 7;

    Pet[] i = new Pet[3];// you can do this because its just an array of 'type' Pet
    // Pet ip = new Pet(); //can't do this because Pet is an interface (aka abstract), ERROR!

    // Dog d = new Lab();

    public Lab() {
        System.out.println("Lab Constructor. I have begun");
    }

    @Override
    public void bark() {
        super.bark();
        System.out.println("I's a lab \n");
    }

    public String drink() {
        return "Lab drinks";
    }

    @Override
    public void beFriendly() {
        i[0] = new Lab();
        Dog d = new Lab();
        System.out.println(i[0].getClass());
        System.out.println(i[0].play());
        // doesn't work because i[0] is type Pet and the interface doesn't have 'drink'
        // System.out.println(i[0].drink());
        d.bark();

        // works because its type Lab and it has 'drink'
        // The parent would need to also have the method to call it
        String drinkStr = ((Lab) d).drink();
        System.out.println(drinkStr);
        System.out.print("Being friendly with a Lab\n");
    }

    @Override
    public String play() {
        return "play with the lab";
    }
}

class Mammal { //you can't have static here 
 
  static class MammalInner { //you can only do this 
        public void callerMam() {
            System.out.println("calling my Mammal Static Class");
        }
  }
}

class Cat { //if this class is "public" it needs to be in its own file

    public static int amtCats = 0;//only 1 to the class
    private int size;
    
    //List<int> myList = new ArrayList<>();//can't do this, because it needs to be an integer object(int and Integer are different)
    List<Integer> myList = new ArrayList<>();//but you can still put integers in the list
   // myList[0] = 4;
   // myList[1] = new Integer();

   int[] list = new int[10];//you can add ints to this array

    //int primitive
    //Int Object
    public static final double PI = 3.14;

    
    final static int x;
    //Static initializer is a block of code that
    //runs when a class is loaded, before any other code can use
    //the class, so its a great place to initilze a static final
    static {
        x = 42;
    }

    final void intList() {
        myList.add(2);//adding object, can't do [] or just add integer
        //but this autobox wraps and unwraps this for you
        myList.add(2);

        list[0] = 3; 

        //i++ can be from type Integer(will auto unwrap) and int

        int sum; 
        Integer sum2;

        sum = myList.remove(0) + list[0];
        sum2 = myList.remove(0) + list[0];

        System.out.println("First sum: " + sum + " Second sum: " + sum2);
    }

    final void manyCats() {
        //since this is final, this can't be overridden 
    }

    public static void meow() { //only accessible by the class
        System.out.println("Meow! Meow!\n");
        //amtCats = 1;//works because its static, global to class
        //size = 5; //can't use ivars in static method
    }

    public void countingCats() {
        amtCats++;
        System.out.println(amtCats);
    }

    public void resting() {
        System.out.println("I am a resting cat\n"); 
    }
}

// whole point of interface is polymorphism
// another pro of interaces is "type"
// interface is 100% pure abstract class
// Idc what class inheritance you come from just implement this interface
interface Pet { // this really says "public"
    public void beFriendly();// this really says public abstract void ...

    public String play();
}


// When you use a 'class' as a polymorphic type, the objects you can stick
// in that type must be from the same inheritacne tree
// But not just anywhere in the inheritance tree; the object must be
// from a class that is a subclass of the polymorphic type

// But when you use an interface as a polymorphic type, the objects can be
// from anywhere in the inheritacen tree. The only requirement is that the obect
// are from a class that implements the intrecae.

// A class can implement multiple interfaces

/*
 * Interview
 * 
 * Abstract vs Concrete classes
 * 
 * What is an abstract method? A method must be overwritten; has no body. If
 * class has abstract method, class must be abstract too. Implementing an
 * abstract method is just like overriding a method. Abstract methods exist
 * solely for polymorphism. Unless the sub-class is also 'abstract', then it
 * doesn't have to implement the abstract methods. If the abstract sub-class
 * doesn't implement the parents abstract methods then that sub-class subclass
 * has to (unless of course is abstract).
 * 
 * 
 * 
 * What is polymorphism?
 * https://stackoverflow.com/questions/1031273/what-is-polymorphism-what-is-it-
 * for-and-how-is-it-used Technically Animal an = new Dog(); or
 * ArrayList<Animal> list = new Arraylist And list[0] = new Dog. Poly Morphism,
 * can take many forms
 * 
 * If its so good to use polymorphic types, why don't you just make ALL your
 * methods take and return type "Object"? well 'type-safety'; You don't want a
 * Ferrari to cook. But also, if you do
 * 
 * Object o = new Ferrari(); o.goFast(); //is not legal
 * 
 * Because Java is strongly -typed language, the compiler chekcs to make sure
 * that you're calling a method on an objects that's actually capable of
 * responding. You can call a method on an object reference only if the class of
 * the reference type actually has the method.
 * 
 * polymorphism line 219 and method overidding @Override and(or?) overloading 
 * 
 * 
 * What is inheritance?
 * 
 * 
 * Interface vs Inheritance
 * 
 * Interface vs Composition
 * 
 * Method overloading? have a method with the same name, but 
 * either different return type or different amounts of params
 * 
 * 
 * All Java Objects live on the heap. The methods (invocation) and local
 * variables live in the stack Ivars are declared inside a class but not inside
 * a method Local variables are declared inside a method, including method
 * params
 * 
 * Methods must have a return type. Constructors cannot.
 * Constructors cannot be inherited 
 * 
 * The compiler creates a no-arg constructor for you only if you
 * don't create any additional arg constructors 
 * 
 * Aggregation and Composition?
 * Aggregation expresses an ‘IS A’ relationship. E.g: House is a building.
 * Composition expresses ‘HAS A’ relationship. E.g: House has a bathroom. This is a part of whole relationship where a part cannot exist without the whole.
 * Aggregation is a weaker relationship and composition is stronger.
 * Aggregations are generally achieved by extending a class and composition by implementing interface.
 

 /*

There isn't a concept of 'global' variables and method in Java OO
Mark method as public and static, or final makes it behave much like a 'global'

.jar file
Packages all the files (in the proect) through a pkzip format and turns it into
the .jar file. The goal is to compress all the files 
(imagine if you had thousands of classes)

no obect variable. Only object reference variable 

Arrays are objects too

A method uses parameters. A caller passes arguments. 


What is a wrapper class?
Create an object from a data type 

 
//////////////////////////////////////////////////////////////////
 
 Static vs Abstract vs Final

 Static - A class that also have methods and ivars (implementation) but you want it to pertain
 to the class. Not create an object but call the class directly. *You can instantiate a static class
 but there is no point because you don't want a static to do this. You need to read "How to create a static class"
 to make sure an object is not instantiated

 Abstract - A class with methods and ivars (can or not have implementation), 
 that you want to be inherited, not create an object but extend it. E.g. Object class
 You can't instantiate an object from an abstract class
 An interface is an abstract class

 Final - A class that doesn't change. AKA constant. You can obviously create an instance of this.

Static - 
1. Call class no instance (if class is static) But how do you make this?
2. Pertains and 1 value to class 
Pertains to the class, won't call it with an instance.
Sometimes there is no need to have an instance of a class. Like "Math" class.
You just want a Math.pow() or Math.something. You don't want to create an object
A static lets a method run without any instance of the class. 
Statics can't see ivars state (or non static methods)
*If there is a static variable or method it doesn't mean that the class is static

How to create a static class??
Java has static nested classes but it sounds like you're looking for a top-level static class. 
Java has no way of making a top-level class static but you can simulate a static class like this:

1. Declare your class final - Prevents extension of the class since extending a static class makes no sense
2. Make the constructor private - Prevents instantiation by client code as it makes no sense to instantiate a static class
3. Make all the members and functions of the class static - Since the class cannot be instantiated no instance methods can be called or instance fields accessed
4. Note that the compiler will not prevent you from declaring an instance (non-static) member. The issue will only show up if you attempt to call the instance member


Static class vs Abstract class or method?
The static variables or methods pertain to the class.
In a class 1 copy for each object
In an abstract class (more like a template), you want it to be used, inherited or etc
Where static, you just don't want to make an instance. You don't need to

 
Why would I want to make a class final?
 Doesn't that defeat the whole purpose of OO?
 Yes and no. A typical reason for making a class final is for security.
 YOu can't for example make a subclass of the String class. Imagine the havoc
 if someone extended the String class and susbtituted their own String subclass objects.
 

 Final - (main reason to use final for constant or make classes static?)
 A final variable means you can't change its value
 A final method means you can't override the method
 A final class means you can't extend the class (i.e. you can't make a subclass)
 If the class is final, you don't need to mark the methods final. Hence it can't be subclassed
 so none of the methods can ever be overridden. 
 You can't use ivars (that are not static) inside a static method. Because since static method pertains to class
 it doesn't know which ivar would pertain to which object, it only knows about the class
Static variables are shared. All intances of the same class share a single copy of the static variable 



 
 */