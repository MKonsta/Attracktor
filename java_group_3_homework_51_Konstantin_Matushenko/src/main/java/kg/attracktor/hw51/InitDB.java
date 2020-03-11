package kg.attracktor.hw51;

import kg.attracktor.hw51.enums.Action;
import kg.attracktor.hw51.model.*;
import kg.attracktor.hw51.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class InitDB {

    private CompositionRepository compositionRepository;
    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;

    @Autowired
    public InitDB(CompositionRepository compositionRepository,
                  AlbumRepository albumRepository,
                  ArtistRepository artistRepository,
                  UserRepository userRepository,
                  EventRepository eventRepository) {
        this.compositionRepository = compositionRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Bean
    public void init() {

        compositionRepository.deleteAll();
        albumRepository.deleteAll();
        artistRepository.deleteAll();
        userRepository.deleteAll();
        eventRepository.deleteAll();

        userRepository.save(new User("sss@mail.ru", "123"));

        albumRepository.save(new Album("New Ludi", 2005));

        albumRepository.save(new Album("Zakat", 2005));

        artistRepository.save(new Artist("Splin"));

        artistRepository.save(new Artist("Piknik"));

        compositionRepository.save(new Composition("Ludi",
                albumRepository.findByName("New Ludi"),
                new ArrayList<>(Arrays.asList(artistRepository.findByName("Splin")))));

        compositionRepository.save(new Composition("Po vode",
                albumRepository.findByName("Zakat"),
                new ArrayList<>(Arrays.asList(artistRepository.findByName("Splin"), artistRepository.findByName("Piknik")))));

        eventRepository.save(new Event(Action.FIND_BY_ARTIST, "Splin",
                userRepository.findByEmail("sss@mail.ru"), LocalDateTime.now()));
    }
}




















