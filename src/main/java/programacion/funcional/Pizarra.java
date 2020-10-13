/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion.funcional;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 *
 * @author eduardo
 */
public final class Pizarra {
    
    private Pizarra() {
        throw new IllegalStateException("Clase utilitaria");
    }
    
    // Predicate recibe un elemento de tipo T y siempre devuelve un booleano
    public static <T> void imprimirResumen(Collection<T> coleccion, Predicate<T> funcion) {
        int totalTareasTerminadas = 0;
        int totalTareas = coleccion.size();
        for (T elemento : coleccion) {
            if (funcion.test(elemento))
                totalTareasTerminadas += 1;
        }
        
        int totalTareasPendientes = biFuncionOperacion(totalTareas, totalTareasTerminadas, (x, y) -> x - y);
        int porcentajeCompletado = biFuncionOperacion(totalTareas, totalTareasTerminadas, (x, y) -> (100 * y) / x);


        System.out.println(" ---------- Resumen -----------");
        System.out.println(String.format("| Tareas:             %d        |", totalTareas));
        System.out.println(String.format("| Tareas en Progreso: %d        |", totalTareasPendientes));
        System.out.println(String.format("| Tareas Terminadas:  %d - %d%%  |", totalTareasTerminadas, porcentajeCompletado));
        System.out.println(" ------------------------------ ");
    }
    
    static int biFuncionOperacion(int valor1, int valor2, BiFunction<Integer, Integer, Integer> operacion) {
        return operacion.apply(valor1, valor2);
    }
    
}
