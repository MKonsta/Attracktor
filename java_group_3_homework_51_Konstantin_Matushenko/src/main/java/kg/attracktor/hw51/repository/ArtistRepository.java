package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Album;
import kg.attracktor.hw51.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {
}
