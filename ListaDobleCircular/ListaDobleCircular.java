package ListaDobleCircular;

public class ListaDobleCircular<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private int size;

    public ListaDobleCircular() {
        this.cabeza = null;
        this.size = 0;
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getSize() {
        return size;
    }

    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            Nodo<T> ultimo = cabeza.getAnterior();
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(ultimo);
            cabeza.setAnterior(nuevoNodo);
            ultimo.setSiguiente(nuevoNodo);
            cabeza = nuevoNodo;
        }
        size++;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            Nodo<T> ultimo = cabeza.getAnterior();
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
        }
        size++;
    }

    public void eliminarDelInicio() {
        if (!estaVacia()) {
            if (size == 1) {
                cabeza = null;
            } else {
                Nodo<T> ultimo = cabeza.getAnterior();
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);
            }
            size--;
        }
    }

    public void eliminarDelFinal() {
        if (!estaVacia()) {
            if (size == 1) {
                cabeza = null;
            } else {
                Nodo<T> ultimo = cabeza.getAnterior();
                Nodo<T> penultimo = ultimo.getAnterior();
                penultimo.setSiguiente(cabeza);
                cabeza.setAnterior(penultimo);
            }
            size--;
        }
    }

    public void agregar(T dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            agregarAlInicio(dato);
        } else if (posicion == size) {
            agregarAlFinal(dato);
        } else {
            Nodo<T> nuevoNodo = new Nodo<T>(dato);
            Nodo<T> actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }
            Nodo<T> siguiente = actual.getSiguiente();
            actual.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(actual);
            nuevoNodo.setSiguiente(siguiente);
            siguiente.setAnterior(nuevoNodo);
            size++;
        }
    }

    public void obtenerValorNodo(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        System.out.println("Valor en la posición " + posicion + ": " + actual.getDato());
    }

    public void obtenerNodo(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        System.out.println("Nodo en la posición " + posicion + ": " + actual.getDato());
    }

    public void obtenerPosicionNodo(T dato) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < size; i++) {
            if (actual.getDato().equals(dato)) {
                System.out.println("El dato " + dato + " se encuentra en la posición: " + i);
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("El dato " + dato + " no se encuentra en la lista.");
    }

    public void indiceValido(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        } else {
            System.out.println("La posición " + posicion + " es válida.");
        }
    }

    public void eliminarDadoNodo(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            eliminarDelInicio();
        } else if (posicion == size - 1) {
            eliminarDelFinal();
        } else {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            Nodo<T> anterior = actual.getAnterior();
            Nodo<T> siguiente = actual.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
            size--;
        }
    }

    public void modificarNodo(int posicion, T nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        actual.setDato(nuevoDato);
    }

    public void ordenarLista() {
        if (size <= 1) {
            return; // La lista ya está ordenada
        }
        boolean swapped;
        do {
            swapped = false;
            Nodo<T> actual = cabeza;
            for (int i = 0; i < size - 1; i++) {
                Nodo<T> siguiente = actual.getSiguiente();
                if (actual.getDato().compareTo(siguiente.getDato()) > 0) {
                    T temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    swapped = true;
                }
                actual = siguiente;
            }
        } while (swapped);
    }

    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < size; i++) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void iterator() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < size; i++) {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public void borrarLista() {
        cabeza = null;
        size = 0;
    }


}
