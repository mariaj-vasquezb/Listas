package ListaDobleCircular;

public class Main {
    public static void main(String[] args) {
        ListaDobleCircular<Integer> lista = new ListaDobleCircular<>();

        lista.agregarAlInicio(10);
        lista.agregarAlInicio(20);
        lista.agregarAlFinal(5);
        lista.agregarAlFinal(1);

        System.out.println("Tamaño de la lista: " + lista.getSize()); // Tamaño de la lista: 4

        lista.eliminarDelInicio();
        System.out.println("Tamaño de la lista después de eliminar del inicio: " + lista.getSize()); // Tamaño de la lista después de eliminar del inicio: 3

        lista.eliminarDelFinal();
        System.out.println("Tamaño de la lista después de eliminar del final: " + lista.getSize()); // Tamaño de la lista después de eliminar del final: 2
    }   
}
