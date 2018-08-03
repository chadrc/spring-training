package com.chadrc.training.bookstore.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void getBookById() {
        Book mockBook = new Book();
        mockBook.setName("Harry Potter and the Philosopher's Stone");
        mockBook.setAuthor("J.K. Rowling");
        mockBook.setPrice(20.00f);

        when(bookRepository.findById("MyBook"))
                .thenReturn(Optional.of(mockBook));

        Book book = bookService.getById("MyBook");

        assertEquals("Harry Potter and the Philosopher's Stone", book.getName());
        assertEquals("J.K. Rowling", book.getAuthor());
        assertEquals(20.00f, book.getPrice(), .001);
    }

    @Test
    public void createBook() {
        Book book = bookService.createBook(
                "Harry Potter and the Philosopher's Stone",
                "J.K. Rowling",
                20.00f,
                true);

        assertNotNull(book);
    }
}
