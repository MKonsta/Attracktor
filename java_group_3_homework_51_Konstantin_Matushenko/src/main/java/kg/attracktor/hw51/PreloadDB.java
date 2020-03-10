package kg.attracktor.hw51;

import kg.attracktor.hw51.model.User;
import kg.attracktor.hw51.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PreloadDB implements CommandLineRunner {

    private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("vova@mail.ru", "123"));

    }
}
