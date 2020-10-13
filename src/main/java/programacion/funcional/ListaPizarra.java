/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.funcional;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author eduardo
 */
public final class ListaPizarra {
    
    private final String id;
    
    @SerializedName("name")
    private final String nombre;

    public ListaPizarra(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "ListaPizarra {" +
                "id: '" + id + '\'' +     
                " nombre: '" + nombre + '\'' +
                '}';
    }
    
    
}
