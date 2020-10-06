package WineCellar.SEP4.resource;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="orders_item")
public class Orders_Item implements Serializable {

    @Id
    @Column(name = "order_id", nullable = false)
    private int order_id;
    @Id
    @Column(name = "item_id", nullable = false)
    private int item_id;

    public Orders_Item() {
    }

    public Orders_Item(int order_id, int item_id) {
        this.order_id = order_id;
        this.item_id = item_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
}
