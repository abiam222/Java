import java.util.*; //concurrent
import java.lang.*;
import java.util.logging.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        //JDK which simplifies the exectution of tasks in async mode
        //automatically provides a pool of threads and API for asigning tasks to it
        ExecutorService es = Executors.newFixedThreadPool(5);
        BankAccount account = new BankAccount(100);

        //adding five worker threads
        for (int i=0;i<5;i++){
            Worker worker = new Worker(account);
            es.submit(worker);
        }
        //shutdown es and wait
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    //synchronized uses lock of current object instance
    //All java objects have a lock
    //can acquire the lock, use synchronized statement block
    //available to any code with a reference
    // public synchronized int getBalance() {
    //     return this.balance;
    // }

    // public synchronized void deposit(int amount) {
    //     this.balance += amount;
    // }

    // public synchronized void withdrawal(int amount) {
    //     this.balance -= amount;
    // }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdrawal(int amount) {
        this.balance -= amount;
    }
}

class Worker implements Runnable {
    private BankAccount account;
    private int startBalance;
    private int endBalance;

    public Worker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            //you can do this qnd not have synchronized in the methods
            //but this will work in a sync order where the other 
            //will deposit correct but maybe not in the correct order
            synchronized(this.account) {
                this.startBalance = account.getBalance();
                account.deposit(10);
                this.endBalance = account.getBalance();
                printBalances();
            }
            
            // this.startBalance = account.getBalance();
            // account.deposit(10);
            // this.endBalance = account.getBalance();
            // printBalances();
        }
    }

    public void printBalances() {
        System.out.println("Start Balance: " + this.startBalance);
        System.out.println("End Balance: " + this.endBalance);
        System.out.println();
    }
}