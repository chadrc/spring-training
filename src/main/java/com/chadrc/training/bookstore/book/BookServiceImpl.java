package com.chadrc.training.bookstore.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getById(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);


        bookRepository.findAll();


        return optionalBook.orElse(null);
    }

    public Book createBook(String name, String author, Float price, Boolean inStock) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);
        book.setInStock(inStock);

        bookRepository.save(book);

        logger.info("Book was created with id " + book.getId());

        return book;
    }
}
