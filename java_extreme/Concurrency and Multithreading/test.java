import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.lang.Object;
import java.util.stream.*;

class test {
    public static void main(String[] args) {
        //singleThreaded();
        threadStart();
        
        // try {
        // timeUnit();
        // } catch(InterruptedException e) {
        //     System.out.println(e);
        // }
    }

    public static void timeUnit() throws InterruptedException {
        int val = 3;

        System.out.println("Sleeping for " + val + "us");
        TimeUnit.MICROSECONDS.sleep(val);
        
        System.out.println("Sleeping for " + val + "ms");
        TimeUnit.MILLISECONDS.sleep(val);

        System.out.println("Sleeping for " + val + "s");
        TimeUnit.SECONDS.sleep(val);

        System.out.println("Done");
    }

    public static void singleThreaded() {
        //single threaded program. But GC is created in background
        String countries[] = { "France", "India", "China", "USA", "Germany"};

        // for (String country: countries) {
        //     System.out.println("Hello " + country + "!");
        // }
        //Java 8
        Arrays.stream(countries).forEach(country -> System.out.println("Hello " + country + "!"));
    }

    public static void threadStart() {
        //single threaded program. But GC is created in background
        String countries[] = { "France", "India", "China", "USA", "Germany"};

        for (String country: countries) {
           // new Thread().start();
           //threads persist until exiting run()
           //new Greeter(country).start();// create multiple threads
           //new Greeter(country).run(); //single thread
           //run vs start??
           //new Greeter(...)only on extend s Threads

           //for implements Runnable
           Greeter greeter = new Greeter(country);
           new Thread(greeter, country+" thread").start();
           //Thread state machine: New, Runnable(timed_waiting), Terminated
            //we can use void sleep(long millis)
            //or TimeUnit sleep
        }
    }

    public static class Greeter implements Runnable {//extends Thread {
        private String country;

        public Greeter(String country) {
            //super(country + "thread");only on extends Thread
            this.country = country;
        }

        @Override
        public void run() {
            //long id = Thread.currentThread().getId();
            try {
                Thread.sleep(90000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println("Hello " + country + "!");
        }
    }
 
}


//Concurrency, Multitasking, and Multithreading
//Basic cache theory

/*
Concurrency - is running several things at the same time

Multitasking - running several process on the same machine.
Each could make progress without any help

Process Characteristics - 
    - Usually standalone
    - Often no knowledge of each other
    - own memory allocation (and usually segmentation)

Threads 
    - Share memory and resources
    - likely to have lower overheads than processes
    - part of the same program

    Will Threads Run in parallel?
    No guarentee
    The scheduler uses time slicing
    JVM manages thread in the scheduler

    Threads are lightweight but not free.
    They need their own stack
    have some memory overhead
    creating and destorying takes time
    Scheduler swapping one to the next takes time

    Too Many Threads
    Run the machine out of Memory 

    Concurrency - When a task is broken down into smaller pieces
    and run simultaneously 

    Parallelism -
    Multithreading and mulitasking do not require it
    So neither does concurrency 
    IT would be useful to run concurrent parts in parallel

    Even without Parallelism:
    Some parts might block

    Optimum Num of Threads
    - Keep all available cores busy
        -Maximise throughput
        -Minimise time take to complete

    -Need to determin optimum thread number
        -Make it tweakable

    How do we determine optimum number?
    Estimate, use models (Amdahls law), and experiment on prod systems

    Task is broken down into smaller pieces
    Run simultaneously
        -Tasks (processes) in multitasking
        -Threads in multithreading
        -Dsitribution of work across a grid or the cloud 

    Multithreading - running several threads of computation at the 
    same time in the same process
    -Threads share memory and resources plus they can interact

    Does multithreading require the ability to run in parallel?
    No: 
    - Time slicing allows threads to run simultaneously
    - No guarentee that threads will ever run in parallel

    Can you have unlimited num of threads?:
    Technically yes, but
    Each requires 
        -own stack
        -memory to manage
    
    smaller number of cores
    - time slicing

    too many threads will either run the machine out of memory or 
    cause starvation 

    Suggest issues that might occur in a multithreaded system with 
    respect to caching? (we will be answering this below)

    Memory accesses are slow
    Distance between CPU and memory
    -small, but not insignificant

    Exclusive access to bus may take many clock cycles

    Therefore cache memory inside CPU

    e.g.
    CPU has
    Core 1 ... Core n
    each has L1, L2, L3 cache. the bigger the cache (L3 > L2 > ...) 
    the slower its is since it has more data 

    If we have multiple cores we can run in parallel
    
    L1 and L2 are local to the Core and L3 will be global
    and shared by all the Cores.
    The cores are all in the CPU chip

    Cache Lines
    - OFten access contigous memory 
    - Word at a time transfer is slow
    - So transfer block into cache line in cache

    Cache Synchronization
    - Synchornizing takes time (of all Ln caches)
    -Default: see value in own cores cache

    Thread will see data it wrote out
    -Assuming not modified in the meantime

    Inconsistent Data
    One thread updates while other reads
    Data read with mix of latest and stale data
        -Data structure appears inconsistent

    How do we prevent inconsistent Data?
    Use monitor or locks
    or
    publish immutable copies to other threads

    Back to question in line 98. Suggest isseues that might
    occur in a multithreadedsystem with respect to caching
    - If one core writes to its local caches then another 
    core reads, it will see stale values (its reading
    from his local cache which can have differ values).
    No guarentee when the latest udpate visible to a core

    Or also inconsistent data structres

    -----------------

    Java Process Id
    Linxu: ps

    jps - linux command

    ps -elf| grep java
    jps => get the process id
    jstack <process id>
    have todo this will java project is running

    java monitoring:
    jconsole
*/