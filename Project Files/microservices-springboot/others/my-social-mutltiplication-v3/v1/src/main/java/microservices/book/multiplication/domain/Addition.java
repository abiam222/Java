package microservices.book.multiplication.domain;

public final class Addition{

    // Both factors
    private final int factorA;
    private final int factorB;

    public Addition(int factorA, int factorB) {
        this.factorA = factorA;
        this.factorB = factorB;
    }

    public int getFactorA() {
        return factorA;
    }

    public int getFactorB() {
        return factorB;
    }

    // Empty constructor for JSON (de)serialization
    // Multiplication() {
    //     this(0, 0);
    // }

}
