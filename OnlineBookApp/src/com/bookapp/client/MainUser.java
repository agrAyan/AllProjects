package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;

public class MainUser {

	public static void main(String[] args) throws BookNotFoundException {
		// TODO Auto-generated method stub
		int check=0;
		do {
		BookServiceImpl bookImplt= new BookServiceImpl();
		Scanner kb= new Scanner(System.in);
		System.out.println("press 1 to get all books \n"
				+ "press 2 to get all books by bookid \n"
				+ "press 3 to get books by author \n"
				+ "Enter 4 to get book by category \n"
				+ "Enter 5 to get book by less price \n"
				+ "Enter 6 to exit");
		 check= kb.nextInt();
		
		try {
		switch(check) {
		case 1: 
				List <Book> allBooks=bookImplt.getAllBooks();
				if(allBooks== null) {
					System.out.println("no books found");
				}
				else
				{
					for(Book book:allBooks) {
						System.out.println(book);
						System.out.println();
					}
				}
				
			
			break;
			
		case 2:
			
			System.out.println("enter book Id ");
			int bookId= kb.nextInt();
			Book b= bookImplt.getBookById(bookId);
			if(b!= null) {
				System.out.println(b);
			}
			break;
		case 3:
			System.out.println("enter author name ");
			kb.nextLine();
			String authorName= kb.next();
			List<Book>authorBook= bookImplt.getBooksByAuthor(authorName);
			if(authorBook!= null) {
				for(Book book: authorBook) {
					System.out.println(book);
					System.out.println();
				}
				
			}
			break;
		case 4:
			System.out.println("enter book category ");
			kb.nextLine();
			String category= kb.next();
			List<Book>categoryList= bookImplt.getBooksByCategory(category);
			if(categoryList!= null) {
				for(Book book: categoryList) {
				System.out.println(book);
				System.out.println();
				}
			}
			break;
		case 5:
			System.out.println("enter Book price ");
			kb.nextLine();
			double price= kb.nextDouble();
			List<Book> priceList= bookImplt.getBooksByLessPrice(price);
			if(priceList!= null) {
				for(Book book: priceList) {
					System.out.println(book);
					System.out.println();
				}
				
			}
			break;
		case 6:
			System.exit(0);
			
		}
			
		}
		catch(BookNotFoundException e) {
			System.out.println(e.getMessage());
		}
		}while(check!=6);
		
			
				
		
			
			
		}
	}


