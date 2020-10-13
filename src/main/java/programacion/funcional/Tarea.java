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
public final class Tarea {
    
    private final String id;
    
    @SerializedName("idList")
    private final String idListaPizarra;
    
    @SerializedName("name")
    private final String nombre;

    public Tarea(String id, String idListaPizarra, String nombre) {
        this.id = id;
        this.idListaPizarra = idListaPizarra;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getIdListaPizarra() {
        return idListaPizarra;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return "Tarea {" +
                "id: '" + id + '\'' +
                " idListaPizarra: '" + idListaPizarra + '\'' +
                " nombre: '" + nombre + '\'' +
                '}';
    }
}
