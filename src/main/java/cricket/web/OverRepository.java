package cricket.web;

import cricket.domain.Over;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface OverRepository extends CrudRepository<Over, Long> {
}
