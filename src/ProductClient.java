import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;
/**
  Este programa muestra como invocar a un metodo remoto
  para dos objetos que se localizan mediante el registro 
  de nombres.
*/
public class ProductClient {  
   public static void main(String[] args) {  
      System.setProperty("java.security.policy", "client.policy");
      System.setSecurityManager(new RMISecurityManager());
      String url = "rmi://localhost/";
      //String url = "//localhost:80/";
      //host:port/name
 
         long start=0;  
         long end=0;
         int a[]={1,1,1,1,1,1,1,1,1,1};
         int b[]={2,2,2,2,2,2,2,2,2,2};
         int r[]=new int[10];
    
      start=System.currentTimeMillis();
      
      try {  
           Product c1 = (Product)Naming.lookup(url + "sum");
 //        Product c2 = (Product)Naming.lookup(url + "microndas");
//****************************************************************************************************************        
 
         r=c1.sum(a,b);
         end=System.currentTimeMillis(); 
         System.out.println("\n La suma de dos array es :");
         int j;
         for(j=0;j<10;j++)
         System.out.print("\t"+r[j]);
         System.out.println("\n----------- El tiempo consumido es: "+(end-start)); 
//******************************************************************************************************************
//         System.out.println(c1.getDescription());
//         System.out.println(c2.getDescription());
         
      }
      catch(Exception e)
      {  
         e.printStackTrace();
      }
   }
}
