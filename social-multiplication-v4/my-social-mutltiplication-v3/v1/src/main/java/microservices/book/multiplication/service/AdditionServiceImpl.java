package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Addition;
import microservices.book.multiplication.service.AdditionService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

//I think final class so it can't be extended 
@Service
final class AdditionServiceImpl implements AdditionService { 

    private RandomGeneratorService randomGeneratorService;

    @Autowired //this makes no sense to me, I need this for some reason
    public AdditionServiceImpl(final RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @Override
    public Addition createRandomAddition() {
        int factorA = randomGeneratorService.generateRandomFactor();
        int factorB = randomGeneratorService.generateRandomFactor();
        return new Addition(factorA, factorB);
    }
}