package kg.attracktor.hw51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "compositions")
public class Composition {

    @Id
    private String id;
    private String name;
    @DBRef
    private Album album;
}
