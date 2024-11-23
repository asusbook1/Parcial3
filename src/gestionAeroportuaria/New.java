package gestionAeroportuaria;
import Controladores.PasajerosControladores;
import Controladores.VuelosControladores;
import Controladores.AeropuertoControladores;
import Controladores.CompaniasControladores;

public class New {
    public static void main(String[] args) {
        PasajerosControladores pasajerosControlador = new PasajerosControladores();
        VuelosControladores vuelosControlador = new VuelosControladores();
        AeropuertoControladores aeropuertosControlador = new AeropuertoControladores();
        CompaniasControladores companiasControlador = new CompaniasControladores();
        MiJFrame frame = new MiJFrame(pasajerosControlador, vuelosControlador, 
                aeropuertosControlador, companiasControlador);
        frame.setVisible(true);
    }
}