package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Artist;
import kg.attracktor.hw51.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
