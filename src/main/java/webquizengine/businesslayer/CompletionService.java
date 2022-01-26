package webquizengine.businesslayer;

import webquizengine.repository.CompletionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CompletionService {
    @Autowired CompletionRepository completionRepository;

    public Page<Completion> getAllCompletion(User user, Integer page, Integer pageSize) {
//        System.out.println("Completion Service -> getAllCompletion " + user);
        Pageable paging = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "completedAt"));
        Page<Completion> pageResult = this.completionRepository.findAllByUser(user, paging);
//        Page<Completion> pageResult = this.completionRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult;
        } else {
            throw (new ResponseStatusException(HttpStatus.NO_CONTENT));
        }
    }
}