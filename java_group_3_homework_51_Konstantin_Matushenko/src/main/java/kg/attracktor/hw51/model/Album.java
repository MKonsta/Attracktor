package kg.attracktor.hw51.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document (collection = "albums")
public class Album {

    @Id
    private String id;
    @Indexed //Поиск может производиться по обеим полям, поэтому индексируем оба поля
    private String name;
    @Indexed
    private int year;

    public Album(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
