package webquizengine.repository;

import webquizengine.businesslayer.Completion;
import webquizengine.businesslayer.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletionRepository extends PagingAndSortingRepository<Completion, Long> {
    public Page<Completion> findAllByUser(User user, Pageable pageable);
}