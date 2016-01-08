import java.rmi.*;
import java.rmi.server.*;

/**
  Implementación de la interfaz de los objetos remotos Product
*/
public class ProductImpl extends UnicastRemoteObject implements Product { 
   private String name;

   /**
     implementación del constructor de un Producto
      @param n el nombre del producto 
   */
   public ProductImpl(String n) throws RemoteException {  
      name = n;
   }

   public String getDescription() throws RemoteException {  
      try {
        Thread.sleep(5000);
      }
      catch(Exception e) {
        System.out.println("En el dormir artificial");
      }
      return "Este objeto es un/a " + name + ". Comprame!";
   }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
 public int[]  sum(int[] a,int[] b) throws RemoteException
  {
     int  result[]=new int[a.length];
     int i;
     for(i=0;i<a.length;i++)
             result[i]=a[i]+b[i];
     return result;
  }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    
    
}
