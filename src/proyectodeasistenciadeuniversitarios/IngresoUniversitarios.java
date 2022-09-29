/*
        PARA EL REGISTRO DEL INGRESO DEL UNIVERSITARIO.
 */
package proyectodeasistenciadeuniversitarios;

import java.util.Date;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class IngresoUniversitarios {
    private Date Fecha;
    private Date horaIngreso;
    private int codigo;
    private int minutosAtraso;

    public IngresoUniversitarios() {
    }
    
    public IngresoUniversitarios(Date Fecha, Date horaIngreso, int codigo, int minutosAtraso) {
        this.Fecha = Fecha;
        this.horaIngreso = horaIngreso;
        this.codigo = codigo;
        this.minutosAtraso = minutosAtraso;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Date getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMinutosAtraso() {
        return minutosAtraso;
    }

    public void setMinutosAtraso(int minutosAtraso) {
        this.minutosAtraso = minutosAtraso;
    }
}
