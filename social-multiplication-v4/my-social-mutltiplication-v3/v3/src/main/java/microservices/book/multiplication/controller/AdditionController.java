package microservices.book.multiplication.controller;

import microservices.book.multiplication.domain.Addition;
import microservices.book.multiplication.service.AdditionService;
//import microservices.book.multiplication.service.AdditionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.String;

/**
 * This class implements a REST API for our Multiplication application.
 */
@RestController
@RequestMapping("/additions")
class AdditionController { // final class?

    // if it says final(is constant) and needs to be initialized in constructor? I
    // think
    private final AdditionService additionService;

    //why can't I add this or AdditionController
    //private final AdditionServiceImpl additionServiceImpl;

    // DI? Or since we aren't "implementing" the 'interface' we inject it
    //since its an abstract class aka java bean??!?!?!
    @Autowired 
    AdditionController(final AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping("/random")
    public Addition getAddition() {
        return additionService.createRandomAddition();
    }

    @PostMapping("/{id}")
    public int getFactor(@PathVariable("id") String id) {
        Addition addit = new Addition();
        System.out.println(addit.getRandom());
        if ("A".equals(id))
            return additionService.getFactorA();
        else if ("B".equals(id))
            return additionService.getFactorB();

        return 0;
    }

    // @GetMapping("/{id}")
    // public Bike get(@PathVariable("id") long id) {
    // //return new Bike();
    // return bikeRepository.getOne(id);
    // }

}
