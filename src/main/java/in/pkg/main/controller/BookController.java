package in.pkg.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pkg.main.entities.Book;
import in.pkg.main.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController
{
	@Autowired
	private BookService bookService;
	
	
	// Get all Books
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> allBooks = bookService.getAllBooks();
		return ResponseEntity.ok(allBooks);
	}
	
	//Get Book By ID
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id)
	{
		return bookService.getBookById(id).
				map(ResponseEntity::ok).
				orElse(ResponseEntity.notFound().build());
	}
	
	//Add Book
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book newBook = bookService.addBook(book);
		return ResponseEntity.ok(newBook);
	}
	//Update a Book
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book)
	{
		Book updatedBook = bookService.updateBook(id, book);
		return ResponseEntity.ok(updatedBook);
	}
	//Delete a Book
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable int id)
	{
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}
	//Purchase a Book
	@PutMapping("/purchase/{id}")
	public ResponseEntity<Book> purchaseBook(@PathVariable int id,@RequestParam int quantity)
	{
		Book purchasedBook = bookService.purchaseBook(id, quantity);
		return ResponseEntity.ok(purchasedBook);
	}
	

}
