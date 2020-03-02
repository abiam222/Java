package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistenece.*;

/**
 * Identifies the attempt from a {@link User} to solve a
 * {@link Multiplication}.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class MultiplicationResultAttempt {

    @Id 
    @GeneratedValue 
    private Long id;

    //Persist - we can store from our Java code directly the attemps,
    //and any other linked entity will be persisted (if its not already there) in their
    //corresponding tables as well
    @ManyToOne(cascade = CascadeType.PERSIST) //many (attempts) to one USER
    @JoinColumn(name = "USER_ID") //referecnce other entities usering their identifiers (name prodvided via @Column)
    private final User user;//puts USER_ID on table

    @ManyToOne(cascade = CascadeType.PERSIST) //many (attemps) to one Multiplication
    @JoinColumn(name = "MULTIPLICATION_ID")
    private final Multiplication multiplication;//MULTIPLICATION_ID on table 
    private final int resultAttempt;//RESULT_ATTEMPT

    // private final User user;
    // private final Multiplication multiplication;
    // private final int resultAttempt;
    private final boolean correct;

    // Empty constructor for JSON (de)serialization
    MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
        correct = false;
    }
}
