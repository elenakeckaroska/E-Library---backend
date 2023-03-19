package mk.ukim.finki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import lombok.Data;

@Data
@Entity

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @OneToOne
    private Country country;

    public Author(String name, String surname, Country country) {
        this.name=name;
        this.surname=surname;
        this.country=country;
    }

    public Author() {

    }
}
