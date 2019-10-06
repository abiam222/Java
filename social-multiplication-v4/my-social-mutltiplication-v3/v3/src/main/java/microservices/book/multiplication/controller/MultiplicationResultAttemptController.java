package microservices.book.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    //ResponseEntity<ResultResponse>
    ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        // return ResponseEntity.ok(
        //         new ResultResponse(multiplicationService
        //                 .checkAttempt(multiplicationResultAttempt)));//I want to return an object

        boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);

        MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(
            multiplicationResultAttempt.getUser(),
            multiplicationResultAttempt.getMultiplication(),
            multiplicationResultAttempt.getResultAttempt(),
            isCorrect
        );

        //Right now we know how the response data object looks like (MultiplicationResultAttempt)
        return ResponseEntity.ok(attemptCopy);//return ResponseEntity of type MultiplicationResultAttempt
    }
    
    // @RequiredArgsConstructor
    // @NoArgsConstructor(force = true)
    // @Getter
    // static final class ResultResponse {
    //     private final boolean correct;//my response 
    // }

    @GetMapping
    ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias ){
        return ResponseEntity.ok(
            multiplicationService.getStatsForUser(alias)
        );
    }
}
