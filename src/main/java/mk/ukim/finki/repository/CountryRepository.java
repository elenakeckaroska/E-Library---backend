package mk.ukim.finki.repository;

import mk.ukim.finki.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    public Optional<Country> findById(Long id);
}
