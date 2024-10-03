public class ArvoreBinaria {

    No raiz;

// implementação da arvóre binária
    ArvoreBinaria() {

        raiz = null;
    }

    /*remove VALORES que são PARES, ele primeiramente compara o Nó atual para ver se está vazio. Depois de realizar a verificação do Nó vazio ele percorre a arvore 
    recursivamente, sendo um galho por vez utilizando a lógica EDR: ESQUERDA, DIREITA, RAÍZ. Quando esta recursão acontece ocorre também a comparação dos valores pares e 
    seguindo para a raíz da arvore 
    */ 
    private No removerPares(No atual) {
        if (atual == null) {
            return null;
        }

        // Recursivamente percorre a árvore
        atual.esquerda = removerPares(atual.esquerda);
        atual.direita = removerPares(atual.direita);

        // Se o valor do nó atual for par, remova-o
        if (atual.valor % 2 == 0) {
            return removerNo(atual);
        }

        return atual;
    }

  /*// perguntar a professora se tem necessidade da implementaçção destes metodos uma  vez que esquerda está intanciada em outro metodo
    // o uso destes metodos é por questões de encapsulamento, mas que não faz sentido poder ter coisas no código que fazerm exclusivamente a mesma coisa
    private No getDireita() {

      if (raiz != null) {

        return raiz.getDireita();
      }

      return null;
    }
    private No getEsquerda() {
      if (raiz != null) {

        return raiz.getEsquerda();
      }

      return null;
    }*/
    //Retorna o numero de folhas 
    public int numeroNosFolha (No node)  {
        if (node == null) {

          return 0;
        }

        //Se o nó for folha retorna 1
        if (node.esquerda == null && node.direita == null) {

            return 1;
        }

        //Se não for uma folha, conta as folhas nas subárvores esquerda e direita
        return numeroNosFolha(node.esquerda) + numeroNosFolha(node.direita);
    }
   //Metodo para contar o numero de nós em uma arvore
    public int numeroDeNos ( No node) {

      if (node == null) {

        return 0;
      }

      // add 1 + subarvóres 
      return 1 + numeroDeNos(node.esquerda) + numeroDeNos(node.direita);
    }

    //Metodo para contar o numero de nós não folha em uma arvore
  public int numeroDeNosNf (No node)  { 

    if (node == null) {
      return 0;
    }
    //compara os nós a esquerda e direita se for null retorna 0;
    if (node.esquerda == null && node.direita == null) {
      return 0;
    }
    //Caso o nó tenha filhos e a arvore não esteja vazia ele retorna +1e chama recursivamente o metodo
     return 1 + numeroDeNosNf(node.esquerda) + numeroDeNosNf(node.direita);
  }
  
  public int alturaArvore (No node) {

    if (node == null) {

      return 0;
    }

    int tamanhoEsquerda = alturaArvore(node.esquerda);
    int tamanhoDireita = alturaArvore(node.direita);

    if (tamanhoEsquerda > tamanhoDireita) {

      return tamanhoEsquerda + 1;
    }

    return tamanhoDireita + 1;
  }

    public boolean vazia() {

        return raiz == null;
    }
    public void preOrdemNaoRecursiva (No raiz) {
      if(raiz == null) {
        return null;
      }
      Pilha pilha = new Pilha ();
      pilha.empilhar(new No(raiz));

        while(!pilha.vazia()){
          No node = pilha.desempilhar();
          No atual = node.atual;
          System.out.print(atual.valor + " ")
        
          if(atual.direita != null){
            pilha.desempilhar(new celula(atual.direita));
          }
          if(atual.esquerda != null)  {
            pilha.desempilhar(new celula(atual.esquerda));
          }
        }
      }

      public void posOrdemNaoRecursiva (No raiz) {

        if(raiz == null)  {
          return;

        }
        //criação das pilhas para armazenar os nós
        Pilha pilha1 = new Pilha();
        Pilha pilha2 = new Pilha();

      //Começo empilhando a raiz
      pilha1.empilhar(new No(atual));

      //A estrutura WHILE opera enquanto houver nós na pilha    
      while(pilha1 != vazia())  {

        //desempilha o nó do topo da pilha
        No node = pilha1.desempilhar();
        //armazena o nó.atual processado
        No atual = node.atual;

        pilha2.desempilhar(new No(atual));

        if(atual.esquerda != null)  {
          pilha1.empilhar(new No(atual.esquerda));
        }
        if(atual.direita != null) {
            pilha1.empilhar(new No(atual.direita));
        }
      }
      while(!pilha2.vazia())  {
        No node =pilha2.desempilhar();
        No atual = celula.atual;
        System.out.print( atual.valor + " ");
      }
    }
    //
    public void emOrdemNaoRecursiva(No raiz) {
      if( raiz == null) {
        return;
      }
      //PIlha patraarmazenar os nós 
      Pilha pilha = new Pilha();
      //atualização do No atual para raiz
      No atual = raiz;

      //WHILE funciona enquanto houver Nó e a pilha não estiver vazia 
      while(atual != null || !pilha.vazia())  {
        //WHILE vai empilhando os nós que estão a esquerda   
          while (atual != null) {
            pilha.empilha(new No(atual));
            atual = atual.esquerda;
          }
          //Vai desempilhando os nós a direita 
          No node = pilha.empilhar();
          //Se atual tiver filhos atual recebe a direita 
          atual = atual.direita;
      }
    }

    // espelhamento da arvóre
    public No espelhamento (No node) {
      if (node == null) {
        return null;

      }
        No esquerda = espelhamento (node.esquerda);
        No direita = espelhamento(node.direita);

      node.setFactor(calcularFator(node));

      if (node.getFactor() == 2) {
        No direitaa = node.direita; 
        int fatorDireita = direitaa.getFactor(); 

      //fator de balanciamento 1 ou 0
      if (fatorDireita == 1 || fatorDireita == 0) {
        node.direita = direitaa.esquerda; 
        direitaa.esquerda = node;
        node = direitaa; 

      }else if(fatorDireita == -1 ){

        No aux = node.direita.esquerda;
        node.direita.esquerda = aux.direita;
        aux.direita = node.direita;
        node.direita = aux.esquerda;
        aux.esquerda = node;
        node = aux; 

      }
  }

      if(node.getFactor() == -2)  {

        No esquerdaa = node.esquerda;
        int fatorEsquerda = esquerdaa.getFactor();
          
          if(fatorEsquerda == -1 || fatorEsquerda == 0) {
            node.esquerda = esquerdaa.direita;
            esquerdaa.direita = node;
            node = esquerdaa; 
          }else if (fatorEsquerda == 1) {
            No aux = node.esquerda.direita;
            node.esquerda.direita = aux.esquerda;
            aux.esquerda = node.esquerda;
            node.esquerda = aux.direita;
            aux.direita = node;
            node = aux;
          }
        node.setFactor(calcularFator(node));
        node.esquerda.setFactor(calcularFator(node.esquerda));
      } 

  return node;

}
private int calcularFator(No node) {
  int alturaEsquerda = (node.esquerda != null)? node.esquerda.getAltura() : 0;
  int alturaDireita = (node.direita != null)? node.direita.getAltura() : 0;
  return alturaDireita - alturaEsquerda;
}

  