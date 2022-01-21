package webquizengine.controller;

import webquizengine.businesslayer.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class QuizController {
    @Autowired QuizService quizService;
    @Autowired CompletionService completionService;

    @PostMapping("/api/quizzes")
    public Quiz addQuiz(
            @Valid @RequestBody Quiz quiz,
            @AuthenticationPrincipal User user) {
        return this.quizService.save(quiz, user);
    }

    @GetMapping("/api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable long id) {
        return this.quizService.getId(id);
    }

    @GetMapping("/api/quizzes")
    public Page<Quiz> getAllQuiz(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return this.quizService.getAll(page, pageSize);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public Response answerQuiz(
            @PathVariable long id,
            @RequestBody Map<String, List<Integer>> answer,
            @AuthenticationPrincipal User user) {
        return this.quizService.checkAnswer(id, answer.get("answer"), user);
    }

    @DeleteMapping("/api/quizzes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuiz(@PathVariable long id, @AuthenticationPrincipal User user) {
        this.quizService.delete(id, user);
    }

    @GetMapping("api/quizzes/completed")
    public Page<Completion> getAllCompletion(
            @AuthenticationPrincipal User user,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        this.completionService.getAllCompletion(user, page, pageSize).forEach(System.out::println);
        return this.completionService.getAllCompletion(user, page, pageSize);
    }
}
