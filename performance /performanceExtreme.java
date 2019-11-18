/* 

JVM and whole process from compiler to interpter and what
each does at each level 
Java APIs

Definitions
profiling
latency
bottlenecks
overhead

https://github.com/ScottOaks/JavaPerformanceTuning.

enable
-XX:+Flagname

disable
-XX:-Flagname

flags, with params
-XX:NewRatio=N

*A good alrogithm is the most important thing whne it comes 
to fast performance 

*A small written program will run faster than a large
written program. True in general of all computer programs
Especially to Java programs. The more code that has to be 
compiled, the long it will take until that code runs quicly.
The more objects that have to be allocated and discarded the more
work the GC has to do.THe more objects that are allocated and retained 
the longer a GC cycle will take. THe more classes that have to be
loaded form disk into the JVM, the longer it will take for a program ot start
The more code that is executed, the les likely that it will
fit in the hardware caches on the machine. And the more code that has to be
executed the longer it will take 

Performance on programs will overtime always decrease.
As new features are added and new standards adopted
programs can be expected to get larger and slower

You should write:
clean
straighforard code 
simple to read and understand

In this context "optimizing" is understood to mean employing
algorithmic and design changes that complicate program structure
but provide better performance. Those kinds of optimizations indeed
are best left undone until such time as the profiling of a program shows that there 
is a large benefit from performing them
What optimization does not mean is this contecxt is avoiding code
constructs that are known to be bad for performance. 

Every line of code involves a choice, and if there is a choice between two simple, 
straightforward ways of programming, choose the more performant
one. 

If there are external componenets like database connected to Java
then many performance could be improved through those components
instead of java. 

Microbenchmarks - is a test designed to measure a very
small unit of performance.
e.g. synchronized method versus a nonsynchronized method
overhead creating a thread versus usinga thread pool

Microbenchmarks may seem lika a goodidead but they are very 
difficult to write correctly. 

microbenchmarks and modeule-level benchmarks cannot always
give you the full picture of the apps performance because
when you run your app other apps could be running taking
away that CPU time. If you just run your app your performance
metric will be completely different

mesobenchmarks

Testing an entire app is the only way to know how code will
actually run

Isolating performance at a modular or operational level - 
a mesobenchmark offers a reasonable compromise but is no substitute
for testing the full application


Throughput measurement is based on the amount of work that can be 
accomplished in a certain period of time.

The difference between a response time test and a throughput test
is that client threads in a response time test sleep for some
period of time between operations. 

Performance analysis is all about visibility - knowing what
is going on inside of an application, and in the applications environment. 
Visibility is all about tools. Performacnce tunning is all about tools

Whenevever performance tests are fun data should be gathered
from the OS. At a minimum,
*Information on CPU
*Memory
*Disk Usage should be collected

===============================================
CPU Monitoring 

top (like active monitor or task manager)
vmstat (vm_stat) e.g. vmstat 1 (every 1 second)

Disk Usage

iostat

Network Usage

nicstat

Java Monitoring 
jcmd
jconsole
jhat
jmap
jinfo
jstack
jstat
jvisualvm

*/


/*

Securities/trading experience is a plus but not required
Multi-threaded/concurrent programming, lock-free algorithms
Just-in-time compilation/code path optimization
Off-heap memory management
JVM internals, tuning for low-latency
JNI, NIO
Advanced knowledge of Linux kernel/OS internal
Low-latency messaging, network protocols, network I/O in Java
Hardware stack and hardware architecture from a latency perspective


Experience building Java-based systems with strict requirements for low-latency (microseconds count) and deterministic performance. 
Performance tuning/optimization of systems/software
Shell/Bash scripting skills.
Strong academic background in Computer Science or an analytical field such as Mathematics, Physics, Engineering, etc.
Strong analytical and problem solving skills
Excellent verbal and written communication skills
Comfortable working with business users
Works well independently and in ad-hoc teams
*/
