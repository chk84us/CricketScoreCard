package cricket.web.persistence;

import cricket.domain.Player;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
