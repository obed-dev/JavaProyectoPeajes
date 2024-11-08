import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterGrafica extends JFrame {
    private Peaje peaje;
    private JTextField matriculaField;
    private JComboBox<String> tipoVehiculoCombo;
    private JTextArea displayArea;

    public InterGrafica() {
        setTitle("Sistema de Peaje");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        peaje = new Peaje();

        // Panel superior para ingresar datos
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(2, 2));

        panelSuperior.add(new JLabel("Matrícula:"));
        matriculaField = new JTextField();
        panelSuperior.add(matriculaField);

        panelSuperior.add(new JLabel("Tipo de Vehículo:"));
        tipoVehiculoCombo = new JComboBox<>(new String[]{"Automovil", "Camion", "Motocicleta"});
        panelSuperior.add(tipoVehiculoCombo);

        add(panelSuperior, BorderLayout.NORTH);

        // Botones para registrar y procesar vehículos
        JPanel panelBotones = new JPanel();
        JButton infoButton = new JButton("Mostrar Texto Informativo");
        JButton registrarButton = new JButton("Registrar Vehículo");
        JButton procesarButton = new JButton("Procesar Vehículo");


        panelBotones.add(registrarButton);
        panelBotones.add(procesarButton);
        panelBotones.add(infoButton);

        add(panelBotones, BorderLayout.CENTER);

        // Área de texto para mostrar resultados
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        // Acciones para los botones
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVehiculo();
            }
        });

        procesarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarVehiculo();
            }
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTextoInformativo();
            }
        });

        setVisible(true);
    }

    private void registrarVehiculo() {
        String matricula = matriculaField.getText();
        String tipoVehiculo = (String) tipoVehiculoCombo.getSelectedItem();
        Vehiculo vehiculo;

        // Crear el tipo de vehículo correspondiente
        switch (tipoVehiculo) {
            case "Automovil":
                vehiculo = new Automovil(matricula);
                break;
            case "Camion":
                vehiculo = new Camion(matricula);
                break;
            case "Motocicleta":
                vehiculo = new Motocicleta(matricula);
                break;
            default:
                displayArea.append("Tipo de vehículo no reconocido\n");
                return;
        }

        peaje.registrarVehiculo(vehiculo);
        displayArea.append("Vehículo registrado: " + tipoVehiculo + " - " + matricula + "\n");
    }

    private void procesarVehiculo() {
        if (!peaje.colaVehiculos.estaVacia()) {
            Vehiculo vehiculo = peaje.colaVehiculos.desencolar();
            double tarifa = vehiculo.calcularTarifa();
            displayArea.append("Vehículo procesado: " + vehiculo.tipo + " - " + vehiculo.matricula + " | Tarifa: $" + tarifa + "\n");
        } else {
            displayArea.append("No hay vehículos en la cola para procesar.\n");
        }
    }

    private void mostrarTextoInformativo() {
        String mensaje = """
                Inserte su matrícula según su tipo de vehículo
                Ejemplos :
                Automovil = Matricula 1.50
                Camion = Matricula 3.00
                Motocicleta = Matricula 1.00
                
                Presiona el botón de "Registrar Vehículo" luego "Procesar Vehículo".
                
                Muchas gracias por usar nuestro sistema de peaje, ¡que tengas buen viaje!
                """;

        JOptionPane.showMessageDialog(this, mensaje, "Información del Sistema de Peaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterGrafica());
    }
}
