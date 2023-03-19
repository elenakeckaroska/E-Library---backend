package mk.ukim.finki.service;

import mk.ukim.finki.models.Book;
import mk.ukim.finki.models.Country;
import mk.ukim.finki.models.dto.BookDto;
import mk.ukim.finki.models.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> create(CountryDto countryDto);
}
