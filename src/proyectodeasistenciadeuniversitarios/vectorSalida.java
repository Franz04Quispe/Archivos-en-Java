/*
        VECTOR DE SALIDA, PARA REGISTRAR LOS DATOS DE SALIDA DE UNIVERSITARIOS
 */
package proyectodeasistenciadeuniversitarios;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class vectorSalida {
    private ArrayList <Object>v=new ArrayList<Object>();
    
    vectorSalida()
    {}
    
   public vectorSalida(ArrayList<Object> v)
    {
        this.v=v;
    }
   
   public void agregarSalida(SalidaUniversitarios a)
    {
        this.v.add(a);
      
    }
    
    public void modificarSalida(int i, SalidaUniversitarios a)
    {
        this.v.set(i, a);
    }   
     
    public void eliminarSalida(int i) //PUEDE QUE NO SEA NECESARIO
    {
        this.v.remove(i);
    }
    
    public SalidaUniversitarios obtenerSalida(int i)
    {
        return (SalidaUniversitarios)this.v.get(i);
    }
    
    public int cantidadSalidaS()
    {
        return this.v.size();
    }
    
    public ArrayList buscarSalidas(int cod, Date fechaIni, Date fechaFin)
    {
        ArrayList <SalidaUniversitarios> va=new ArrayList<SalidaUniversitarios>();
        
        for(int i=0; i<this.v.size();i++)
           if((cod==this.obtenerSalida(i).getCodigo()) && 
                   (this.obtenerSalida(i).getFecha().compareTo(fechaIni)>0)
                   && (this.obtenerSalida(i).getFecha().compareTo(fechaFin)<0))
           {    va.add(obtenerSalida(i));
           }
        return va;
    }
}    
