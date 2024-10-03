public class Pilha  {
    Celula topo;

    public Pilha () {
        this.topo = null;
    }
    public boolean vazia () {
        return topo == null;
    }
    public void empilhar( Celula elemento)  {
        elemento.prox = topo;
        topo = elemento;

    }
    public Celula desempilhar()  {
        if (vazia())  {
            System.out.println("Não há elemnetos na pilha");
            return null;
        } else {
            Celula aux = topo;
            topo = topo.prox;
            aux.prox = null;
            return aux;
        }
    }
    public void esvaziar()  {
        topo = null; // garbage collection 
    }
}