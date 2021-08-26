package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface BookService  {
Book getBookById(int id) throws BookNotFoundException ;
List <Book> getBooksByAuthor(String author) throws BookNotFoundException;
List <Book> getBooksByCategory(String category) throws BookNotFoundException;
List <Book> getAllBooks() throws BookNotFoundException;
List <Book> getBooksByLessPrice(double price) throws BookNotFoundException;


}
