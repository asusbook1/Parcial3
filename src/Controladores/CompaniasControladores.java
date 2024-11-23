package Controladores;
import javax.persistence.EntityManager;
import Entidades.Companias;
import ConexionMySQL.ConexionPJA;
import java.util.List;
import java.util.stream.Collectors;

public class CompaniasControladores {
    private static final EntityManager em = ConexionPJA.getEmf().createEntityManager();
    
    public List<Companias> obtenerCompanias() {
        return em.createQuery("SELECT c FROM Companias c", Companias.class).getResultList();
    }

    public List<String> obtenerCompaniasNombres() {
        List<Companias> companias = obtenerCompanias();
        return companias.stream().map(Companias::getNombre).collect(Collectors.toList());
    }
}