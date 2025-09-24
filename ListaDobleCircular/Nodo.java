package ListaDobleCircular;

public class Nodo<T> {
    
    private T dato;
    private Nodo<T> anterior;
    private Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    
}
