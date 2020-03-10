package kg.attracktor.hw51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "years")
public class Year {

    @Id
    private String id;
    private int year;
}
