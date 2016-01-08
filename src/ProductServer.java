import java.rmi.*;
import java.rmi.server.*;

/**
   Este programa servidor instancia dos objetos remotos,
   los registra en el servicio de nombres y espera que
   los clientes invoquen a los metodos de los objetos
   remotos.
*/
public class ProductServer {  
   public static void main(String args[]) {  
      try {  
         System.out.println("Creacion de las implementaciones en el servidor...");
//         ProductImpl p1 = new ProductImpl("Tostadora Fagor");
//         ProductImpl p2 = new ProductImpl("Microondas Wirlhpool");
           ProductImpl p1 = new ProductImpl("Metodos de matematica");

         System.out.println("Registrando los objetos remotos ...");
           Naming.rebind("sum", p1);
//         Naming.rebind("microndas", p2);

         System.out.println("Esperando por invocaciones de los clientes...");
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
      
      
      
      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
      }
      catch(Exception e) {  
         e.printStackTrace();
      }
   }
}

