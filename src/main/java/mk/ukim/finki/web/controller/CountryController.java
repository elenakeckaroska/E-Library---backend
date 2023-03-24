package mk.ukim.finki.web.controller;

import mk.ukim.finki.models.Book;
import mk.ukim.finki.models.Country;
import mk.ukim.finki.models.dto.BookDto;
import mk.ukim.finki.models.dto.CountryDto;
import mk.ukim.finki.service.CountryService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.findAll();
    }

    @PostMapping("/add/country")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto countryDto){
        return this.countryService.create(countryDto)
                .map(c -> ResponseEntity.ok().body(c))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

}
