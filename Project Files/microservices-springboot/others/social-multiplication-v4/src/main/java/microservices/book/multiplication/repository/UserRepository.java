package microservices.book.multiplication.repository;

import microservices.book.multiplication.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * This interface allows us to save and retrieve Users
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAlias(final String alias);
    Iterable<User> findAll(); //return all entities
    long count();//return the number of entities

    //@Modifying
    //@Query("DELETE FROM USER U WHERE U.USER_ID=?1") //?1   @Param("userId")
    void delete( Long userId);//deletes the given entity, why not User?
    //update?
    //create? I"m doing it rn automatically?
}
