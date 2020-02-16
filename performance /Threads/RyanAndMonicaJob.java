import java.util.logging.*;
import java.lang.*;

class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }
}

class RyanAndMonicaJob implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int x=0; x<10; x++) {
            makeWithdrawl(10);
            System.out.println("current balance is " + account.getBalance());
            if (account.getBalance() < 0) {
                System.out.println("Overdrawn!");
            }
        }
    }

    private synchronized void makeWithdrawl (int amount) {
        if (account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException ex) { ex.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + " woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdraw");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
}

/* 
This causes for an overdrawn amount
We need a lock for account access

*Why do I need to use threads? And not just program this synchronously?
You wont have to deal with this complexity 

Don't you want to use threads to have things happen at the "same time",
you don't care about order in a sense.  **IS speed an issue?
In one word, we use Threads to make Java application faster by doing multiple things at same time. In technical terms, Thread helps you to achieve parallelism in Java program. ... 
By using multiple threads, you can take full advantage of multiple cores (if you have thenm) by serving more clients and serving them faster.


Ok back to the top question, We need a lock for account access
When Ryan wants to access the bank account (to check the balance and withdraw)
he locks the lock and puts the key in his pocket. Now nobody can access the account 
since the key is gone

We need to makeWithdrawl() method to run as one atomic thing 
We need to make sure that once a thread enters the makeWithdral() methid, it 
must be allowed to finish the method before ang other thread can enter

A thread can enter a synchronized method only if the thread can get the key to the 
objects lock! The locks are not per method they are per object

*/