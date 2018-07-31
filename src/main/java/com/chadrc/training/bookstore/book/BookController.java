package com.chadrc.training.bookstore.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    //    Field injection, not recommended
//    @Autowired
    private BookService bookService;

//     Constructor injection
//     @Autowired
//     public BookController(BookRepository bookService) {
//         this.bookService = bookService;
//     }

    // Property injection
    @Autowired
    public void setBookService(BookService bookService) {
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
                createBookRequest.getPrice()
        );

        return ResponseEntity.ok(book);
    }
}
