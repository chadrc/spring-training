package com.chadrc.training.bookstore.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ComicBookServiceImpl implements BookService {

    Logger logger = LoggerFactory.getLogger(ComicBookServiceImpl.class);
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getById(String id) {
        Optional<Book> optionalBook = bookRepository.findById(id);


        bookRepository.findAll();


        return optionalBook.orElse(null);
    }

    public Book createBook(String name, String author, Float price) {
        Book book = new Book();
        book.setId(UUID.randomUUID().toString());
        book.setAuthor(author);
        book.setName(name);
        book.setPrice(price);

        bookRepository.save(book);

        logger.info("Comic Book was created with id " + book.getId());

        return book;
    }
}
