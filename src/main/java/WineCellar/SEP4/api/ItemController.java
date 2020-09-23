package WineCellar.SEP4.api;

import WineCellar.SEP4.database.Database;
import WineCellar.SEP4.resource.Item;
import WineCellar.SEP4.resource.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ItemController {
    Database database=Database.getInstance();

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


    @GetMapping("/or")
    @ResponseBody
    public String addOrder() {
        database.addDummyOrder();
        return "Done";
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Order getOrderById(@PathVariable int id) {
        System.out.println("VARIABILA---"+id);
        return database.getOrder(id);
    }
}
