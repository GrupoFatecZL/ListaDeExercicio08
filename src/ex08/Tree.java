package ex08;

public class Tree {
    private NO root; 

    public Tree() { 
        root = null; 
    }

    public void inserir(int i) {
        NO novo = new NO(i); 
        novo.item = i; 
        novo.dir = null;
        novo.esq = null;
    
        if (root == null) root = novo;

        else  { 
          NO atual = root;
          NO anterior;

          while(true) {
            anterior = atual;

            if (i <= atual.item) { 
              atual = atual.esq;

              if (atual == null) {
                anterior.esq = novo;
                return;
              } 
            }  
            else { 
               atual = atual.dir;
               
               if (atual == null) {
                 anterior.dir = novo;
                 return;
               }

            } 
          } 
        } 
    }

    public boolean remover(int i) {
        if (root == null) return false; 
    
        NO atual = root;
        NO pai = root;
        boolean filho_esq = true;
    
        while (atual.item != i) { 
          pai = atual;

          if(i < atual.item ) { 
            atual = atual.esq;
            filho_esq = true; 
          }
          else { 
            atual = atual.dir; 
            filho_esq = false;
          }
          if (atual == null) return false; 
        } 

        if (atual.esq == null && atual.dir == null) {
          if (atual == root ) root = null; 
          else if (filho_esq) pai.esq = null; 
            else pai.dir = null; 
        }

        else if (atual.dir == null) {
            if (atual == root) root = atual.esq;
            else if (filho_esq) pai.esq = atual.esq; 
                else pai.dir = atual.esq; 
        }
        
        else if (atual.esq == null) {
            if (atual == root) root = atual.dir; 
            else if (filho_esq) pai.esq = atual.dir; 
                else pai.dir = atual.dir; 
        }
    
        else {
            NO sucessor = no_sucessor(atual);
          
            if (atual == root) root = sucessor; 
            else if(filho_esq) pai.esq = sucessor; 
                else pai.dir = sucessor; 
                sucessor.esq = atual.esq;                       
        }
        return true;
    }
    
    public NO no_sucessor(NO apaga) { 
        NO paidosucessor = apaga;
        NO sucessor = apaga;
        NO atual = apaga.dir;
   
        while (atual != null) { 
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.esq; 
        } 
        
        if (sucessor != apaga.dir) { 
            paidosucessor.esq = sucessor.dir; 
            sucessor.dir = apaga.dir; 
        }
        return sucessor;
    }

    public NO buscar(int chave) {

        if (root == null) 
            return null; 

        NO atual = root;  
        while (atual.item != chave) { 
          if(chave < atual.item ) atual = atual.esq; 
          
          else atual = atual.dir; 

            if (atual == null) 
                return null; 
        } 
        return atual; 
    }
    
    public void inOrder(NO atual) {
        if (atual != null) {
          inOrder(atual.esq);
          System.out.print(atual.item + " ");
          inOrder(atual.dir);
        }
    }
      
    public void preOrder(NO atual) {
        if (atual != null) {
          System.out.print(atual.item + " ");
          preOrder(atual.esq);
          preOrder(atual.dir);
        }
    }
      
    public void posOrder(NO atual) {
        if (atual != null) {
          posOrder(atual.esq);
          posOrder(atual.dir);
          System.out.print(atual.item + " ");
        }
    }  
      
    public int altura(NO atual) {
        if(atual == null || (atual.esq == null && atual.dir == null))
            return 0;
        else {
            if (altura(atual.esq) > altura(atual.dir))
                return ( 1 + altura(atual.esq) );
            else
                return ( 1 + altura(atual.dir) );
        }
    }

    public void ordens() {
        System.out.print("\n Exibindo em ordem: ");
            inOrder(root);
        System.out.print("\n Exibindo em pos-ordem: ");
            posOrder(root);
        System.out.print("\n Exibindo em pre-ordem: ");
            preOrder(root);
    }
      
    public int folhas(NO atual) {
        if(atual == null) 
            return 0;

        if(atual.esq == null && atual.dir == null) 
            return 1;

        return folhas(atual.esq) + folhas(atual.dir);
    }
      
    public int contarNos(NO atual) {
       if(atual == null)  return 0;
       else return ( 1 + contarNos(atual.esq) + contarNos(atual.dir));
    }

    public void tamanho() {
        System.out.print("\n Altura da arvore: " + altura(root));
        System.out.print("\n Quantidade de folhas: " + folhas(root));
        System.out.print("\n Quantidade de NO(s): " + contarNos(root));
    }
}