package WineCellar.SEP4.database;

import WineCellar.SEP4.resource.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ItemRepository extends JpaRepository<Item, Integer> {
}
