package kg.attracktor.hw51.repository;

import kg.attracktor.hw51.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {

    public Album findByName(String name);
}
