package microservices.book.multiplication.domain;

public final class Addition{

    // Both factors
    private int factorA;
    private int factorB;
    private int random = 5;

    public Addition() {
        
    }

    public Addition(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
    }

    public int getRandom() {
        return this.random;
    }

    public int getFactorA() {
        return factorA;
    }

    public void setFactorA(int factorA) {
        this.factorA = factorA;
    }

    public int getFactorB() {
        return factorB;
    }

    public void setFactorB(int factorB) {
        this.factorB = factorB;
    }

    // Empty constructor for JSON (de)serialization
    // Multiplication() {
    //     this(0, 0);
    // }

}
