package com.chadrc.training.bookstore.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService bookService;

    private BookService comicBookService;

    // Property injection
    @Autowired
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        Book book = bookService.getById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest createBookRequest) {
        Book book = bookService.createBook(
                createBookRequest.getName(),
                createBookRequest.getAuthor(),
                createBookRequest.getPrice(),
                createBookRequest.getInStock()
        );

        return ResponseEntity.ok(book);
    }
}
