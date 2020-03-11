package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
