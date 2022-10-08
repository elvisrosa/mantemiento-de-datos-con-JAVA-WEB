
package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class poolConexiones {
    
    private static BasicDataSource ds = null;
    
    public static DataSource getDataSource(){
        if(ds==null){
            ds = new BasicDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUsername("postgres");
            ds.setPassword("123456");
            ds.setUrl("jdbc:postgresql://localhost:5432/profesor");
            
            //Definimos tamaño del pool de conexiones
            ds.setInitialSize(5); //50 conexiones iniciales
            ds.setMaxIdle(20); //Conexiones inacativas
            ds.setMaxTotal(50); //conexioes activas+inactivas
            ds.setMaxWaitMillis(10000); //tiempo de espera
        }
        return ds;
        
    }
    
    public static Connection getConexion() throws SQLException{
        Connection con = null;
        try {
            con = getDataSource().getConnection();
        } catch (SQLException e) {
            System.out.println("Error al acceder a la conexion: "+e.getMessage());
        }
        
        return con;
    }
    
    
   
}
