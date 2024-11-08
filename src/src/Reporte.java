import java.util.Date;

public class Reporte {
    private Date fecha;
    private double ingresosTotales;
    private int numeroVehiculos;

    public String generarReporteDiario() {
        return "Fecha: " + fecha + ", Ingresos Totales: " + ingresosTotales + ", Número de Vehículos: " + numeroVehiculos;
    }

    public void guardarReporte() {
        // Lógica para almacenar el reporte en un archivo
    }
}
