public class ArvoreBinaria {

    No raiz;

// implementação da arvóre binária
    ArvoreBinaria() {
        raiz = null;
    }

    public boolean vazia() {
        return raiz == null;
    }

    private No InserirNovo(No novo, No atual) {
        if (atual == null) {
            return novo;
        }
        if (atual.valor > novo.valor) {
            atual.esquerda = InserirNovo(novo, atual.esquerda);
        } else {
            atual.direita = InserirNovo(novo, atual.direita);
        }
        return atual; 
    }

    public void Inserir(No novo) {
        raiz = InserirNovo(novo, raiz);
    }

    // Pré-ordem: raiz -> esquerda -> direita
    public void preordem(No elemento) {
        if (elemento != null) {
            System.out.println(elemento.valor); // R (Raiz)
            preordem(elemento.esquerda); // E (Esquerda)
            preordem(elemento.direita); // D (Direita)
        }
    }

    // Pós-ordem: esquerda -> direita -> raiz
    public void posordem(No elemento) {
        if (elemento != null) {
            posordem(elemento.esquerda); // E (Esquerda)
            posordem(elemento.direita); // D (Direita)
            System.out.println(elemento.valor); // R (Raiz)
        }
    }

    // Em ordem: esquerda -> raiz -> direita
    public void emordem(No elemento) {
        if (elemento != null) {
            emordem(elemento.esquerda); // E (Esquerda)
            System.out.println(elemento.valor); // R (Raiz)
            emordem(elemento.direita); // D (Direita)
        }
    }

 public No encontrarElemento(No atual, int valor) {
    if (atual == null) {
       return null; // Se o nó atual for nulo, o valor não está na árvore
    }
    if (valor == atual.valor) {
          return atual; // Se o valor for encontrado, retorna o nó atual
    }

    if (valor < atual.valor) {
          return encontrarElemento(atual.esquerda, valor); // Busca na subárvore esquerda
    } else {
          return encontrarElemento(atual.direita, valor); // Busca na subárvore direita
    }
    }


public boolean remover(int valor) {
  // caso 1
  if (raiz == null) {
      return false; // Árvore vazia
   }

    No pai;
    No noX = raiz;

  // Encontrar o nó a ser removido (noX) e seu pai
    while (noX != null && noX.valor != valor) {
        pai = noX;
      if (valor < noX.valor) {
            noX = noX.esquerda;
      } else {
          noX = noX.direita;
      }
    }

    // Se noX for nulo, o valor não foi encontrado
  if (noX == null) {
        return false;
  }

  // Caso 1: Nó folha (sem filhos)
  if (noX.esquerda == null && noX.direita == null) {
    if (noX == raiz) {
            raiz = null; // A árvore tinha apenas um nó
    } else if (pai.esquerda == noX) {
            pai.esquerda = null;
    } else {
            pai.direita = null;
    }
  }
    // Caso 2: Um filho
    else if (noX.esquerda == null || noX.direita == null) {
        No filho = (noX.esquerda != null) ? noX.esquerda : noX.direita;

        if (noX == raiz) {
            raiz = filho;
        } else if (pai.esquerda == noX) {
            pai.esquerda = filho;
        } else {
            pai.direita = filho;
        }
    }
    // Caso 3: Dois filhos
    else {
        // Encontrar o nó substituto (o menor valor da subárvore direita)
        No paiSubstituto = noX;
        No substituto = noX.direita;

        // Procurar o mais à esquerda na subárvore direita
        while (substituto.esquerda != null) {
            paiSubstituto = substituto;
            substituto = substituto.esquerda;
        }

        // Substituir o valor do nó a ser removido pelo valor do substituto
        noX.valor = substituto.valor;

        // Ajustar as conexões (remoção do substituto)
      if (paiSubstituto != noX) {
          paiSubstituto.esquerda = substituto.direita;
      } else {
          paiSubstituto.direita = substituto.direita;
      }
  }

    return true;
}
  private No inserirNovo (No novo, No atual){
    if (atual == null) {
      return novo;
    }
    //Faz a orintação da procura do valor a ser inserido a esquerda
    if ( novo.valor < atual.valor ) {
      atual.esquerda = inserirNovo(novo, atual.esquerda);
    //Em caso contrário insere ao lado direiro
    }else {
      atual.direita = inserirNovo(novo, atual.direita);
    }
      return atual;
}
  public No inserir (No novo) {

    if (novo == null){
      throw new IllegalArgumentException("O nó não pode ser nulo");
    }
    //Chama o método recursivo para inserir o nó na árvore 
      raiz = inserirNovo(novo, raiz);
    
  }
  private No pesquisar (No atual, int valor) {
    if (atual == null){
      return null;
    }
    if (atual.valor == valor) {
      return atual;
    }
    if (atual.valor < valor){
     // return encontrarElemento(atual.direita, valor);
     return pesquisar(atual.direita, valor);

    }
    // busca na arvore a esquerda
     // return encontrarElemento(atual.esquerda, valor);
      return pesquisar(atual.esquerda, valor);

  }
  public No pesquisar (int valor) {
    return pesquisar (this.raiz, valor);
  }

}
