/*
 * Project Tugas Akhir STT DHARMA ISWARA Madiun
 * ONLINE SHOP INDUSTRI KULIT MAGETAN
 * Ditulis untuk mendapatkan gelar S.Kom
 */
package net.winnerawan.display;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.winnerawan.dao.ListDao;
import net.winnerawan.entity.Product;

/**
 *
 * @author winnerawan
 */
@ManagedBean
@SessionScoped
public class DisplayProduct {
    Product product = new Product();
    private String param;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
    
    public List<Product> getAllProductByCatName() {
        System.out.println("log..........."+param);
        List<Product> pList = new ListDao().allProductListbyCatName(param);
        return pList;
    }
    
    public List<Product> getProductByName() {
        System.out.println("log..........."+param);
        List<Product> pList = new ListDao().productbyName(param);
        return pList;
    }
}
