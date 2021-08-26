package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceStreams implements BookService {

	@Override
	public Book getBookById(int id) throws BookNotFoundException {

		
		Book book= showBooks().stream().filter((x1)-> x1.getBookId()== id).findAny().orElseThrow(()-> new BookNotFoundException("no bookId found"));
		return book;
	}

	
	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		List<Book> allBooksByAuthour= new ArrayList<>();
		
		List<Book> allBooksFilter= showBooks().stream().filter((x2)-> x2.getAuthor().equals(author)).sorted().collect(Collectors.toList());	
		allBooksByAuthour.addAll( allBooksFilter);
		
		if(allBooksByAuthour.size()!=0)
			return allBooksByAuthour;
		else {
			throw new BookNotFoundException("Author not found exception");
			}
		
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		List<Book> allBooksByCategory= new ArrayList<>();
		
		List<Book> allBooksFilter=showBooks().stream().filter((x2)-> x2.getCategory().equals(category)).sorted().collect(Collectors.toList());	
		allBooksByCategory.addAll( allBooksFilter);
		if(allBooksByCategory.size()!=0)
			return allBooksByCategory;
		else {
			throw new BookNotFoundException("Author not found exception");
			}
		
		
		
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		return Arrays.asList(showBooks()).stream().flatMap(List:: stream).sorted().collect(Collectors.toList());
		
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		
		List<Book> allBooksLessPrice= new ArrayList<>();
		
		List<Book> allBooksFilter= showBooks().stream().filter((x2)-> x2.getPrice()< price).sorted().collect(Collectors.toList());	
		allBooksLessPrice.addAll( allBooksFilter);
		if(allBooksLessPrice.size()!=0)
			return allBooksLessPrice;
		else {
			throw new BookNotFoundException("No Book at this price");
			}
		
		
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
