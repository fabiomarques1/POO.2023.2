
package caneta;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Principal {
    
     public static void main(String[] args) throws FileNotFoundException {
         /*Caneta caneta = new Caneta();
         
         Scanner s = new Scanner(System.in);
         
         System.out.println("Informe o modelo:");
         caneta.modelo = s.next();
         System.out.println("Informe a cor:");
         caneta.cor = s.next();
         System.out.println("Informe a ponta:");
         caneta.ponta = s.nextFloat();
         System.out.println("Informe a carga:");
         caneta.carga = s.nextInt();
         caneta.tampada = true;
         
         
         int erro = caneta.tampar();
         if (erro > 0) System.out.println("A caneta já está tampada!");
         
         erro = caneta.destampar();
         if (erro > 0) System.out.println("A caneta já está destampada!");
         
         System.out.println(caneta.Escrever());
         */
         
         new frmCaneta().setVisible(true);
         
     }
}
