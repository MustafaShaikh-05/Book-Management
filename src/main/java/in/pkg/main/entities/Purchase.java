package in.pkg.main.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Purchase 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String purchaserName;
	private int quantity;
	private LocalDateTime purchaseDate;
	
	@ManyToOne
	@JoinColumn(name = "book_id" , nullable = false)
	private Book book;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Purchase(int id, String purchaserName, int quantity, LocalDateTime purchaseDate, Book book) {
		super();
		this.id = id;
		this.purchaserName = purchaserName;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.book = book;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
