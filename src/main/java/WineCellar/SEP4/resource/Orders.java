package WineCellar.SEP4.resource;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Orders")
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false)
    private int order_id;
    @Column(name = "adress")
    private String adress;
    @Column(name = "invoiceadress")
    private String invoiceadress;
    @Column(name = "totalprice")
    private float totalprice;
    @Column(name = "totalitems")
    private int totalitems;
    @Column(name = "phone")
    private int phone;
    @Column(name = "delivered")
    private boolean delivered;
    @ManyToMany(cascade = { CascadeType.ALL })
    Set<Item> items= new HashSet<Item>();

    public Orders(){}

    public Orders(String adress, String invoiceadress, Float totalprice, int totalitems, int phone, boolean delivered) {
        this.adress = adress;
        this.invoiceadress = invoiceadress;
        this.totalprice = totalprice;
        this.totalitems = totalitems;
        this.phone = phone;
        this.delivered=delivered;
    }

    public Orders(String adress, String invoiceadress, float totalprice, int totalitems, int phone, boolean delivered, Set<Item> items) {
        this.adress = adress;
        this.invoiceadress = invoiceadress;
        this.totalprice = totalprice;
        this.totalitems = totalitems;
        this.phone = phone;
        this.delivered = delivered;
        this.items = items;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
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
