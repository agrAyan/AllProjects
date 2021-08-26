package com.bookapp.model;

public class Book {
public Book() {
		super();
	}
@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", bookId=" + bookId + "]";
	}
public Book(String title, String author, String category, double price, int bookId) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.price = price;
		this.bookId = bookId;
	}
public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
private String title;
private String author, category;
private double price;
private int bookId;
}
