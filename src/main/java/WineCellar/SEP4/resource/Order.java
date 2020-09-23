package WineCellar.SEP4.resource;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private int order_id;
    private String adress;
    private String invoiceadress;
    private float totalprice;
    private int totalitems;
    private int phone;
    private boolean delivered;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "OrderhasItems",
            joinColumns = { @JoinColumn(name = "order_id",referencedColumnName = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id", referencedColumnName="item_id") }
    )
    List<Item> items= new ArrayList<>();

    public Order(){}

    public Order(int order_id, String adress, String invoiceadress, Float totalprice, int totalitems, int phone, boolean delivered) {
        this.order_id = order_id;
        this.adress = adress;
        this.invoiceadress = invoiceadress;
        this.totalprice = totalprice;
        this.totalitems = totalitems;
        this.phone = phone;
        this.delivered=delivered;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int id) {
        this.order_id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getInvoiceadress() {
        return invoiceadress;
    }

    public void setInvoiceadress(String invoiceadress) {
        this.invoiceadress = invoiceadress;
    }

    public float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(float totalprice) {
        this.totalprice = totalprice;
    }

    public int getTotalitems() {
        return totalitems;
    }

    public void setTotalitems(int totalitems) {
        this.totalitems = totalitems;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }


}
