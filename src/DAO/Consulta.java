/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Mewrua;

public class Consulta {
   private String tabla = "mewrua";
   public void guardar(Connection conexion, Mewrua mewrua) throws SQLException{
      try{
         PreparedStatement consulta;
         if(mewrua.getCodigo()== null){
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(codigo, nombre_mostrar, orden) VALUES(?, ?, ?)");
            consulta.setInt(1, mewrua.getCodigo());
            consulta.setString(2, mewrua.getNombre_mostrar());
            consulta.setInt(3, mewrua.getOrden());
         }else{
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET codigo = ?, nombre_mostrar = ?, orden = ? WHERE codigo = ?");
            consulta.setInt(1, mewrua.getCodigo());
            consulta.setString(2, mewrua.getNombre_mostrar());
            consulta.setInt(3, mewrua.getOrden());
         }
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public Mewrua recuperarPorId(Connection conexion, Integer codigo) throws SQLException {
      Mewrua mewrua = null;
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT codigo, nombre_mostrar, orden FROM " + this.tabla + " WHERE id_tarea = ?" );
         consulta.setInt(1, codigo);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
             
            mewrua = new Mewrua(codigo, resultado.getInt("orden"), resultado.getString("nombre_mostrar"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return mewrua;
   }
   public void eliminar(Connection conexion, Mewrua mewrua) throws SQLException{
      try{
         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE codigo = ?");
         consulta.setInt(1, mewrua.getCodigo());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
   public ArrayList<Mewrua> recuperarTodas(Connection conexion) throws SQLException{
      ArrayList<Mewrua> tareas = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT codigo, nombre_mostrar, orden FROM " + this.tabla + " ORDER BY codigo");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            tareas.add(new Mewrua(resultado.getInt("codigo"), resultado.getInt("orden"), resultado.getString("nombre_mostrar")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return tareas;
   }
}
