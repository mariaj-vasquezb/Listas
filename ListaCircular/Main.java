package ListaCircular;

public class Main {
    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();
        lista.agregarInicio(3);
        lista.agregarFinal(5);
        lista.agregar(4, 1);
        System.out.println("Lista después de agregar 3, 5 y 4:");
        for (Integer valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();

        System.out.println("Valor en la posición 1: " + lista.obtenerValorNodo(1));

        int posicion = lista.obtenerPosicionNodo(5);
        System.out.println("Posición del nodo con valor 5: " + posicion);

        lista.eliminar(4);
        System.out.println("Lista después de eliminar el nodo con valor 4:");
        for (Integer valor : lista) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}
