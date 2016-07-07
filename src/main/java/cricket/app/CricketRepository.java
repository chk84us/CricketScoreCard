package cricket.app;

import cricket.game.CricketGame;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface CricketRepository extends CrudRepository<CricketGame, Long> {
    CricketGame findById(long id);
}
