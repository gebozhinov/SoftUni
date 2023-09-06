package bg.softuni.Books.service;

import bg.softuni.Books.model.dto.AuthorDTO;
import bg.softuni.Books.model.dto.BookDTO;
import bg.softuni.Books.model.entity.Book;
import bg.softuni.Books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<BookDTO> findById(Long id) {
        return this.bookRepository.findById(id)
                .map(this::map);
    }

    public List<BookDTO> findAllBooks() {
        return this.bookRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
    private BookDTO map(Book book) {

        return new BookDTO().setId(book.getId())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setAuthorDTO(new AuthorDTO().setName(book.getAuthor().getName()));
    }
}
