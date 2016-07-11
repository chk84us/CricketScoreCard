package cricket.web.persistence;

import cricket.domain.Delivery;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
