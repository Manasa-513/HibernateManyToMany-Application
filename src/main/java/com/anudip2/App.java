package com.anudip2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.anudip2.model.Cart;
import com.anudip2.model.Product;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        Session session =factory.openSession();
        try
        {
        	Product p1=new Product();
        	 p1.setProductname("laptop");
        	 Product p2=new Product();
        	 p2.setProductname("shirt");
        	 Product p3=new Product();
        	 p3.setProductname("chair");
        	 
        	 
          	Cart c1=new Cart();
       	    c1.setItems("electronics");
       	    Cart c2=new Cart();
    	    c2.setItems("cloths");
    	    Cart c3=new Cart();
       	    c3.setItems("furniture");
       	    p1.getCarts().add(c1);
 		    p2.getCarts().add(c2);
 		    p3.getCarts().add(c3);
 		    p1.getCarts().add(c1);
       	  
      	  
       	 
       	 session.beginTransaction();
       	 session.save(p1);
       	 session.save(p2);
       	 session.save(p3);
       	 session.save(c1);
       	 session.save(c2);
       	 session.save(c3);
       	 
       	 session.getTransaction().commit();
       	 
       	
        }
        catch(Exception e)
        {
       	 e.printStackTrace();
        }
        finally
        {
       	 session.close();
       	 factory.close();
        }
        
    }
}
