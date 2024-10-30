package in.pkg.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pkg.main.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>
{

}
