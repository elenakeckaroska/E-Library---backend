package mk.ukim.finki.web.controller;


import mk.ukim.finki.models.Book;
import mk.ukim.finki.models.dto.BookDto;
import mk.ukim.finki.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> getAllBooks(Pageable pageable){
        return bookService.listBooksPaginated(pageable).getContent();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDto bookDto){
        return this.bookService.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        if(bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @PutMapping("borrow/{id}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long id){
        return this.bookService.borrow(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
