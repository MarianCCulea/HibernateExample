package WineCellar.SEP4.resource;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String category;
    private float price;
    private String description;
    private String url;
    private int quantity;
    private String quantitytype;
    private int nrofitems;

    public Item(){}
    public Item( String name, String category, Float price, String description, String url,int quantity,String quantitytype,int nrofitems) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.url=url;
        this.quantity=quantity;
        this.quantitytype=quantitytype;
        this.nrofitems = nrofitems;
    }

    public Item(int id, String name, String category, Float price, String description, String url,int quantity,String quantitytype,int nrofitems) {
        this.id=id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.url=url;
        this.quantity=quantity;
        this.quantitytype=quantitytype;
        this.nrofitems = nrofitems;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
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
