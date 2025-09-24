package ListaCircular;

public class ListaCircular<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> ultimo;
    private int tamaño;

    public ListaCircular() {
        this.ultimo = null;
        this.tamaño = 0;
    }

    public boolean estaVacia() {
        return ultimo == null;
    }

    public void agregarInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            ultimo = nuevoNodo;
            ultimo.setSiguiente(ultimo);
        } else {
            nuevoNodo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevoNodo);
        }
        tamaño++;
    }

    public void agregarFinal(T dato) {
        agregarInicio(dato);
        ultimo = ultimo.getSiguiente();
    }

    public void agregar(T dato, int posicion) {
        if (posicion < 0 || posicion > tamaño) throw new IndexOutOfBoundsException("Índice fuera de rango");
        if (posicion == 0) {
            agregarInicio(dato);
        } else if (posicion == tamaño) {
            agregarFinal(dato);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(dato);
            Nodo<T> aux = ultimo.getSiguiente();
            for (int i = 0; i < posicion - 1; i++) aux = aux.getSiguiente();
            nuevoNodo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevoNodo);
            tamaño++;
        }
    }

    public T obtenerValorNodo(int posicion) {
        return obtenerNodo(posicion).getDato();
    }

    public Nodo<T> obtenerNodo(int posicion) {
        if (posicion < 0 || posicion >= tamaño) throw new IndexOutOfBoundsException("Índice fuera de rango");
        Nodo<T> aux = ultimo.getSiguiente();
        for (int i = 0; i < posicion; i++) aux = aux.getSiguiente();
        return aux;
    }

    public int obtenerPosicionNodo(T dato) {
        if (estaVacia()) return -1;
        Nodo<T> aux = ultimo.getSiguiente();
        int i = 0;
        do {
            if (aux.getDato().equals(dato)) return i;
            aux = aux.getSiguiente();
            i++;
        } while (aux != ultimo.getSiguiente());
        return -1;
    }

    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < tamaño;
    }
    public void eliminarPrimero() {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía");
        if (tamaño == 1) {
            ultimo = null;
        } else {
            ultimo.setSiguiente(ultimo.getSiguiente().getSiguiente());
        }
        tamaño--;
    }
    public void eliminarUltimo(){
        if (estaVacia()) throw new IllegalStateException("La lista está vacía");
        if (tamaño == 1) {
            ultimo = null;
        } else {
            Nodo<T> aux = ultimo.getSiguiente();
            while (aux.getSiguiente() != ultimo) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(ultimo.getSiguiente());
            ultimo = aux;
        }
        tamaño--;
    }
    public void eliminar(T dato) {
        if (estaVacia()) throw new IllegalStateException("La lista está vacía");
        if (ultimo.getDato().equals(dato)) {
            eliminarUltimo();
            return;
        }
        Nodo<T> aux = ultimo.getSiguiente();
        Nodo<T> prev = ultimo;
        do {
            if (aux.getDato().equals(dato)) {
                prev.setSiguiente(aux.getSiguiente());
                tamaño--;
                return;
            }
            prev = aux;
            aux = aux.getSiguiente();
        } while (aux != ultimo.getSiguiente());
    }
    public void modificarNodo(int posicion, T nuevoDato) {
        Nodo<T> nodo = obtenerNodo(posicion);
        nodo.setDato(nuevoDato);
    }
    public void ordenarLista() {
        if (tamaño <= 1) return;
        boolean swapped;
        do {
            swapped = false;
            Nodo<T> current = ultimo.getSiguiente();
            Nodo<T> next = current.getSiguiente();
            for (int i = 0; i < tamaño - 1; i++) {
                if (current.getDato().compareTo(next.getDato()) > 0) {
                    T temp = current.getDato();
                    current.setDato(next.getDato());
                    next.setDato(temp);
                    swapped = true;
                }
                current = next;
                next = next.getSiguiente();
            }
        } while (swapped);
    }   
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo<T> aux = ultimo.getSiguiente();
        do {
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        } while (aux != ultimo.getSiguiente());
        System.out.println();
    }
    public void borrarLista() {
        ultimo = null;
        tamaño = 0;
    }
    public int getTamaño() {
        return tamaño;
    }
    public int getTamanio() {
        return tamaño;
    }   
    @Override
    public java.util.Iterator<T> iterator() {           
        return new java.util.Iterator<T>() {
            private Nodo<T> actual = (ultimo != null) ? ultimo.getSiguiente() : null;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < tamaño;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new java.util.NoSuchElementException();
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                count++;
                return dato;
            }
        };
    }
    
}
