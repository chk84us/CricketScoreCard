package cricket.web.persistence;

import cricket.domain.Cricket;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface CricketRepository extends CrudRepository<Cricket, Long> {
    Cricket findById(long id);
}
