package kz.attractorschool.moviereviewrr.repository;

import kz.attractorschool.moviereviewrr.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    Iterable<User> findAll(Sort s);

    boolean existsByEmail(String email);

    User getFirstByEmailContaining(String i);

    User getUserByEmail(String email);

    User findUserByName(String name);
}
