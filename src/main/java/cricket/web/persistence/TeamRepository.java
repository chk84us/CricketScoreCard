package cricket.web.persistence;

import cricket.domain.Team;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
    Team findById(long id);
}
