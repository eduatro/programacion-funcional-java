/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.api;

import feign.QueryMap;
import feign.RequestLine;
import java.util.List;
import java.util.Map;
import programacion.funcional.ListaPizarra;
import programacion.funcional.Tarea;

/**
 *
 * @author eduardo
 */
public interface APITrello {
    
    
    @RequestLine("GET /lists")
    List<ListaPizarra> listas(@QueryMap Map<String, String> queryMap);
    
    @RequestLine("GET /cards")
    List<Tarea> tareas(@QueryMap Map<String, String> queryMap);
    
}
