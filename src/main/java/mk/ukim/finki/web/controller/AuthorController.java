package mk.ukim.finki.web.controller;

import mk.ukim.finki.models.Author;
import mk.ukim.finki.models.dto.AuthorDto;
import mk.ukim.finki.service.AuthorService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<Author> getAll(){
        return this.authorService.findAll();
    }

    @PostMapping("/add/author")
    public ResponseEntity<Author> addNewAuthor(@RequestBody AuthorDto authorDto){
        return this.authorService.create(authorDto)
                .map(a -> ResponseEntity.ok().body(a))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }
}
