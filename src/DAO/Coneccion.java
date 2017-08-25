/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;

public class Coneccion {
   private Connection cnx = null;
   private String host, usu, clave, bd;

    public Coneccion(String host, String usu, String clave, String bd) {
        this.host = host;
        this.usu = usu;
        this.clave = clave;
        this.bd = bd;
    }
    public Connection getCnx() {
        return cnx;
    }
   public void conectar() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bd, this.usu, this.clave);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      
   }
   public void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }    
}
