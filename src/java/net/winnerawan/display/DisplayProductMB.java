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
public class DisplayProductMB {
    
    Product product = new Product();
    private Product selectedProduct;

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct() {
        this.product=product;
    }
    
    public List<Product> getAllProduct() {
        List<Product> plist = new ListDao().allProductList();
        return plist;
    }
}
