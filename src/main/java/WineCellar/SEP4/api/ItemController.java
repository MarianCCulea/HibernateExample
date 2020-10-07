package WineCellar.SEP4.api;

import WineCellar.SEP4.database.Database;
import WineCellar.SEP4.resource.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    Database database = Database.getInstance();

    @GetMapping("/items")
    @ResponseBody
    public List<Item> getAllItems() {
        return database.getAllItems();
    }

    @GetMapping("/categories")
    @ResponseBody
    public List<String> getAllCateg() {
        return database.getAllCategories();
    }
}
