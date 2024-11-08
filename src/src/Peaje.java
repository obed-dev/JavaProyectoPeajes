import java.util.ArrayList;

public class Peaje {
    public ColaVehiculos colaVehiculos = new ColaVehiculos();
    private ArrayList<Peaje> peajesHijos = new ArrayList<>();
    private Reporte reporteDiario;

    public void registrarVehiculo(Vehiculo v) {
        colaVehiculos.encolar(v);
    }

    public void procesarVehiculo() {
        if (!colaVehiculos.estaVacia()) {
            Vehiculo v = colaVehiculos.desencolar();
            double tarifa = v.calcularTarifa();
            // Aquí sumarías la tarifa al reporte
        }
    }

    public void agregarSubPeaje(Peaje p) {
        peajesHijos.add(p);
    }
}
