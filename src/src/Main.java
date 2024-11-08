public class Main {
    public static void main(String[] args) {
        // Crear el peaje raíz
        Peaje peajePrincipal = new Peaje();

        // Crear el sistema de peaje con el peaje raíz
        SistemaPeaje sistemaPeaje = new SistemaPeaje(peajePrincipal);

        // Registrar algunos vehículos en el peaje principal
        Vehiculo auto = new Automovil("ABC123");
        Vehiculo camion = new Camion("DEF456");
        Vehiculo moto = new Motocicleta("GHI789");

        peajePrincipal.registrarVehiculo(auto);
        peajePrincipal.registrarVehiculo(camion);
        peajePrincipal.registrarVehiculo(moto);

        // Procesar vehículos en el peaje principal
        peajePrincipal.procesarVehiculo();
        peajePrincipal.procesarVehiculo();
        peajePrincipal.procesarVehiculo();

        // Generar reporte (aquí puedes implementar la lógica de generación en el método generarReporte)
        sistemaPeaje.generarReporte();

        // Iniciar la interfaz gráfica
        javax.swing.SwingUtilities.invokeLater(() -> {
            new InterGrafica();
        });
    }
}
