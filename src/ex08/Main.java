package ex08;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcao = 0, i = 0;
        Tree arvore = new Tree();

        while (opcao != 9) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("*** Menu da arvore *** \n\n\n"
                +"1 - Inserir um elemento(int). \n"
                +"2 - Remover um elemento.\n"
                +"3 - Buscar um elemento.\n"
                +"4 - Verificar o tamanho da árvore. \n"
                +"5 - Listar a arvore em ordem, pré-ordem e pós-ordem. \n"
                +"9 - Finalizar o programa."));
			
            switch(opcao) {
				case 1: 
                    i = Integer.parseInt(JOptionPane.showInputDialog("Digite o número: "));
                    arvore.inserir(i);
				break;
                    
				case 2: 
                    i = Integer.parseInt(JOptionPane.showInputDialog("Digite o número: "));
                    if(!arvore.remover(i)) {
                        JOptionPane.showMessageDialog(null,"Valor nao encontrado!");
                    } else {
                        arvore.remover(i);
                    }
				break;
			
				case 3: 
                    i = Integer.parseInt(JOptionPane.showInputDialog("Digite o número: "));
                    if(arvore.buscar(i) != null) {
                        JOptionPane.showMessageDialog(null,"Valor encontrado!");
                    } else {
                        JOptionPane.showMessageDialog(null,"Valor nao encontrado!");
                    }  
				break;

                case 4: 
                    arvore.tamanho();
				break;

                case 5: 
				    arvore.ordens();
				break;

				case 9:
					JOptionPane.showMessageDialog(null,"Saindo");
				break;
				
				default: 
					JOptionPane.showMessageDialog(null,"Opção Inválida");
			}
		}
    }
}