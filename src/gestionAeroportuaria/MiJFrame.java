package gestionAeroportuaria;

import Controladores.PasajerosControladores;
import Controladores.VuelosControladores;
import Controladores.AeropuertoControladores;
import Controladores.CompaniasControladores;
import Entidades.Companias;
import Entidades.Vuelos;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MiJFrame extends JFrame {
    private final VuelosControladores vuelosControlador;
    private final AeropuertoControladores aeropuertosControlador;
    private final CompaniasControladores companiasControlador;
    private JComboBox<String> comboAeropuertos;
    private JComboBox<String> comboCompanias;
    private JComboBox<String> comboVuelos;
    private JTextArea areaFactura;
    private JTextField txtNombre;
    private JTextField txtPasaporte;
    private JTextField txtNacionalidad;
    private JButton btnSeleccionar;
    private JTabbedPane tabbedPane;

    public MiJFrame(PasajerosControladores pasajerosControlador,
                    VuelosControladores vuelosControlador,
                    AeropuertoControladores aeropuertosControlador,
                    CompaniasControladores companiasControlador) {
        this.vuelosControlador = vuelosControlador;
        this.aeropuertosControlador = aeropuertosControlador;
        this.companiasControlador = companiasControlador;
        initUI();
    }
    private void initUI() {
        setTitle("Gestin Aeroportuaria");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        tabbedPane = new JTabbedPane();
        JPanel panelSeleccion = new JPanel();
        panelSeleccion.setLayout(new GridLayout(4, 2, 10, 10));
        comboAeropuertos = new JComboBox<>();
        comboCompanias = new JComboBox<>();
        comboVuelos = new JComboBox<>();
        actualizarComboAeropuertos();
        panelSeleccion.add(new JLabel("Aeropuerto:"));
        panelSeleccion.add(comboAeropuertos);
        panelSeleccion.add(new JLabel("Compañia:"));
        panelSeleccion.add(comboCompanias);
        panelSeleccion.add(new JLabel("Vuelo:"));
        panelSeleccion.add(comboVuelos);
        btnSeleccionar = new JButton("Elije un vuelo");
        btnSeleccionar.addActionListener(e -> actualizarCompaniasYVuelos());
        panelSeleccion.add(btnSeleccionar);
        tabbedPane.addTab("AEROPUERTOS", panelSeleccion);
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(3, 2, 10, 10));
        txtNombre = new JTextField();
        txtPasaporte = new JTextField();
        txtNacionalidad = new JTextField();
        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(txtNombre);
        panelDatos.add(new JLabel("Pasaporte:"));
        panelDatos.add(txtPasaporte);
        panelDatos.add(new JLabel("Nacionalidad:"));
        panelDatos.add(txtNacionalidad);
        tabbedPane.addTab("DATOS DEL PASAJERO", panelDatos);

        JPanel panelFactura = new JPanel();
        panelFactura.setLayout(new BorderLayout());
        areaFactura = new JTextArea();
        areaFactura.setEditable(false);
        areaFactura.setLineWrap(true);
        areaFactura.setWrapStyleWord(true);
        panelFactura.add(new JScrollPane(areaFactura), BorderLayout.CENTER);
        JButton btnComprar = new JButton("Comprar Boleto");
        btnComprar.addActionListener(e -> mostrarFactura());
        panelFactura.add(btnComprar, BorderLayout.SOUTH);
        tabbedPane.addTab("INFORMACION DE BOLETO", panelFactura);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private void actualizarComboAeropuertos() {
        List<String> aeropuertos = aeropuertosControlador.obtenerAeropuertosNombres();
        comboAeropuertos.removeAllItems();
        for (String aeropuerto : aeropuertos) {
            comboAeropuertos.addItem(aeropuerto);
        }
        comboAeropuertos.addActionListener(e -> actualizarCompaniasYVuelos());
    }
    private void actualizarCompaniasYVuelos() {
        comboCompanias.removeAllItems();
        List<Companias> companias = companiasControlador.obtenerCompanias();
        for (Companias compania : companias) {
            comboCompanias.addItem(compania.getNombre());
        }
        comboVuelos.removeAllItems();
        List<Vuelos> vuelos = vuelosControlador.obtenerVuelos();
        
        for (Vuelos vuelo : vuelos) {
            String vueloInfo = String.format("%s - %s -> %s, Precio: %.2f, Max Pasajeros: %d",
                    vuelo.getIdentificador(), vuelo.getCiudadOrigen(), vuelo.getCiudadDestino(),
                    vuelo.getPrecio(), vuelo.getNumMaxPasajeros());
            comboVuelos.addItem(vueloInfo);
        }
    }
    private void mostrarFactura() {
        String vueloSeleccionado = (String) comboVuelos.getSelectedItem();
        if (vueloSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un vuelo.");
            return;
        }
        String[] vueloInfo = vueloSeleccionado.split(" - ");
        String identificador = vueloInfo[0];
        String ciudadOrigen = vueloInfo[1].split(" -> ")[0].trim();
        String ciudadDestino = vueloInfo[1].split(" -> ")[1].split(",")[0].trim();
        String nombre = txtNombre.getText();
        String pasaporte = txtPasaporte.getText();
        String nacionalidad = txtNacionalidad.getText();
        double precio = 100.0;

        String factura = String.format("""
                                       ===== Factura del boleto =====
                                       Vuelo ID: %s
                                       Ciudad Origen: %s
                                       Ciudad Destino: %s
                                       Nombre: %s
                                       Pasaporte: %s
                                       Nacionalidad: %s
                                       Precio: %.2f
                                       =======================================
                                       """,
                identificador, ciudadOrigen, ciudadDestino, nombre, pasaporte, nacionalidad, precio);
        areaFactura.setText(factura);
    }
}