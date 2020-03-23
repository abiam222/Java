

public class BankAccount {
    private final String id;
    private int balance = 0;

    public BankAccount(String id) { ... }
    public BankAccount(String id, int balance) { ... }

    public String getId() { ... }
    public synchronized int getBalance() { ... }
    public synchronized void deposit(int amount) { ... }
    public synchronized void withdrawal(int amount) { ... }

    private static void main(String[] args) {
        BankAccount acct1 = new BankAccount("1234");
        BankAccount acct2 = new BankAccount("5678", 500);
    }

    //Below is Class Instance from Type Reference 
    void doWork(object obj) {
        Class<?> c = obj.class();
        showName(c);
    }

    //? = if we dont know the type
    void showName(Class<?> theClass) {
        System.out.println(theClass.getSimpleName());//Wouldh be BankAccoutn
    }

    //This method is Class instance from String Name or Type Literal
    //All return BankAccount
    //all these point to the Instance of Class class
    void doWork2(object obj) {
        Class<?> a = Class.forName("com.jwhh.finance.BankAccount");
        Class<?> b = BankAccount.class;
        Class<BankAccount> c = BankAccount.class;


        showName(letter);
    }

}


//if we have like a class like this
public final class HVA extends BA implements Runnable {
    ...
}

//we can do

Class<?> theClass = obj.getClass();
Class<?> superClass = theClass.getSuperclass();
Class<?> interface = theClass.getInterfaces();

//From pdf
//You can also know if the class is final, if methods are
//private, protected, public and etc
//get fields
