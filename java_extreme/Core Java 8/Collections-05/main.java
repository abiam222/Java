import java.util.*;
import java.io.*;
import java.util.List; 
import java.util.ArrayList; 

class main {
    String key;
    String pair;

    main(String key, String pair) {
        this.key=key;
        this.pair=pair;
    }

    public static void main(String[] args){
        // ArrayList list = new ArrayList<>();
        // list.add("Foo");
        // list.add("Bar");
        // System.out.println("Elements: "   + list.size());
        // System.out.println(list.getClass().getName());
        
        // for (Object o:list) 
        //     System.out.println(o.toString());

        // String s = (String)list.get(0);
        //SomClassImadeUp c = new SomeClassIMadeUp();
        //list.add(c);

        // ArrayList<String> list = new ArrayList<>();
        // list.add("Foo");
        // list.add("Bar");

        // for(String o: list)
        //     System.out.println(o);

        // String s = list.get(0);
        // X c = new X();
        // list.add(c);//this is an error now

        // ArrayList<main> list = new ArrayList<>();
        // list.add(new main("v1","abc"));
        // list.add(new main("v2","xyz"));
        // list.add(new main("v3","abc"));

        // Object[] objArray = list.toArray();
        // //System.out.println(objArray); 
        // main[] a1 = list.toArray(new main[0]);//just for type, initializing it
        // main[] a2 = new main[3];
        // main[] a3 = list.toArray(2);

        // if (a2==a3)
        //     System.out.println("a2 & a3 reference the same array");

        //Retriving a collection from an array
        // MyClass[] myArray = {
        //     new Class   ..args
        //     new Class ...
        // }
        // Collection<MyClass> list = Arrays.asList(myArray);
        // list.forEach(c -> ...c.getLabel())
    }
}



/*

Arrays have limitations
-statically sized
-Requires explicit position management 

Collections hold and organize values
-Iterable
-Can provide type safety
-Tend to dynamically size 

A wide variety of collections are available
-Ma be a simple list of values
-Can provide optimization or sophistication
    *Ordering
    *Prevent duplicates
    *Manage data as name/value pairs


By default collections hold Object types
Collections can be type restricted
-Uses the Java concept of generics
-Type specified during collection creation

Collection type restric
Map don't implement this collection type
Extends iterable interface

Collection methods thatleverage lambdas
-forEach
-removeIf

Collection interfacecanreturn an array
toArray() method-return object array
toArray(T[] array) method return array type T

Map
SortedMap fromTree..

*/