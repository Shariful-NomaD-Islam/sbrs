package com.nomad.app.repository;

import com.nomad.app.model.Book;

import java.util.List;


public interface CommonDAO {
    List<Book> getAllBook();
    Book getBook(String id);
    boolean addBook(Book book);
}
