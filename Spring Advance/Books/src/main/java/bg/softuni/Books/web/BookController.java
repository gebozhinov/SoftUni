package bg.softuni.Books.web;

import bg.softuni.Books.model.dto.BookDTO;
import bg.softuni.Books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/books")
@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAllBooks() {
        return ResponseEntity.ok(this.bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long bookId) {

        Optional<BookDTO> optionalBook = this.bookService.findById(bookId);

        if (optionalBook.isEmpty()) {

            return ResponseEntity
                    .notFound()
                    .build();
        } else {

            return ResponseEntity.ok(optionalBook.get());
        }


    }


}
