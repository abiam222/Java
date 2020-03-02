package microservices.book.multiplication.controller;

import microservices.book.multiplication.domain.Addition;
import microservices.book.multiplication.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class implements a REST API for our Multiplication application.
 */
@RestController
@RequestMapping("/additions")
class AdditionController { //final class?

    //if it says final(is constant) and needs to be initialized in constructor? I think
    private final AdditionService additionService;

    @Autowired //I still don't get why we need this
    AdditionController (final AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping("/random")
    public Addition getAddition() {
        return additionService.createRandomAddition();
    }
    
}
