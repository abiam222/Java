package microservices.book.multiplication.repository;

import microservices.book.multiplication.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface allows us to save and retrieve Multiplications
 */
//PagingAndSortingRepository is good as well
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
