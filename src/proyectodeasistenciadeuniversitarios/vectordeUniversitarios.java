/*
        EL VECTOR DE LOS UNIVERSITARIOS
 */
package proyectodeasistenciadeuniversitarios;
//  vuniv, es la variable que representa al vector de Universitarios
import java.util.ArrayList;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class vectordeUniversitarios {
    private ArrayList<Object> vuniv=new ArrayList<Object>();//IMPORTANTE
    
    public vectordeUniversitarios()
    {
    }
    public vectordeUniversitarios(ArrayList<Object>vu)//IMPORTANTE PARA LAS DEMAS CLASES
    {
        this.vuniv=vu;
    }
    
    public void agregarUniversitario(UNIVERSITARIO u)
    {
        this.vuniv.add(u);
    }
    
    public void modificarUniversitario(int i, UNIVERSITARIO u)
    {
        this.vuniv.set(i, u);
    }
    
    public void eliminarUniversitario(int i)
    {
        this.vuniv.remove(i);
    }
    
    public UNIVERSITARIO obtenerUniversitario(int i)
    {
        return (UNIVERSITARIO)this.vuniv.get(i);
    }
    
    public int cantidadUniversitario()
    {
        return this.vuniv.size();
    }
    
    public int buscarCodigoUniversitario(int codigo)
    {
        for(int i=0; i<vuniv.size();i++)
        {
            if(codigo==obtenerUniversitario(i).getCodigo())
            {
                return i;
            }
        }
        return -1;
    }
}
