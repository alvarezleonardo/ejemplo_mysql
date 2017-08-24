/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectarmysql;

import DAO.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Mewrua;
/**
 *
 * @author leona
 */
public class ConectarMysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Coneccion conn = new Coneccion();
        Consulta unaConsulta = new Consulta();
        conn.obtener();
        ArrayList<Mewrua> rubros = new ArrayList<>();
        rubros = unaConsulta.recuperarTodas(conn.getCnx());
        System.out.println(rubros.get(2).getNombre_mostrar());
        conn.cerrar();
    }
    
}
