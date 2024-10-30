package in.pkg.main.service;

import java.util.List;
import java.util.Optional;

import in.pkg.main.entities.Book;

public interface BookService 
{
	//Get all Books
	public List<Book> getAllBooks();
	//Get Book By ID
	public Optional<Book> getBookById(int id);
	//Add new Book
	public Book addBook(Book book);
	//Update a Book
	public Book updateBook(int id,Book book);
	//Delete a book
	public void deleteBook(int id);
	
	//Purchase Book
	public Book purchaseBook(int id,int quantity);
	

}
