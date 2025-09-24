package ListaDoble;

public class ListaDoble<T extends Comparable<T>> {  // Asegurarse de que T extienda Comparable<T>
    
    private Nodo<T> cabeza;
    private int size;

    public ListaDoble() {
        this.cabeza = null;
        this.size = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getSize() {
        return size;
    }

    public void agregarAlInicio(T dato) {  // Cambiar Object por T
        Nodo<T> nuevoNodo = new Nodo<T>(dato);  // Especificar el tipo genérico
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }
        size++;
    }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>(dato);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        size++;
    }

    public void eliminarPrimero(){
        if (!estaVacia()) {
            cabeza = cabeza.getSiguiente();
            size--;
        }
    }

    public void eliminarUltimo(){
        if (!estaVacia()) {
            if (cabeza.getSiguiente() == null) {
                cabeza = null;
            } else {
                Nodo<T> actual = cabeza;
                while (actual.getSiguiente().getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(null);
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
            nuevoNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
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
        System.out.println(actual.getDato());
    }

    public void obtenerNodo(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        System.out.println(actual);
    }

    public void obtenerPosicionNodo(T dato) {
        Nodo<T> actual = cabeza;
        int posicion = 0;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                System.out.println("El nodo con el dato " + dato + " está en la posición: " + posicion);
                return;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        System.out.println("El dato " + dato + " no se encuentra en la lista.");
    }

    public void indiceValido(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        } else {
            System.out.println("El índice " + posicion + " es válido.");
        }
    }

    public void eliminarDadoNodo(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException("Posición inválida");
        }
        if (posicion == 0) {
            eliminarPrimero();
        } else if (posicion == size - 1) {
            eliminarUltimo();
        } else {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
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
            while (actual.getSiguiente() != null) {
                Comparable<T> datoActual = (Comparable<T>) actual.getDato();
                T datoSiguiente = actual.getSiguiente().getDato();
                if (datoActual.compareTo(datoSiguiente) > 0) {
                    // Intercambiar los datos
                    T temp = actual.getDato();
                    actual.setDato(datoSiguiente);
                    actual.getSiguiente().setDato(temp);
                    swapped = true;
                }
                actual = actual.getSiguiente();
            }
        } while (swapped);
    }

    public void imprimirLista() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public void Iterator() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public void borrarLista() {
        cabeza = null;
        size = 0;
    }
}
