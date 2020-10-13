package programacion.funcional;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import programacion.api.APITrello;
import static programacion.api.ApiBuilder.buildAPI;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String URL = "";  // https://api.trello.com/1/boards/:boardId/
    private static final String KEY = "";
    private static final String TOKEN = "";

    public static void main( String[] args )
    {
        System.out.println("Listas en Pizarra");
        
        Stream<ListaPizarra> streamListaPizarra = getRequestLista(authenticate(KEY, TOKEN));
        streamListaPizarra.forEach(System.out::println);

        Stream<Tarea> streamTarea = getRequestTarea(authenticate(KEY, TOKEN));
        List<Tarea> tareas = streamTarea.collect(Collectors.toList());
        System.out.println("Tareas en Pizarra");
        imprimir(tareas);
        
        System.out.println("----------------------------");
        System.out.println("Ingrese el identificador de lista para tareas Terminadas: "); 
        final String doneId;
        try (Scanner entrada = new Scanner(System.in)) {
	   doneId = entrada.next();
           Pizarra.imprimirResumen(tareas, elemento -> elemento.getIdListaPizarra().equals(doneId));    
	} catch (IllegalStateException exception) {
	     exception.printStackTrace();
	}

    }
 
     private static Stream<ListaPizarra> getRequestLista(Map<String, String> options) {
        APITrello api = buildAPI(APITrello.class, URL);

        return Stream.of(options)
                .map(api::listas)
                .flatMap(Collection::stream);
     }
     
     private static Stream<Tarea> getRequestTarea(Map<String, String> options) {
        APITrello api = buildAPI(APITrello.class, URL);

        return Stream.of(options)
                .map(api::tareas)
                .flatMap(Collection::stream);
     }
     
     private static Map<String, String> authenticate(String key, String token) {
         Map<String, String> parametros = new HashMap<>();
         parametros.put("key", key);         
         parametros.put("token", token);
         
         return parametros;
     }
     
    static <T> void imprimir(Collection<T> coleccion) {
        coleccion.forEach(System.out::println);
    }
}