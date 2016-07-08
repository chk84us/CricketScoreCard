package cricket.web;

import cricket.domain.Innings;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface InningsRepository extends CrudRepository<Innings, Long> {
    public Innings findById(long id);
}
