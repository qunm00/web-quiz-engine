package webquizengine.businesslayer;

import webquizengine.repository.CompletionRepository;
import webquizengine.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired QuizRepository quizRepository;
    @Autowired CompletionRepository completionRepository;
    @Autowired UserService userService;

    public QuizService() { }

    public boolean isOwner(Quiz quiz, User user) {
        return quiz.getOwner().equals(user);
    }

    public void delete(long id, User user) {
        Quiz quiz = this.getId(id);
        if (isOwner(quiz, user)) {
            this.quizRepository.delete(quiz);
        } else {
            throw (new ResponseStatusException(HttpStatus.FORBIDDEN));
        }
    }

    public Quiz save(Quiz quiz, User user) {
        quiz.setOwner(user);
        return this.quizRepository.save(quiz);
    }

    public Quiz getId(long id) {
        Optional<Quiz> quiz = this.quizRepository.findById(id);
        quiz.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return quiz.get();
    }

    public Page<Quiz> getAll(Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Quiz> pageResult = this.quizRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult;
        } else {
            return Page.empty();
        }
    }

    public Response checkAnswer(long id, List<Integer> answer, User user) {
        Quiz quiz = this.getId(id);
        System.out.println("QuizService -> checkAnswer " + quiz);
        System.out.println("QuizService -> checkAnswer " + answer);
        System.out.println("QuizService -> checkAnswer " + user);
        // why doesn't quiz.getAnswer().equals(answer) work?
        if (answer.equals(quiz.getAnswer())) {
            Completion newAnswer = new Completion();
//            newAnswer.setAnswer(answer);
            newAnswer.setId(quiz.getId());
            newAnswer.setUser(user);
            this.completionRepository.save(newAnswer);
            return new Response(true);
        } else {
            return new Response(false);
        }
    }
}

