package com.chadrc.training.bookstore.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getById(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book createBook(String name, String author, Float price) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);

        bookRepository.save(book);

        return book;
    }
}
