package ListaDoble;

public class Main {
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.agregarAlInicio(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);
        System.out.println("Tamaño de la lista: " + lista.getSize()); // Salida: 3
        lista.eliminarPrimero();
        System.out.println("Tamaño de la lista después de eliminar el primero: " + lista.getSize()); // Salida: 2
        lista.eliminarUltimo();
        System.out.println("Tamaño de la lista después de eliminar el último: " + lista.getSize()); // Salida: 1
    }
}