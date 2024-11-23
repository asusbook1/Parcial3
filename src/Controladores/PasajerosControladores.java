package Controladores;
import javax.persistence.EntityManager;
import Entidades.Pasajeros;
import ConexionMySQL.ConexionPJA;
import java.util.List;

public class PasajerosControladores {
    private static final EntityManager em = ConexionPJA.getEmf().createEntityManager();
    
    public List<Pasajeros> obtenerPasajeros() {
        return em.createQuery("SELECT p FROM Pasajeros p", Pasajeros.class).getResultList();
    }
}