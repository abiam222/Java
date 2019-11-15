import java.util.logging.*;


class perf  {
    public static void main(String[] args) {
        // log.log(Level.FINE, "I am here, and the value of X is"
        //  + calcX() + " and Y is " + calcY() );

        // //This is better
        //  if (log.isLoggable(Level.FINE)) {
        //     log.log(Level.FINE,
        //     "I am here, and the value of X is {} and Y is {}",
        //     new Object[]{calcX(), calcY()});
        //     }

            //how to call non-static method?

        new perf().doTest();
    }

    public void doTest() {
        double l;
        //int nLoops = 50;
        long then = System.currentTimeMillis();
        for (int i=0;i<nLoops;i++) {
            l = fibImpl1(50);
        }
        long now = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (now-then));
    }

    private double fibImpl1(int n) {
        if (n<0) throw new IllegalArgumentException("Must be > 0");
        if (n==0) return 0d;
        if (n == 1) return 1d;
        double d = fibImpl1(n-2)+fibImpl1(n-1);
        if (Double.isInfinite(d)) throw new ArithmeticException("Overflow");
        return d;
    }
}

