package Controladores;
import javax.persistence.EntityManager;
import Entidades.Aeropuertos;
import ConexionMySQL.ConexionPJA;
import java.util.List;
import java.util.stream.Collectors;

public class AeropuertoControladores {
    private static final EntityManager em = ConexionPJA.getEmf().createEntityManager();
    
   public List<Aeropuertos> obtenerAeropuertos() { return em.createQuery("SELECT a FROM Aeropuertos a", Aeropuertos.class).getResultList(); }

    public List<String> obtenerAeropuertosNombres() {
        List<Aeropuertos> aeropuertos = obtenerAeropuertos();
        return aeropuertos.stream().map(Aeropuertos::getNombre).collect(Collectors.toList());
    }
}