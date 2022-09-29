/*
        VECTOR DE INGRESOS, PARA REGISTRAR LOS DATOS DE INGRESO DE UNIVERSITARIOS
 */
package proyectodeasistenciadeuniversitarios;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class vectorIngreso {
    private ArrayList <Object>v=new ArrayList<Object>();
    
    vectorIngreso()
    {}
    
   public vectorIngreso(ArrayList<Object> v)
    {
        this.v=v;
    }
   
   public void agregarIngreso(IngresoUniversitarios a)
    {
        this.v.add(a);
      
    }
    
    public void modificarIngreso(int i, IngresoUniversitarios a)
    {
        this.v.set(i, a);
    }   
     
    public void eliminarIngreso(int i) 
    {
        this.v.remove(i);
    }
    
    public IngresoUniversitarios obtenerIngreso(int i)
    {
        return (IngresoUniversitarios)this.v.get(i);
    }
    
    public int cantidadIngresos()
    {
        return this.v.size();
    }
    
    public ArrayList buscarIngresos(int cod, Date fechaIni, Date fechaFin)
    {
        ArrayList <IngresoUniversitarios> va=new ArrayList<IngresoUniversitarios>();
        
        for(int i=0; i<this.v.size();i++)
           if((cod==this.obtenerIngreso(i).getCodigo()) && 
                   (this.obtenerIngreso(i).getFecha().compareTo(fechaIni)>0)
                   && (this.obtenerIngreso(i).getFecha().compareTo(fechaFin)<0))
           {    va.add(obtenerIngreso(i));
           }
        return va;
    }
}
