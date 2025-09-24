public class Main {
    public static void main(String[] args) {
        // Crear lista de enteros
        ListaSimple<Integer> lista = new ListaSimple<>();

        System.out.println("===== PRUEBAS LISTA SIMPLE =====");

        // Agregar elementos al inicio y final
        lista.agregarInicio(30);
        lista.agregarInicio(20);
        lista.agregarFinal(40);
        lista.agregarFinal(50);
        System.out.print("Lista después de agregarInicio/agregarFinal: ");
        lista.imprimirLista();

        // Agregar en una posición específica
        lista.agregar(25, 1); // Insertar en la posición 1
        System.out.print("Lista después de agregar en posición 1: ");
        lista.imprimirLista();

        // Obtener valor y nodo
        System.out.println("Valor en posición 2: " + lista.obtenerValorNodo(2));
        System.out.println("Nodo en posición 3: " + lista.obtenerNodo(3).getDato());

        // Obtener posición de un nodo
        System.out.println("Posición del valor 40: " + lista.obtenerPosicionNodo(40));
        System.out.println("Posición del valor 99 (no existe): " + lista.obtenerPosicionNodo(99));

        // Validar índice
        System.out.println("¿Índice 2 válido? " + lista.indiceValido(2));
        System.out.println("¿Índice 10 válido? " + lista.indiceValido(10));

        // Verificar si está vacía
        System.out.println("¿Lista vacía? " + lista.estaVacia());

        // Eliminar primero
        lista.eliminarPrimero();
        System.out.print("Lista después de eliminarPrimero: ");
        lista.imprimirLista();

        // Eliminar último
        lista.eliminarUltimo();
        System.out.print("Lista después de eliminarUltimo: ");
        lista.imprimirLista();

        // Eliminar por valor
        lista.eliminar(25);
        System.out.print("Lista después de eliminar valor 25: ");
        lista.imprimirLista();

        // Modificar nodo
        lista.modificarNodo(1, 99);
        System.out.print("Lista después de modificar nodo en posición 1: ");
        lista.imprimirLista();

        // Ordenar lista
        lista.ordenarLista();
        System.out.print("Lista después de ordenarLista: ");
        lista.imprimirLista();

        // Iterador
        System.out.print("Recorrido con Iterator: ");
        for (Integer num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Borrar lista
        lista.borrarLista();
        System.out.println("Lista después de borrarLista, ¿vacía? " + lista.estaVacia());
    }
}
