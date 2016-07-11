package cricket.web;

import cricket.domain.Delivery;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Harish Chakravarthy
 */
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
