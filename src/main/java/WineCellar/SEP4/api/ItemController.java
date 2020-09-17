package WineCellar.SEP4.api;

import WineCellar.SEP4.database.ItemService;
import WineCellar.SEP4.database.Database;
import WineCellar.SEP4.resource.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
    Database database=Database.getInstance();

    @Autowired
    private ItemService service;

    @GetMapping("/items")
    @ResponseBody
    public List<Item> getAllItems() {
            return database.getAllItems();
    }

    @GetMapping("/itemz")
    @ResponseBody
    public String getIt() {
        service.addItem(new Item("Firstname","pill",(float)21,"asd","urll.com",12,"mg",21));
        return "tests";
    }

    @GetMapping("/itemz2")
    @ResponseBody
    public List<Item> getItems() {
        return service.getAllItems();
    }
}
