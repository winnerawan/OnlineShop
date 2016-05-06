/*
 * Project Tugas Akhir STT DHARMA ISWARA Madiun
 * ONLINE SHOP INDUSTRI KULIT MAGETAN
 * Ditulis untuk mendapatkan gelar S.Kom
 */
package net.winnerawan.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author winnerawan
 */
@ManagedBean
@SessionScoped
public class CartHandlerMB {

    List<CartBind> cartBindList = new ArrayList<CartBind>();
    int productid;
    String productname;
    int quantity;
    double price;
    double total;
    int cartsize;
    String item="item";
    Map <Integer, CartBind> map = new HashMap<Integer, CartBind>();

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCartsize() {
        return cartsize;
    }

    public void setCartsize(int cartsize) {
        this.cartsize = cartsize;
    }
    
    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public Map<Integer, CartBind> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartBind> map) {
        this.map = map;
    }

    public List<CartBind> getCartBindList() {
        return cartBindList;
    }

    public void setCartBindList(List<CartBind> cartBindList) {
        this.cartBindList = cartBindList;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public String processCart(int qty) {
        
        CartBind cb = new CartBind();
        quantity = qty;
        cb.setProductname(productname);
            System.out.println("log..........."+quantity);
        cb.setQuantity(quantity);
        cb.setPrice(price);
        cb.setTotal(quantity*price);
        cartBindList.add(cb);
        map.put(productid, cb);
        cartsize = cartBindList.size();
            for (CartBind bind: cartBindList) {
                //if(bin.get)
            }
        if (cartsize>1) {
            item="items";
        }
        return null;
    }
}
