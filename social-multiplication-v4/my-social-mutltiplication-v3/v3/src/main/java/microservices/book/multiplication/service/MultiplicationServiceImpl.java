package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.repository.MultiplicationResultAttemptRepository;
import microservices.book.multiplication.repository.UserRepository;
//this class works without this
import microservices.book.multiplication.service.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.junit.Assert;

@Service
final class MultiplicationServiceImpl implements MultiplicationService {

    // Why can't I just Autowire this?
    private RandomGeneratorService randomGeneratorService;// is this also private if class is private?
    private MultiplicationResultAttemptRepository attemptRepository;
    private UserRepository userRepository;

    // global instead of new in the impl. Also Multiplicastion doesn't have a
    // "HAS-A" randomGenerator relationship
    @Autowired // this makes no sense to me
    public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
            final MultiplicationResultAttemptRepository attemptRepository, final UserRepository userRepository) {
        this.randomGeneratorService = randomGeneratorService;
        this.attemptRepository = attemptRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Multiplication createRandomMultiplication() {
        System.out.println("create Random Multiplicaiton called");
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Multiplication(factorA, factorB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
        // Check if the user already exists for that alias
        Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

        // Avoids hacks attempts
        // Assert.isTrue(!attempt.isCorrect(), "You can't send an attempt marked as
        // correct!");

        System.out.println("checkAttempt called");
        System.out.println(attempt);
        // you are grabbing the data from the response but instead of calling it
        // directly
        // you are calling the model. Since its an object. Unlike Node.js where you grab
        // the response data directly. I mean in Node.js sometime you put it in an
        // object
        // but here is mandatory, well it comes back as an object no matter what
        boolean isCorrect = attempt.getResultAttempt() == attempt.getMultiplication().getFactorA()
                * attempt.getMultiplication().getFactorB();

        // creates a copy, now setting the 'correct' field accordingly
        // create another var for immutability
        MultiplicationResultAttempt checkedAttempt = new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
                attempt.getMultiplication(), attempt.getResultAttempt(), isCorrect);

        //stores the attempt
        attemptRepository.save(checkedAttempt);

        // returns the result
        return isCorrect;
    }

    @Override
    public String testSer() {
        System.out.println("testSer called");
        return "This is a string";
    }

    @Override
    public List<MultiplicatoinResultAttempt> getStatsForUser(String userAlias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(userAlias);
    }
}
