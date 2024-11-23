package ConexionMySQL;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionPJA  {
    private static final EntityManagerFactory emf;

    public static EntityManagerFactory getEmf() {
        return emf;
    }  
    static{
        try {
            emf = Persistence.createEntityManagerFactory("HOLAPU");
        } catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static void closeEmf()
    {
        if(emf!=null)
        {
            emf.close();
        }
    }
    private ConexionPJA() {
    }
    
}
