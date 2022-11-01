package ahmouny.me.microservice.repositories;

import ahmouny.me.microservice.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
