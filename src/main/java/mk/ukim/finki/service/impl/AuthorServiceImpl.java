package mk.ukim.finki.service.impl;

import mk.ukim.finki.exceptions.CountryNotFoundException;
import mk.ukim.finki.models.Author;
import mk.ukim.finki.models.Country;
import mk.ukim.finki.models.dto.AuthorDto;
import mk.ukim.finki.models.dto.CountryDto;
import mk.ukim.finki.repository.AuthorRepository;
import mk.ukim.finki.repository.CountryRepository;
import mk.ukim.finki.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }



    @Override
    public Optional<Author> create(AuthorDto authorDto) {
        Country country = countryRepository.findById(authorDto.getCountryId())
                .orElseThrow(()->new CountryNotFoundException(authorDto.getCountryId()));
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        return Optional.of(authorRepository.save(author));
    }
}
