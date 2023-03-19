package mk.ukim.finki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.models.enumerations.BookCategory;


import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    public Book(String name, Author author, Integer availableCopies, BookCategory bookCategory) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
    }

    public Book() {

    }
}
