package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements BookService {

	@Override
	public Book getBookById(int id) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		for(Book book: allBooks )
		{
			if(book.getBookId()== id) {
				check=true;
				return book;
			}
		}
		if(!check) {
		throw new BookNotFoundException("Book id is not available");
		}
		return null;
		
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		ArrayList <Book> getBookByAuthor= new ArrayList<>();
		for(Book book: allBooks )
		{
			if(book.getAuthor().equals(author)) {
				check= true;
				getBookByAuthor.add(book);
			}
		}
		if(!check) {
			throw new BookNotFoundException("Author name is not available");
		}
		return getBookByAuthor;
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		ArrayList <Book> getBookByCategory= new ArrayList<>();
		for(Book a: allBooks )
		{
			if(a.getCategory().equals(category)) {
				check= true;
				getBookByCategory.add(a);
			}
		}
		if(!check) {
			throw new BookNotFoundException("This category of book is not available");
		}
		return getBookByCategory;
		
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		List <Book > allBooks= showBooks();
		return allBooks;
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
	
		boolean check= false;
		List <Book > allBooks= showBooks();
		ArrayList <Book> getBookByLess= new ArrayList<>();
		for(Book a: allBooks )
		{
			if(a.getPrice()< price) {
				check= true;
				getBookByLess.add(a);
			}
		}
		if(!check) {
			throw new BookNotFoundException("No Book at this price!!! Thank you!!!");
		}
		return getBookByLess;
	}

	public List<Book> showBooks(){
		return Arrays.asList(new Book("java by sachin","Sachin","Java",1200, 1),
				new Book("java by Ayan","Ayan","Python",110, 2),
				new Book("Python","Sri","JS",1900, 3)
				,new Book("Js","RUPESH","Html",200, 4),
				new Book("angular","kisan","Java",5000, 5),
				new Book("html","Sachin","Python",100, 6)
				
				);
		
		
		
	}
}
