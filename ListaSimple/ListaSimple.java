import java.util.Iterator;

public class ListaSimple<T extends Comparable<T>> implements Iterable<T> {
    private int tamanio;
    private Nodo<T> primero;

    public ListaSimple() {
        this.tamanio = 0;
        this.primero = null;
    }

    public void agregarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(primero);
        primero = nuevoNodo;
        tamanio++;
    }

    public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            primero = nuevoNodo;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }
        tamanio++;
    }

    public void agregar(T dato, int posicion) {
        if (!indiceValido(posicion)) throw new IndexOutOfBoundsException("Índice inválido");
        if (posicion == 0) {
            agregarInicio(dato);
            return;
        }
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        Nodo<T> aux = primero;
        for (int i = 0; i < posicion - 1; i++) aux = aux.getSiguiente();
        nuevoNodo.setSiguiente(aux.getSiguiente());
        aux.setSiguiente(nuevoNodo);
        tamanio++;
    }

    public T obtenerValorNodo(int posicion) {
        return obtenerNodo(posicion).getDato();
    }

    public Nodo<T> obtenerNodo(int posicion) {
        if (!indiceValido(posicion)) throw new IndexOutOfBoundsException("Índice inválido");
        Nodo<T> aux = primero;
        for (int i = 0; i < posicion; i++) aux = aux.getSiguiente();
        return aux;
    }

    public int obtenerPosicionNodo(T dato) {
        Nodo<T> aux = primero;
        int i = 0;
        while (aux != null) {
            if (aux.getDato().equals(dato)) return i;
            aux = aux.getSiguiente();
            i++;
        }
        return -1;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < tamanio;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void eliminarPrimero() {
        if (!estaVacia()) {
            primero = primero.getSiguiente();
            tamanio--;
        }
    }

    public void eliminarUltimo() {
        if (estaVacia()) return;
        if (primero.getSiguiente() == null) {
            primero = null;
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente().getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(null);
        }
        tamanio--;
    }

    public void eliminar(T dato) {
        if (estaVacia()) return;
        if (primero.getDato().equals(dato)) {
            eliminarPrimero();
            return;
        }
        Nodo<T> aux = primero;
        while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(dato)) {
            aux = aux.getSiguiente();
        }
        if (aux.getSiguiente() != null) {
            aux.setSiguiente(aux.getSiguiente().getSiguiente());
            tamanio--;
        }
    }

    public void modificarNodo(int posicion, T nuevoDato) {
        Nodo<T> nodo = obtenerNodo(posicion);
        nodo.setDato(nuevoDato);
    }

    public void ordenarLista() {
        if (tamanio <= 1) return;
        for (Nodo<T> i = primero; i != null; i = i.getSiguiente()) {
            for (Nodo<T> j = i.getSiguiente(); j != null; j = j.getSiguiente()) {
                if (i.getDato().compareTo(j.getDato()) > 0) {
                    T temp = i.getDato();
                    i.setDato(j.getDato());
                    j.setDato(temp);
                }
            }
        }
    }

    public void imprimirLista() {
        Nodo<T> aux = primero;
        while (aux != null) {
            System.out.print(aux.getDato() + " -> ");
            aux = aux.getSiguiente();
        }
        System.out.println("null");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = primero;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                return dato;
            }
        };
    }

    public void borrarLista() {
        primero = null;
        tamanio = 0;
    }

    public int getTamanio() {
        return tamanio;
    }
}
