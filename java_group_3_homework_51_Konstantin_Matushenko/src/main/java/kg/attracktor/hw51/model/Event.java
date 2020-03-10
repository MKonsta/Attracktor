package kg.attracktor.hw51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "events")
public class Event {

    @Id
    private String id;
    @DBRef
    private User user;
    private String action;
    @DBRef
    private Composition composition;
}
