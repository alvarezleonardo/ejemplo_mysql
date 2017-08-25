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
        Coneccion conn = new Coneccion("localhost", "root", "", "menu");
        conn.conectar();
        
        
        Consulta unaConsulta = new Consulta();
        ArrayList<Mewrua> rubros = new ArrayList<>();
        rubros = unaConsulta.recuperarTodas(conn.getCnx());
        for(Integer i = 0;i<rubros.size();i++){
            System.out.println(rubros.get(i).getNombre_mostrar());
        }    
        //System.out.println(rubros.get(3).getNombre_mostrar());
        //System.out.println(rubros.size());
        
        
        
        conn.cerrar();
    }
    
}
