/*
    PARA EL REGISTRO DE SALIDA DEL UNIVERSITARIO.
 */
package proyectodeasistenciadeuniversitarios;

import java.util.Date;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class SalidaUniversitarios {

    private Date Fecha;
    private Date horaSalida;
    private int codigo;
    private int minutosAtraso;

    public SalidaUniversitarios() {
    }

    public SalidaUniversitarios(Date Fecha, Date horaSalida, int codigo, int minutosAtraso) {
        this.Fecha = Fecha;
        this.horaSalida = horaSalida;
        this.codigo = codigo;
        this.minutosAtraso = minutosAtraso;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaIngreso) {
        this.horaSalida = horaIngreso;
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
