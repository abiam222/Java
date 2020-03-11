







class Adder {
    private String inFile, outFile;
    
    public Adder(String inFile, String outFile) {}

    public void doAdd() throws IOException {
        // int total = 0;
        // String line = null;

        // //newBufferedReader thread will go read the file (other resources can be used while this is happening)
        // //synchorniously we are waiting until we read
        // try(BfferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
        //     while((line=reader.readLine()) != null)
        //         total += Integer.parseInt(inline);
        // }
        // //Buffered writer thread being used
        // try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
        //     writer.write("Total: " + total);
        // }

        //If you are using threads threads you might*** not need the try
        //catch bc the threads are handling the exceptions

        // String[] inFiles = {"./file1.txt", ... "./fil6.txt"}
        // String[] outFiles = {"./file1.out.txt", ... "./fil6.out.txt"}

        // Thread[] threads = new Thread[inFiles.length];

        // for(i<inFiles.length) {
        //     Adder adder = new Adder(inFiles[i], outFiles[i])
        //    // Thread thread= new Thread(adder);
        //   //  thread.start(); remove this because we want reference to our threads
        //     threads[i] = new Thread(adder);//have reference to thread obj
        //     threads[i].start();//adds thread to this array
        // }

        // //we want reference to our threads to do this
        // for(Thread thread: threads) {
        //     thread.join(); //blocks waiting for thread completion
        //     //if not theres a potential the main thread can be killed
        //     //before finishing background jobs
        // }

        //But 
        //what if we have thousands of files, we can use a thread pool
    //     String[] inFiles = {"./file1.txt", ... "./fil6.txt"}
    //     String[] outFiles = {"./file1.out.txt", ... "./fil6.out.txt"}

    //     //the 3 - won't run more than 3 threads at a time
    //     ExecutorService es = Executors.newFixedThreadPool(3);

    //     for(i<inFiles.length) {
    //         Adder adder = new Adder(inFiles[i], outFiles[i])
    //         es.submit(adder);//submit in thread pool
    //     }
       
    //    try  {
    //     es.shutdown();//finish the rest of the work. No more new work'
    //     //if we want we can wait for the shutdown
    //     es.awaitTermination(60, TimeUnit.SECONDS)
    //    } catch(Exception e) {...}
        
       //For this example the process will end up adding (possibly) all threads in the queue
       //but only 3 will run at the same time. Once one of the threads is done opening the file
       //the next thread in line will open the next file and etc


        //Multithreaing isn't usally loosely coupled
        //caller may need result from worker. or if is want to know if thread has succedded
        //we manally do this, but java makes it easier for us

        //We can have threading relationship types
        //Callable and Future interface

        /*
        Callable interface 
        -represents a stask to be run on a thread
            -can return restults
            -can throw exceptions
        -Only member is the call method

        Future interface
        -Represents results a thread task
        -Return by ExecutorService.submit
        -The key method is get
        -Blocks until task completes
        -Returns Callable interface results

        So instead of calling Runnable we can use Callable or Future

        */



    }

}











/*abstract
Process 
-Instance of a program/app
-Has resources such as memory etc
-Has at least one thread

Thread
-Sequence of programming instructions 
-The thingthatexecutes a programs code
-Utilizes process resources

For threads you need control over start, shutdown, and coordination
Java offers thread pools which create a qeueue for tasks and assigns taksk 
into a pool of threads

We have the following thread pool types
ExecutorService interface and Executors class

ExecutorService interface 
-Models thread pool behavior
Can submit tasks
-Request andwait for pool shutdown

Executors class
-Methods for creating thread pools
-Dynamically sized pools
-Size limited pools
-Pools that schedule tasks 

*/