package mk.ukim.finki.service.impl;

import mk.ukim.finki.models.Country;
import mk.ukim.finki.models.dto.CountryDto;
import mk.ukim.finki.repository.CountryRepository;
import mk.ukim.finki.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {


    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> create(CountryDto countryDto) {

        Country country = new Country(countryDto.getName(),countryDto.getContinent());
        return Optional.of(countryRepository.save(country));
    }
}
