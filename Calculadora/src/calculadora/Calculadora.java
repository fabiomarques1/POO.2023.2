
package calculadora;

import java.util.Scanner;


public class Calculadora {


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        loop: do {
            System.out.println("Informe a operação a realizar. Digite:"
                    + "\n+ para somar"
                    + "\n- para subtrarir"
                    + "\n* para multiplicar"
                    + "\n/ para dividir"
                    + "\n. para sair");
            char operacao = s.next().charAt(0);
            System.out.println("Informe o primeiro operando: ");
            float num1 = s.nextFloat();
            System.out.println("Informe o primeiro operando: ");
            float num2 = s.nextFloat();

            float resultado;
            switch (operacao) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    resultado = num1 / num2;
                    break;
                default:
                    break loop;
            }
            
            System.out.println("Resultado: " + resultado);

        } while(true);
        
    }
}
