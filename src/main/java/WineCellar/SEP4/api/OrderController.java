package WineCellar.SEP4.api;


import WineCellar.SEP4.database.Database;
import WineCellar.SEP4.resource.Orders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    Database database=Database.getInstance();

    @GetMapping("/order")
    @ResponseBody
    public List<Orders> getAllOrders() {
        return database.getAllOrders();
    }

    @PostMapping("/order")
    @ResponseBody
    public String addOrder(@RequestBody Orders orders) {
        return database.addOrder(orders);
    }

    @PutMapping("/order")
    @ResponseBody
    public String updateOrder(@RequestBody Orders orders) {
        return database.updateOrder(orders);
    }

    @DeleteMapping("/order")
    @ResponseBody
    public String deleteOrder(@RequestBody Orders orders) {
        return database.deleteOrder(orders);
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public Orders getOrderById(@PathVariable int id) {
        /*
        folosit pt JSON
        Order or=new Order("Adress","invoice",(float)20,2,232,false);
        Set<Item> items =new HashSet<>(database.getAllItems());
        or.setItems(items);
        return or;
        */

       return database.getOrderById(id);
    }


}
