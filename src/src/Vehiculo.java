// Clase base Vehiculo
public abstract class Vehiculo {
    protected String tipo;
    protected String matricula;
    protected double tarifa;

    public Vehiculo(String tipo, String matricula, double tarifa) {
        this.tipo = tipo;
        this.matricula = matricula;
        this.tarifa = tarifa;
    }

    public abstract double calcularTarifa();
}

// Subclases
class Automovil extends Vehiculo {
    public Automovil(String matricula) {
        super("Automovil", matricula, 1.50);
    }

    @Override
    public double calcularTarifa() {
        return tarifa;
    }
}

class Camion extends Vehiculo {
    public Camion(String matricula) {
        super("Camion", matricula, 3.00);
    }

    @Override
    public double calcularTarifa() {
        return tarifa;
    }
}

class  Motocicleta extends Vehiculo {
    public Motocicleta(String matricula) {
        super("Motocicleta", matricula, 1.00);
    }

    @Override
    public double calcularTarifa() {
        return tarifa;
    }
}
