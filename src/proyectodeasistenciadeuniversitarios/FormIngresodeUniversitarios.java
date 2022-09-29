/*
        FORMULARIO DE INGRESO
 */
package proyectodeasistenciadeuniversitarios;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 * @author Franz Quispe, Kevin Salas, Rodrigo Escobar, Omar Senzano
 */
public class FormIngresodeUniversitarios extends javax.swing.JFrame {

    File ArchivoAsistencia;
    FileWriter ArchivoAsistenciaW;
    PrintWriter pw;
    Date diaHora=new Date();
    Date horaIngreso=new Date();
    SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
    DateFormat formatoHora=new SimpleDateFormat("HH:mm:ss");
    IngresoUniversitarios regas;
    vectorIngreso vi;//Cuidado con la variable
    
    
    public FormIngresodeUniversitarios() {
        initComponents();
        this.setLocationRelativeTo(this);//IMPORTANTE, coloca el formulario al centro
        abrirArchivo();
    }
    
    public Image getIconImage()//IMPORTANTE, ES PARA CAMBIAR EL LOGO DEL PROGRAMA      o(edit).png")
    {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("ImagenesdelProyecto/icon.png"));
        return retValue;
    }
    
    
    public void mensaje(String msje)
    {
        JOptionPane.showMessageDialog(null,msje);
    }
    
    public void abrirArchivo()
    {
       vi=new vectorIngreso();
       etiFechaActual.setText(formatoFecha.format(diaHora));
       etiHoraActual.setText(formatoHora.format(diaHora));
       ArchivoAsistencia=new File("Registro de Ingreso.txt");
       if(!ArchivoAsistencia.exists())
       {
           try{
               ArchivoAsistencia.createNewFile();
               ArchivoAsistenciaW=new FileWriter(ArchivoAsistencia,true);
               pw=new PrintWriter(ArchivoAsistenciaW);
               ArchivoAsistenciaW.close();
           }catch(Exception ex)
           {
             mensaje("Error al abrir el archivo");
           }
       }else{
       try{
           ArchivoAsistenciaW=new FileWriter(ArchivoAsistencia,true);
           pw=new PrintWriter(ArchivoAsistenciaW);
           
       }catch(Exception ex)
       {
           mensaje("ERROR");
       }
       }
    }
    
   public void abrirArchivoEmpleado()
   {
       vi=new vectorIngreso();
       etiFechaActual.setText(formatoFecha.format(diaHora));
       etiHoraActual.setText(formatoHora.format(diaHora));
       ArchivoAsistencia=new File("Registro de Ingreso.txt");
       if(!ArchivoAsistencia.exists())
       {
           try{
               ArchivoAsistencia.createNewFile();
               ArchivoAsistenciaW=new FileWriter(ArchivoAsistencia,true);
               pw=new PrintWriter(ArchivoAsistenciaW);
               ArchivoAsistenciaW.close();
           }catch(Exception ex)
           {
             mensaje("Error al abrir el archivo");
           }
       }else{
       try{
           ArchivoAsistenciaW=new FileWriter(ArchivoAsistencia,true);
           pw=new PrintWriter(ArchivoAsistenciaW);
           
       }catch(Exception ex)
       {
           mensaje("ERROR");
       }
      }
    }
   
    void guardarAsistenciaEnArchivo()
   {
       String fecha,hora;
       String codigo;
       UNIVERSITARIO univ;
       vectordeUniversitarios vu=new vectordeUniversitarios();
       try{   
        FileReader fra=new FileReader("Registro_Universitario.txt");//antes archiUniversitario
        BufferedReader br=new BufferedReader(fra);
        String linea=null;
        linea=br.readLine();
     
        while(linea!=null)
            {
                    //dividimos la cadena separado por un token ,
                   StringTokenizer st=new StringTokenizer(linea,",");
                   univ=new UNIVERSITARIO();
                   int cod=Integer.parseInt(st.nextToken());
                   //int ed=Integer.parseInt(st.nextToken());//añadido------
                   univ.setCodigo(cod);
                   univ.setNombre(st.nextToken());
                   univ.setApellidos(st.nextToken());//Se modifico o añadio esta parte, porque no nos devolvia el apellido
                   univ.setGenero(st.nextToken().charAt(0));
                   univ.setCargo(st.nextToken());
                   univ.setEdad(cod);//añadido
                   
                   //agregamos el registro al vector
                   vu.agregarUniversitario(univ);
                   linea=br.readLine();
            }
        br.close();
     }catch(Exception ex)
     {
         System.out.println("ERROR al cargar el archivo "+ex.getMessage());
     }
       fecha=etiFechaActual.getText();
       hora=etiHoraActual.getText();
       codigo=txtCodigoUniversitario.getText();
       int posUniv=vu.buscarCodigoUniversitario(Integer.parseInt(codigo));
       if (posUniv!=-1)
       {  
            etiUniversitario.setText("La persona es:"+vu.obtenerUniversitario(posUniv).getNombre()+""+
                                vu.obtenerUniversitario(posUniv).getApellidos());//Se añadio esta parte, porque no nos devolvia el apellido
            pw.println(fecha+", "+hora+", "+codigo);
            pw.close();
            mensaje("Su registro de ingreso ha sido exitoso");
       }
       else   mensaje("EL CÓDIGO QUE HA INGRESADO NO EXISTE, SI DESEA PUEDE REGISTRARSE");
   }
    long obtenerMinutosAtraso(Date horaActual, Date horaIngreso)
    {   long minutos=0;
        try{
            Date dia=new Date();
            DateFormat fh=new SimpleDateFormat("HH:mm");    
            horaActual=fh.parse(fh.format(dia));
            horaIngreso=fh.parse("15:30");//DESDE CODIGO SE PONE LA HORA INGRESO
            
            long resta=horaActual.getTime()-horaIngreso.getTime();
            minutos=TimeUnit.MINUTES.convert(resta, TimeUnit.MILLISECONDS);
           if (minutos>0)
           {
             return minutos;
           }
           
        } catch (ParseException ex) {
           mensaje("*ERROR*"+ex.getMessage());
        }
        return minutos;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnvolverAregistrodesdeIngreso = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        etiFechaActual = new javax.swing.JLabel();
        etiHoraActual = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoUniversitario = new javax.swing.JTextField();
        etiUniversitario = new javax.swing.JLabel();
        etiMinutosAtraso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso de Universitario");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));

        btnvolverAregistrodesdeIngreso.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnvolverAregistrodesdeIngreso.setText("Volver al registro");
        btnvolverAregistrodesdeIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverAregistrodesdeIngresoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("Registro de Ingreso");

        etiFechaActual.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        etiFechaActual.setForeground(new java.awt.Color(204, 255, 204));

        etiHoraActual.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        etiHoraActual.setForeground(new java.awt.Color(204, 255, 204));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 204));
        jLabel5.setText("Ingrese su codigo de registro:");

        txtCodigoUniversitario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtCodigoUniversitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoUniversitarioActionPerformed(evt);
            }
        });

        etiUniversitario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        etiUniversitario.setForeground(new java.awt.Color(204, 255, 204));

        etiMinutosAtraso.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        etiMinutosAtraso.setForeground(new java.awt.Color(204, 255, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 255));
        jLabel3.setText("La fecha actual es:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 255));
        jLabel4.setText("La hora actual es:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(btnvolverAregistrodesdeIngreso))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(etiFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(etiHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(etiUniversitario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etiMinutosAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(etiFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(etiHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigoUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(etiUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiMinutosAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnvolverAregistrodesdeIngreso)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesdelProyecto/ff.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverAregistrodesdeIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverAregistrodesdeIngresoActionPerformed
        FormUniversitarios fun=new FormUniversitarios();//creamos una instancia fm de la clase, para hacer una referencia de otro formulario
        this.dispose();//libera la memoria y cierra el formulario actual
        fun.setVisible(true);//lo hara visible setVisible(true)
    }//GEN-LAST:event_btnvolverAregistrodesdeIngresoActionPerformed

    private void txtCodigoUniversitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoUniversitarioActionPerformed
       guardarAsistenciaEnArchivo();
       txtCodigoUniversitario.setText(null);
       MostrarAtraso();//llamada a esa funcion
    }//GEN-LAST:event_txtCodigoUniversitarioActionPerformed
    void MostrarAtraso ()//Funcion
    {
       long ma=obtenerMinutosAtraso(diaHora,horaIngreso);//ma es minutos atraso
       etiMinutosAtraso.setText("Su atraso es de :" + String.valueOf(ma)+ " minutos");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormIngresodeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormIngresodeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormIngresodeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormIngresodeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormIngresodeUniversitarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvolverAregistrodesdeIngreso;
    private javax.swing.JLabel etiFechaActual;
    private javax.swing.JLabel etiHoraActual;
    private javax.swing.JLabel etiMinutosAtraso;
    private javax.swing.JLabel etiUniversitario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigoUniversitario;
    // End of variables declaration//GEN-END:variables

}
