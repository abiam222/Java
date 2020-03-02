import java.util.*;

class fileIOStream {

    public static void main(String[] args) {
        System.out.println("HELLO");
    }
}

/*

Stream - is an ordered sequence of data
	-provides a common I/O model
	-Abstracts details of underlying source or destination
Read from or write form
2 categories of streams - byte or text
In general interactions the same for both stream types 

How you would usually read something from a file:
File file = new File("SongList.txt");
BufferedReader reader = new BufferedReader(new FileReader(file));
String line = null;
while ((line=reader.readLine()) != null) {
        addSong(line);
        }
reader.close();

Readdddddddddddddddddddddddd: 
Binary Data     Text Data
InputStream     Reader
int read()      int read()
int read(byte[] buff) int read(char[] buff)

InputStream
int intVal;
while ((intVal=input.read()) >= 0) {}
        byte byteVal = (byte) intVal;
        //do something iwth byteVal
    

Text Data (one character at a time)
Reader reader = //create reader
int intVal;
while((intVal=reader.read())>=0){}
        char charVal = (char)intVal;


Reading Array of Bytes
InputStream input = 
int length;
byte[] byteBuff = new byte[10];
while((length=input.read(byteBuff))>=0){
    for (int i=0;i<length;i++){}
}

Reading Array of Characters
Reader reader = //create reader
int length;
char[] charBuff = new char[10]
while ((length = reader.read(charBuff)) >= 0) {
    char charVal = charBuff[i];
    //do something with charVal
}

Writteeeeeeeeeeeeeeeeee: 
OutpuStream:
void write(int b)
void write(byte[] buff)

Writing Bytes
byte byteVal = 100;
output.write(byteVal);
byte[] byteBuff = {0,63,127};
output.write(byteBuff)

Writer
void  write(int ch)
void write(char[] buff)
void write(String str)

Writing Characters
char charVal = 'a'
writer.write(charVal);
char[] charBuff = {'a','b','c'};
writer.write(charBuff);

String stringVal = "Hello World";
writer.write(stringVal);

These are Common Input/OuputStream Derived Classes
InputStream: ByteArrayInputerStream, PipedInputStream, FileInputStream
OutputStream: ByteArrayOutputStream, PipedOutputStream, FileOutputStream

Common Reader/Writer Derived Classes
Reader: CharArrayReader, StringReader,PipedReader,InputStreamReader(- FileReader)
Writer: CharArrayWriter, StringWriter, PipedWriter, OutputStreamWriter(-FileWriter)

Error handling:
try, catch, finally
also Automating cleanupwith AutoCloseable


Streams are often chained together
- One stream instance leverages another
- Creates higher-level functionality
- Simplifies reusability
- Chain using contructor

Can create your own "high-level" streams
-Most commonly chain similar streams
*Chain a reader over a reader, etc

Now java.nio.file preferred package for files
-java.io FileXXX streams are deprecated


*/