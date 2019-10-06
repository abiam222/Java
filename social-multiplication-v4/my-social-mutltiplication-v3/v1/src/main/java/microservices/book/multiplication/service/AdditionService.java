package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Addition;

public interface AdditionService {

    /**
     * Creates a Addition object with two randomly-generated factors
     * between 11 and 99
     *
     * @return an Addition object with random factors
     */
    Addition createRandomAddition();
}
