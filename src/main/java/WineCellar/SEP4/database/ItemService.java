package WineCellar.SEP4.database;

import WineCellar.SEP4.resource.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
       return itemRepository.findAll();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
