/*
 * Project Tugas Akhir STT DHARMA ISWARA Madiun
 * ONLINE SHOP INDUSTRI KULIT MAGETAN
 * Ditulis untuk mendapatkan gelar S.Kom
 */
package net.winnerawan.addhandler;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import net.winnerawan.dao.AddDao;
import net.winnerawan.dao.ListDao;
import net.winnerawan.entity.Category;
import net.winnerawan.entity.SubCategory;

/**
 *
 * @author winnerawan
 */

@ManagedBean
@SessionScoped
public class SubCategoryMB {
    SubCategory subcat = new SubCategory();
    Category category = new Category();
    String catname;
    List<Category> listCat;

    public List<Category> getListCat() {
        return listCat;
    }

    public void setListCat(List<Category> listCat) {
        this.listCat = listCat;
    }
    
    
    public SubCategory getSubcat() {
        return subcat;
    }
    
    public void setSubcat(SubCategory subcat) {
        this.subcat=subcat;
    }
    
    public String getCatname() {
        return catname;
    }
    
    public void setCatname(String catname) {
        this.catname=catname;
    }
    
    public String addSubCategory() {
        listCat = new ListDao().catListByName(catname);
        //subcat.setSubCatId(listCat.get(0).getCatId());
        category.setCatId(listCat.get(0).getCatId());
        subcat.setCategory(category);
        subcat.setSubCatName(subcat.getSubCatName());
        subcat.setSubCatDesc(subcat.getSubCatDesc());
        boolean status = new AddDao().addSubCategory(subcat);
        if (status) {
            FacesContext.getCurrentInstance().addMessage(null, new 
        FacesMessage(FacesMessage.SEVERITY_INFO, "Data Saved", ""));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new 
        FacesMessage(FacesMessage.SEVERITY_WARN, "Data Not Saved", ""));
        }
        return null;
    }
    
    public List<Category> getCategoryName() {
        List<Category> catname = new ListDao().catList();
        return catname;
    }
    
    
}
