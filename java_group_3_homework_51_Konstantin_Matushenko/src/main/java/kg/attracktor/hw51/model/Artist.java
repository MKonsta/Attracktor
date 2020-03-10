package kg.attracktor.hw51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "artists")
public class Artist {

    @Id
    private String id;
    @Indexed
    private String name;
}
