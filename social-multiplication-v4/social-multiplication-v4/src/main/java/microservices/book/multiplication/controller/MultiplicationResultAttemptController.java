package microservices.book.multiplication.controller;

import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;
import microservices.book.multiplication.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    @Autowired
    MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping
    ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
        MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(
                multiplicationResultAttempt.getUser(),
                multiplicationResultAttempt.getMultiplication(),
                multiplicationResultAttempt.getResultAttempt(),
                isCorrect
        );
        return ResponseEntity.ok(attemptCopy);
    }

    @GetMapping
    ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(
                multiplicationService.getStatsForUser(alias)
        );
    }

    @GetMapping("/count")
    ResponseEntity<Long> NumberOfEntities() {
        return ResponseEntity.ok(
            multiplicationService.NumberOfEntities()
        );
    }

    @GetMapping("/all")
    ResponseEntity<List<User>> AllUsers() {
        return ResponseEntity.ok(
            multiplicationService.AllUsers()
        );
    }

    @PostMapping("/delete")
    ResponseEntity deleteUser(@RequestBody User user) {
        System.out.println(user);//id=3 alias="abiam"
        System.out.println(user.getId());//1
        System.out.println(user.getAlias());//abiam
        return ResponseEntity.ok(
            multiplicationService.deleteUser(user)
        );
    }
}
