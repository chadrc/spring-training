package com.chadrc.training.bookstore.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

//    Field injection, not recommended
//    @Autowired
    private BookRepository bookRepository;

//     Constructor injection
//     @Autowired
//     public BookController(BookRepository bookRepository) {
//         this.bookRepository = bookRepository;
//     }

    // Property injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook() {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());

        bookRepository.save(book);

        return ResponseEntity.ok(book);
    }
}
