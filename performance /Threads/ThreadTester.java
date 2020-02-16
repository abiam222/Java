import java.util.logging.*;
import java.lang.*;

class ThreadTester  {
    public static void main(String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);

        myThread.start();
        System.out.println("back in main");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        go();
    }

    @Override
    public void go() {
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }

        doMore();
    }

    @Override
    public void doMore() {
        System.out.println("top o the stack");
    }
}



/*abstract

With more than one call stack, you get the apperance of having multiple things happen at the same
time. In reality, only a tren mltiprocess sytem can acutally do more than one thing
at a time, but with Java threads, it can appear that you're doing several things simultaneously.
In other words, execution can move back and forth between stacks so rapidly that you feel as though all 
stacks are executing at the same time. Remember, Java is just a process running on your underlying OS
Java itself has to be 'the currently expecting process' on the OS. Once java gets its turn to execute, 
exactly what does the JVM run? Which bytecodes execute? Whatever isln the top of the 
currently rnning stack!

How to lunch a new thread:
1. Make a Runnable object (the thread job)
2. Make a thread object (the worker) give it a Runnable (the job)
3. Start the Thread

EVery Thread needs a job to do. 

Once the thread becomes runnable, it can move back and forth between
runnable, running, and temporarily not runnable (aka blocked)

One of the best ways to help your threads take turns is
to put them to sleep preidoically. The sleep method throws
InterruptedExceptino a checked exception all all calls to sleep must
be wrapped in a try/catch

downside to threads is concrrenct issues

*/