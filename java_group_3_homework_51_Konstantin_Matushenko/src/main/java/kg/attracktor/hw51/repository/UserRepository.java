package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByEmail(String email);
}
