package kg.attracktor.hw51.service;

import kg.attracktor.hw51.model.Composition;
import kg.attracktor.hw51.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public Optional<User> login(String email, String password) {
        //ToDO реализовать логику входа в систему
        return null;
    }

    public Optional<User> registration(String email, String password) {
        //ToDO реализовать логику регистрации нового пользователя
        return null;
    }

    public List<Composition> findByArtist(String email, String artistName) {
        //ToDo Реализовать логику поиска композиций по артисту.
        /**
         * На выходе будем получать список из композиций.
         * Будем регистрировать событие - юзер(имеил) производил поиск по композиции по artistName
         * и бдем инсертить это событие в коллекцию events
         * Остальные методы будут работать примерно по такойже схеме
         */

        return null;
    }

    public List<Composition> findByAlbum(String email, String albumName) {
        //ToDo Реализовать логику поиска композиций по альбому

        return null;
    }

    public List<Composition> findByYear(String email, int year) {
        //ToDo Реализовать логику поиска композиций по году выпуска

        return null;
    }

    public void listening(String email, String compositionId) {
        //ToDo Реализовать логику прослушивания композиций

    }
}
