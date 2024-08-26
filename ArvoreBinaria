public class ArvoreBinaria {

public boolean vazia() {
  if (raiz == null) {
    return true;
  }else {
    return false;

    }
  }

private No InserirNovo(No novo, No atual)  {
    if (atual == null) {
    return novo;
  }
    if (atual.valor > novo.valor) {
atual.esquerda = InserirNovo (novo, atual.esquerda);
  } else {
  atual.direita = InserirNovo (novo, atual.direita);
  return atual;
  }

  public void Inserir(No novo)  {
  raiz = InserirNovo(novo, raiz);
  }
  public void preordem (No elemento)  {
    if (elemento!=null)  {

  System.out.println(elemento.valor); //R
  preordem(elemento.esquerda); //E
  preordem(elemento.direita); //D

    }
  }
   public void posordem (No elemento)  {
    if (elemento!=null)  {

  System.out.println(elemento.esquerda); //
  preordem(elemento.valor); //E
  preordem(elemento.direita); //D
    }
  }
  public void emordem (No elemento)  {
    if (elemento!=null)  {

  System.out.println(elemento.direita); //D
  preordem(elemento.esquerda); //E
  preordem(elemento.valor); //R
  }
}
}
