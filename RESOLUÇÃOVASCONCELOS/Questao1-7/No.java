public class No {
 
    int valor;
    No direita;
    No esquerda;
    No atual;
    No prox;
 
 public No (int valor, No direita, No esquerda, No atual, No prox){
     this.valor = valor;
     this.direita = direita;
     this.esquerda = esquerda;
     this.atual = atual;
     this.prox = prox;
    }
}