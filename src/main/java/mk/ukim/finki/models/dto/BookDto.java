package mk.ukim.finki.models.dto;


import lombok.Data;
import mk.ukim.finki.models.enumerations.BookCategory;


@Data
public class BookDto {

    private String name;

    private BookCategory category;

    private Long author;

    private Integer availableCopies;
}
