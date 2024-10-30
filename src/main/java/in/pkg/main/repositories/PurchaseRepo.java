package in.pkg.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.pkg.main.entities.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase,Integer>
{

}
