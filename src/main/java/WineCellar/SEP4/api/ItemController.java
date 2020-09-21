package WineCellar.SEP4.api;

import WineCellar.SEP4.database.Database;
import WineCellar.SEP4.resource.Item;
import WineCellar.SEP4.resource.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> getAllOrders() {
        Order o= new Order();
        o.setAdress("Strada I.C.Bratianu");
        o.setInvoiceadress("Strada I.C.Bratianu");
        o.setDelivered(false);
        o.setPhone(072);
        o.setUserid(1);
        o.setTotalprice(55);
        o.setTotalitems(12);
        for (int i=0;i<12;i++){
        o.getItems().add(getAllItems().get(i));
        }
        database.addOrder(o);
        return database.getOrderItems(1);
    }

}
