import java.rmi.*;

/**
  Interfaz del objeto remoto Product 
*/
public interface Product extends Remote { 
   /**
     Recoge la descripción de un producto 
     @return la descripción del producto 
   */
   String getDescription() throws RemoteException;
   
   int[]  sum(int [] a, int[] b)  throws RemoteException;
    
}
