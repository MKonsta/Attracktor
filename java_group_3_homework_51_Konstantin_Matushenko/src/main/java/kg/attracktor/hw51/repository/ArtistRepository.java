package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepository extends MongoRepository<Artist, String> {

    public Artist findByName(String name);
}
