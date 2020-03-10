package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Event;
import kg.attracktor.hw51.model.Year;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends MongoRepository<Year, String> {
}
