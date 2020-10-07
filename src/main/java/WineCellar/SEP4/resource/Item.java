package WineCellar.SEP4.resource;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", unique = true, nullable = false)
    private int item_id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private float price;
    @Column(name = "description")
    private String description;
    @Column(name = "url")
    private String url;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "quantitytype")
    private String quantitytype;
    @Column(name = "nrofitems")
    private int nrofitems;

    @ManyToMany(mappedBy = "items")
    private Set<Orders> orders = new HashSet<Orders>();

    public Item() {
    }

    public Item(String name, String category, Float price, String description, String url, int quantity, String quantitytype, int nrofitems) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.url = url;
        this.quantity = quantity;
        this.quantitytype = quantitytype;
        this.nrofitems = nrofitems;
    }

    public Item(int item_id, String name, String category, Float price, String description, String url, int quantity, String quantitytype, int nrofitems) {
        this.item_id = item_id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.url = url;
        this.quantity = quantity;
        this.quantitytype = quantitytype;
        this.nrofitems = nrofitems;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int id) {
        this.item_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuantitytype() {
        return quantitytype;
    }

    public void setQuantitytype(String quantitytype) {
        this.quantitytype = quantitytype;
    }

    public int getNrofitems() {
        return nrofitems;
    }

    public void setNrofitems(int nrofitems) {
        this.nrofitems = nrofitems;
    }
}
