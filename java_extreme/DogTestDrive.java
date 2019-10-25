class DogTestDrive {
    //Main uses of main
    //Test your real class
    //Launch/Start your Java App
    //If you do things in main you aren't doing OOP
    public static void main(String[] java) {
        //Remember these are new objects that have pointers 
        //and references

        //you have data types
        //which can be primitive or reference
        //primitive are your int, long, short etc
        //but reference are you Dog d = new Dog() which
        //is a reference data type in Java

        //Dog d = new Dog();
        //Dog c = new Dog();
        //Dog b = new Dog();

        //d do stuff
        //c do stuff
        //b = c Now b points to the same reference as c
        //b = d Now b points to the same reference as d
        //when you start pointing objects don't forget
        //to release any pointing references

        //Dog d = new Dog();
       // Dog d2 = new Canine();
        //Canine d3 = new Canine();

        //Even array of Dogs is a variable refrencing objects
       // Dog[] pets = new Dog[7];
        //pets points to an array[7] of type Dogs (which)
        //are not initialized 
        //then we could do pets[0] = new Dog(); in which
        //that array index would reference the Dog class
        //pets[0] = new Dog();
        //pets[1] = new Dog();
        //pets[0].bark();
        //System.out.println ( pets[1].getName()); 
        //pets[0].setName("Carol");
        //System.out.println( pets[0].getName() );

        // d2.getNewList();
        // d3.getNewList();

        //Tho specific is private is not inherited

        // System.out.println( d.specific );
        // System.out.println( d.nonSpecific );

        // System.out.println( d2.specific );
        // System.out.println( d2.nonSpecific );

        // System.out.println( d3.specific );
        // System.out.println( d3.nonSpecific );

        //d.myPublicMethod();
        // d.specific = "d";
        // d2.nonSpecific = "d2"; 
        // d3.specific = "d3";
        // System.out.println( d.specific );
        // System.out.println( d2.nonSpecific );
        // System.out.println( d3.specific );

        //This is polymorphism
        //Dog d4 = new Canine();
        
        //Canine. d4 is still calling Canine class first 
        // System.out.println( d4.getName() );
        // d4.bark();
        // System.out.println( d4.name );
        //Dog, get variable from self. Variables aren't inherited

        //Also polymorphism
        // Dog d5 = new Dog();
        // Canine d6 = new Canine();
        // //because param is Dog
        // System.out.println( d5.breed );
        // System.out.println( d6.breed );

        //compiler won't let you do this, since Wolf is abstract
        //Wolf w = new Wolf();
        //Wolfie p = new Wolfie();
        //p.roam();

        Lab lab = new Lab();
        lab.play();


        // Lab d4 = new Lab();
        // Cat c = new Cat();
        // Cat c2 = new Cat();
        // Mammal.MammalInner m = new Mammal.MammalInner();
        //Test t2 = new Test();
        //Teste t = new Teste();

       // t.testing();
       // t.testing();
        // m.callerMam();
        // c.resting();
        // c.intList();
        // Cat.meow();//I can do this because meow is static
        // c.countingCats();
        // c.countingCats();
        // c2.countingCats();
        // d2.bark();
         //d2.bigTeeth();
        // System.out.println( d2.getSize() );
         //d3.bark();
        // d3.bigTeeth();
        // System.out.println( d3.getSize() );
        // System.out.println( d3.getName() ) ;
        // d4.bark();
        // d4.beFriendly();
         //d.setSize(40); //you can do this but not OOP (getters and setters)
        // System.out.println( d.getSize() );
        // d.bark();
        // d.getNewList();
    }
}

