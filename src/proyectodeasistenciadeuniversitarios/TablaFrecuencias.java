/*
                TABLA DE FRECUENCIAS
 */
package proyectodeasistenciadeuniversitarios;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class TablaFrecuencias {
    
        public static List<Integer> Datos = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {

        //Lee un dato de la consola
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	    
            System.out.println("                           ESTADÍSTICA I");
	    System.out.println("Introduzca los valores seguido de coma (,) y para terminar pulse ENTER");
            System.out.println("");
	    //Convierte el texto en un arreglo
	    String[] datos = entrada.readLine().split(",");
	    
	    //Pasa los datos Una lista para un mejor manejo
		 for (int i = 0; i < datos.length; i++) {
			 	Datos.add(Integer.parseInt(datos[i]));
			 }
	    System.out.println("");
	    System.out.println("Los datos son: " + Datos.toString());
            System.out.println("");

	    
            //Calcular número de clases
	    Integer numerodatos = Datos.size();
	    Integer intervalos = (int) (Math.round((1+3.3)*Math.log10(numerodatos)-0.5));//log base 10
	    System.out.println("Número de Clases (1+3.3*log n) k = " + intervalos);
            
            System.out.println("--------------------------");
            
	    //Calcular el rango
	    Integer rango = Collections.max(Datos) - Collections.min(Datos);
	    System.out.println("El Rango (Xmax-Xmin) R = " + rango);
	    
	    System.out.println("--------------------------");
	        
	    //Calcular Amplitud de la clase
	    Integer amplitud = (int) (Math.round((double)rango/(double)intervalos));
	    System.out.println("Amplitud de Clase o c(Rango/número de clases) c = " + amplitud);
	    
	    System.out.println("--------------------------");
	    //Nuevo rango 
	    rango = intervalos*amplitud;
	    System.out.println("Nuevo rango (k*c si != R -- R´-R=/2) R´ = " + rango);
	    
	    
	    //La tabla de frecuencias presenta problemas...
	    System.out.println("\n=======TABLA DE FRECUENCIAS======");
	    
	    System.out.format("+--------+----+%n");//----+----+----+----+----+%n");
	    System.out.format("| Clases | f  |%n");// Ci | fi | Fi | ni | Fa |%n");
	    System.out.format("+--------+----+%n");//----+----+----+----+----+%n");

	    Integer clase_anterior = 0;//
	    Integer frAbs = 0;

	    
	    for (int i=0; clase_anterior < Collections.max(Datos); i++) {
	    	Integer nueva_clase = clase_anterior + (intervalos-1);//(intervalos-1
	    	
	    	Double Ci = ((double)(nueva_clase+clase_anterior)/2);
	    	
	    	frAbs = frecuenciaAbsoluta(clase_anterior, nueva_clase);
	    		
	    	System.out.println("| " + clase_anterior + "," + nueva_clase + " | " + frAbs + " | " + Ci);
	    	
	    	clase_anterior = nueva_clase;
		}
	    System.out.format("+--------+----+----+----+----+----+----+%n");
	} 
        private static int frecuenciaAbsoluta(Integer limInf, Integer limSup) {
	        int count = 0;
	        for (int i = 0; i < Datos.size(); i++) {
	            if (Datos.get(i) >= limInf && Datos.get(i) < limSup) {
	                count++;
	            }
	        }
	        return count;
	    }  
}
