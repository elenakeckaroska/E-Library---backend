package mk.ukim.finki.service;

import mk.ukim.finki.models.Author;
import mk.ukim.finki.models.Country;
import mk.ukim.finki.models.dto.AuthorDto;
import mk.ukim.finki.models.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> create(AuthorDto authorDto);
}
