package cricket.web;

/**
 * @author Harish Chakravarthy
 */

import cricket.domain.Innings;
import org.springframework.data.repository.CrudRepository;

public interface InningsRepository extends CrudRepository<Innings, Long> {
}
