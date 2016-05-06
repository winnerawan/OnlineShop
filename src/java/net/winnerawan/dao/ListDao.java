/*
 * Project Tugas Akhir STT DHARMA ISWARA Madiun
 * ONLINE SHOP INDUSTRI KULIT MAGETAN
 * Ditulis untuk mendapatkan gelar S.Kom
 */
package net.winnerawan.dao;

import java.util.List;
import net.winnerawan.entity.Category;
import net.winnerawan.entity.Product;
import net.winnerawan.entity.SubCategory;
import net.winnerawan.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author winnerawan
 */
public class ListDao {
    
    public List<Category> catList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al.catName FROM Category al").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List allProductList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al FROM Product al").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List subcatList(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al.subCatName FROM SubCategory al WHERE al.category.catId IN (SELECT a.catId FROM Category a WHERE lower(a.catName)='"+name.toLowerCase()+"')").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List<Category> catListByName(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList = session.createQuery("SELECT al FROM Category al WHERE lower(catName)='"+name.toLowerCase()+"'").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List<SubCategory> subcatListByName(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<SubCategory> cList = session.createQuery("SELECT al FROM SubCategory al WHERE lower(subCatName)='"+name.toLowerCase()+"'").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List<Category> catListAll() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Category> cList= session.createQuery("SELECT al FROM Category al").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List allProductListbyCatName(String catname) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Product> cList = session.createQuery("SELECT product FROM SubCategory sub_category, Category category, Product product WHERE sub_category.category.catId = category.catId AND product.subCategory.subCatId = sub_category.subCatId AND (category.catName = '"+catname+"')").list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List productbyName(String name) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        List<Product> cList = session.createQuery("SELECT p from Product p WHERE p.proName='"+name+"'").list();
        cList.toString();
        session.close();
        return cList;
    }
}
