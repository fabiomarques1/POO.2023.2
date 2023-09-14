
package principal;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {


    public static void main(String[] args) {
        
        String nome, mensagem = "";
        int idade;
        
        nome = JOptionPane.showInputDialog("Digite o nome: ");
        String resposta = JOptionPane.showInputDialog("Digite a idade ");
        idade = Integer.parseInt(resposta);
        resposta = JOptionPane.showInputDialog("Digite a situação: (ativa/inativa) ");

        if (!resposta.equalsIgnoreCase("ativa")) {
            mensagem = "Usuário inativo no sistema!";
        } else if (idade < 18) {
            mensagem = "Pessoa menor idade! Precisa de um responsável.";
        } else {
           mensagem = "Pessoa maior de idade!";
        }

        JOptionPane.showMessageDialog(null,
                "Nome: " + nome + "\nIdade: " + idade + "\n" + mensagem);
    }
    
}
