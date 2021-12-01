
package workfinal;



import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class conexion {
  
    Connection conn = null;
    
    //Clase para establecer conexión con mi Base De Datos.
    public conexion(){
        
        var url = "jdbc:mysql://localhost:3306/loginprog?characterEncoding=latin1&useConfigs=maxPerformance";
        try {
            //Colocando la ruta de mi Base De Datos junto a mi usuario y contraseña para poder acceder al mismo.
            conn = (Connection) DriverManager.getConnection(url, "root", "753951");
            //Mensaje para saber si la conexión fue exitosa.
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            //Mensaje para saber si la conexión no fue exitosa, y a la vez, para conocer el motivo del mismo.
            System.out.println("Error de conexión: "+e);
        }
        
    }
    //Método para ejecutar las sentencias en MYSQL.
    public int ejecutarSentenciaMYSQL(String strSentenciaMYSQL){
        
        try {
            PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(strSentenciaMYSQL);
            pstm.execute();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        
    }
    //Método para llevar a cabo consultas en MYSQL.
    public ResultSet consultarRegistros(String strSentenciaMySQL){
        try {
            PreparedStatement pstm = (PreparedStatement)conn.prepareStatement(strSentenciaMySQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}