package mk.ukim.finki.models.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private String name;

    private String surname;

    private Long countryId;
}
