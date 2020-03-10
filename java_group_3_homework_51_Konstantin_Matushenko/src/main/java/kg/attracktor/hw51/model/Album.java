package kg.attracktor.hw51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "albums")
@Data
public class Album {

    @Id
    private String id;
    @DBRef
    private Artist artist;
    @DBRef
    private Year year;
    private String name;

}


