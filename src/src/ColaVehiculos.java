import java.util.NoSuchElementException;

class ColaVehiculos {
    private Nodo inicio, fin;

    private class Nodo {
        Vehiculo vehiculo;
        Nodo siguiente;

        public Nodo(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
            this.siguiente = null;
        }
    }

    public void encolar(Vehiculo vehiculo) {
        Nodo nuevo = new Nodo(vehiculo);
        if (fin != null) {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        if (inicio == null) {
            inicio = fin;
        }
    }

    public Vehiculo desencolar() {
        if (inicio == null) throw new NoSuchElementException("La cola está vacía");
        Vehiculo vehiculo = inicio.vehiculo;
        inicio = inicio.siguiente;
        if (inicio == null) {
            fin = null;
        }
        return vehiculo;
    }

    public boolean estaVacia() {
        return inicio == null;
    }
}
