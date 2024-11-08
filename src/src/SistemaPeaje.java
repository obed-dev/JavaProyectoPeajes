public class SistemaPeaje {
    private Peaje raizPeaje;

    public SistemaPeaje(Peaje raizPeaje) {
        this.raizPeaje = raizPeaje;
    }

    public void agregarPeaje(Peaje p) {
        raizPeaje.agregarSubPeaje(p);
    }

    public void generarReporte() {
        // Implementa la lógica para generar y mostrar el reporte diario
    }
}
