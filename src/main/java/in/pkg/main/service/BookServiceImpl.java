package in.pkg.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pkg.main.entities.Book;
import in.pkg.main.repositories.BookRepo;

@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookRepo bookRepo;

	// Get all Books
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	//Get Book By ID
	public Optional<Book> getBookById(int id)
	{
		return bookRepo.findById(id);
	}
	
	// Adding a Book
	public Book addBook(Book book)
	{
		return bookRepo.save(book);
	}
	//Update Book
	public Book updateBook(int id,Book updatedBook)
	{
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent())
	    {
			Book existingBook = optionalBook.get();
			existingBook.setName(updatedBook.getName());
			existingBook.setAuthor(updatedBook.getAuthor());
			existingBook.setBook_num(updatedBook.getBook_num());
			existingBook.setPrice(updatedBook.getPrice());
			existingBook.setStock(updatedBook.getStock());
			
			return bookRepo.save(existingBook);
			
	    }
		else
		{
			throw new RuntimeException("Book Not Found");
		}
	}
	//Delete a Book
	public void deleteBook(int id)
	{
		bookRepo.deleteById(id);
	}
	
	//Purchasing Book
	public Book purchaseBook(int id,int quantity)
	{
		Optional<Book> optionalBook = bookRepo.findById(id);
		
		if(optionalBook.isPresent())
		{
			Book book = optionalBook.get();
		
		// Check Required Stock is Available or not
		if(book.getStock() >= quantity)
		{
			book.setStock(book.getStock() - quantity);
			return bookRepo.save(book);
		}
		else
		{
			throw new RuntimeException("NO ENOUGH STOCK AVAILABLE");
		}
		}
		else
		{
			throw new RuntimeException("BOOK NOT FOUND");
		}
	}


}
