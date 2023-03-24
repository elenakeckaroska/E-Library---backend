package mk.ukim.finki.service.impl;

import mk.ukim.finki.exceptions.AuthorNotFoundException;
import mk.ukim.finki.exceptions.BookNotFoundException;
import mk.ukim.finki.models.Author;
import mk.ukim.finki.models.Book;
import mk.ukim.finki.models.dto.BookDto;
import mk.ukim.finki.repository.AuthorRepository;
import mk.ukim.finki.repository.BookRepository;
import mk.ukim.finki.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> listBooksPaginated(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> create(BookDto bookDto) {

        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        return Optional.of(bookRepository
                .save(new Book(bookDto.getName(),author, bookDto.getAvailableCopies(),bookDto.getCategory())));
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(()->new BookNotFoundException(id));

        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setBookCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setAuthor(author);

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> borrow(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        return Optional.of(book);
    }
}
