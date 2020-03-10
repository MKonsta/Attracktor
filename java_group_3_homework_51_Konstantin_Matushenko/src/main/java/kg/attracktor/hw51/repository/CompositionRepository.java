package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Artist;
import kg.attracktor.hw51.model.Composition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompositionRepository extends MongoRepository<Composition, String> {
}
