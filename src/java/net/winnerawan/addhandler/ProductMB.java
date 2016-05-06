/*
 * Project Tugas Akhir STT DHARMA ISWARA Madiun
 * ONLINE SHOP INDUSTRI KULIT MAGETAN
 * Ditulis untuk mendapatkan gelar S.Kom
 */
package net.winnerawan.addhandler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import net.winnerawan.dao.AddDao;
import net.winnerawan.dao.ListDao;
import net.winnerawan.entity.Product;
import net.winnerawan.entity.SubCategory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import static org.hibernate.internal.util.io.StreamCopier.BUFFER_SIZE;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author winnerawan
 */
@ManagedBean
@SessionScoped
public class ProductMB {
    
    Product product = new Product();
    SubCategory subcat =  new SubCategory();
    String subcatname;
    String catname="";
    List<SubCategory> listSubCat;
    UploadedFile file;
   

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SubCategory getSubcat() {
        return subcat;
    }

    public void setSubcat(SubCategory subcat) {
        this.subcat = subcat;
    }

    public String getSubcatname() {
        return subcatname;
    }

    public void setSubcatname(String subcatname) {
        this.subcatname = subcatname;
    }

    public List<SubCategory> getListSubCat() {
        return listSubCat;
    }

    public void setListSubCat(List<SubCategory> listSubCat) {
        this.listSubCat = listSubCat;
    }
            
     public String addProduct() {
        upload(); 
        listSubCat = new ListDao().subcatListByName(subcatname);
        //subcat.setSubCatId(listCat.get(0).getCatId());
        subcat.setSubCatId(listSubCat.get(0).getSubCatId());
        product.setSubCategory(subcat);
        product.setProName(product.getProName());
        product.setProQty(product.getProQty());
        product.setProPrice(product.getProPrice());
        product.setProUrl(product.getProUrl());
        product.setProDesc(product.getProDesc());
        boolean status = new AddDao().addProduct(product);
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
   
    public void upload() {
        if(file != null) {
            FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletcontext = (ServletContext) context.getExternalContext()
                        .getContext();
                String dbpath = servletcontext.getRealPath("/");
                String path;
                //String webcut = dbpath.substring(0, dbpath.lastIndexOf("//"));
                //String buildcut = dbpath.substring(0, dbpath.lastIndexOf("//"));
                int mainURLPath = dbpath.lastIndexOf("//");
                if (mainURLPath > -1) {
                    path = dbpath.substring(mainURLPath);
                } else {
                    path = dbpath;
                }
        try {
                String filename = FilenameUtils.getBaseName(file.getFileName());
                String ext = FilenameUtils.getExtension(file.getFileName());
                //String mainURLPath = dbpath.substring(0, dbpath.lastIndexOf("//build"));
                //InputStream inputStrim = file.getInputstream();
                path = mainURLPath + "//OnlineShop//web//resources//images//" + file.getFileName();
                InputStream is = file.getInputstream();
                Path dirpath;
                String tespath="//Users//winnerawan//"+ file.getFileName();
                dirpath=Paths.get(tespath);
                Files.copy(is, dirpath, StandardCopyOption.REPLACE_EXISTING);
                /*
                FileOutputStream fos = new FileOutputStream(path);
                
                byte[] data = new byte[BUFFER_SIZE];
                int bulk;
                InputStream inputStream = file.getInputstream();
                while (true) {
                    bulk = inputStream.read(data);
                    if (bulk < 0) {
                        break;
                    }
                    fos.write(data, 0, bulk);
                    fos.flush();
                }
                fos.close();
                inputStream.close();
                */
                //Files.copy(inputStrim, file, StandardCopyOption.REPLACE_EXISTING);
                //inputStrim.read(data);
                //FileOutputStream outputStrim = new FileOutputStream(new File(path));
                //inputStrim.close();
                //outputStrim.close();
                /*
                File destFile = new File(path);
                if(!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStrim, destFile);
                }
                */
                product.setProUrl(file.getFileName().toString());
        } catch(Exception e) {
                e.printStackTrace();
                }
        }
    }
   
     /*
     public String upload() {
        String finalName;
        String path=FacesContext.getCurrentInstance().getExternalContext().getRealPath("images");
               //path=path.indexOf("//build");
               int tmp = path.lastIndexOf("//build");
               if (tmp > -1) {
                   finalName = path.substring(tmp);
               } else {
                   finalName = path;
               }
               path=path+"//web//resources//images//";
               //writting
               try {
                   InputStream in = file.getInputstream();
                   byte data[] = new byte[in.available()];
                   in.read(data);
                   FileOutputStream out = new FileOutputStream(new File(finalName+file.getFileName()+"jpg"));
                   in.close();
                   out.close();
               } catch (Exception e) {
                   e.printStackTrace();
               }
        return "success";
     }
     */
     
    public List<SelectItem> getSubCategoryName() {
        List<SelectItem> subcatname = new ListDao().subcatList(catname);
        return subcatname;
    }
}
