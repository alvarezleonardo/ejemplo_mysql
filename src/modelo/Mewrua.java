/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author leona
 */
public class Mewrua {
    private Integer codigo, orden;
    private String nombre_mostrar;

    public Mewrua(Integer codigo, Integer orden, String nombre_mostrar) {
        this.codigo = codigo;
        this.orden = orden;
        this.nombre_mostrar = nombre_mostrar;
    }

  

    
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getNombre_mostrar() {
        return nombre_mostrar;
    }

    public void setNombre_mostrar(String nombre_mostrar) {
        this.nombre_mostrar = nombre_mostrar;
    }
    
    
    
}
