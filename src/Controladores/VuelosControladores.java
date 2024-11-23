package Controladores;
import javax.persistence.EntityManager;
import Entidades.Vuelos;
import ConexionMySQL.ConexionPJA;
import java.util.List;
import java.util.stream.Collectors;

public class VuelosControladores {
    private static final EntityManager em = ConexionPJA.getEmf().createEntityManager();
    
    public List<Vuelos> obtenerVuelos() {
        return em.createQuery("SELECT v FROM Vuelos v", Vuelos.class).getResultList();
    }

    public List<String> obtenerVuelosIdentificadores() {
        List<Vuelos> vuelos = obtenerVuelos();
        return vuelos.stream().map(Vuelos::getIdentificador).collect(Collectors.toList());
    }
}
