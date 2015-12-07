import java.rmi.*;
import java.rmi.server.*;

/**
  Este programa muestra como invocar a un método remoto
  para dos objetos que se localizan mediante el registro 
  de nombres.
*/
public class ProductClient {  
   public static void main(String[] args) {  
      System.setProperty("java.security.policy", "client.policy");
      System.setSecurityManager(new RMISecurityManager());
      String url = "rmi://localhost/";
      try {  
         Product c1 = (Product)Naming.lookup(url + "tostadora");
         Product c2 = (Product)Naming.lookup(url + "microndas");
         System.out.println(c1.getDescription());
         System.out.println(c2.getDescription());
      }
      catch(Exception e)
      {  
         e.printStackTrace();
      }
   }
}
