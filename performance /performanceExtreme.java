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

*/

