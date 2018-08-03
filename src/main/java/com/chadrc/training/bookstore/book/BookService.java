package com.chadrc.training.bookstore.book;

public interface BookService {
    Book getById(String id);
    Book createBook(String name, String author, Float price, Boolean inStock);
}
