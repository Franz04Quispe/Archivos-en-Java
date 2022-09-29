/*
        FORMULARIO DE SALIDA
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
public class FormSalidadeUniversitarios extends javax.swing.JFrame {

    File ArchivoAsistencia;
    FileWriter ArchivoAsistenciaW;
    PrintWriter pw;
    Date diaHora=new Date();
    Date horaIngreso=new Date();
    SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
    DateFormat formatoHora=new SimpleDateFormat("HH:mm:ss");
    SalidaUniversitarios regas;
    vectorSalida vs;//Cuidado con la variable
    
    public FormSalidadeUniversitarios() {
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
       vs=new vectorSalida();
       etiFechaActual.setText(formatoFecha.format(diaHora));
       etiHoraActual.setText(formatoHora.format(diaHora));
       ArchivoAsistencia=new File("Registro de Salida.txt");
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
       vs=new vectorSalida();
       etiFechaActual.setText(formatoFecha.format(diaHora));
       etiHoraActual.setText(formatoHora.format(diaHora));
       ArchivoAsistencia=new File("Registro de Salida.txt");
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
        FileReader fra=new FileReader("Registro_Universitario.txt");//ANTES archiUniversitario
        BufferedReader br=new BufferedReader(fra);
        String linea=null;
        linea=br.readLine();
     
        while(linea!=null)
            {
                    //dividimos la cadena separado por un token ,
                   StringTokenizer st=new StringTokenizer(linea,",");
                   univ=new UNIVERSITARIO();
                   int cod=Integer.parseInt(st.nextToken());
                   univ.setCodigo(cod);
                   univ.setNombre(st.nextToken());
                   univ.setApellidos(st.nextToken());//Se modifico o añadio esta parte, porque no nos devolvia el apellido
                   univ.setGenero(st.nextToken().charAt(0));
                   univ.setCargo(st.nextToken());
                   //int ed=Integer.parseInt(st.nextToken());//añadido------
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
            mensaje("Su registro de salida ha sido exitoso");
       }
       else   mensaje("EL CÓDIGO QUE HA INGRESADO NO EXISTE, SI DESEA PUEDE REGISTRARSE");
   } 
    long obtenerMinutosAtraso(Date horaActual, Date horaIngreso)
    {   long minutos=0;
        try{
            Date dia=new Date();
            DateFormat fh=new SimpleDateFormat("HH:mm");    
            horaActual=fh.parse(fh.format(dia));
            horaIngreso=fh.parse("15:00");//DESDE CODIGO SE PONE LA HORA INGRESO
            
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
        jLabel1 = new javax.swing.JLabel();
        etiFechaActual = new javax.swing.JLabel();
        etiHoraActual = new javax.swing.JLabel();
        btnvolverAregistrodesdeSalida = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoUniversitario = new javax.swing.JTextField();
        etiUniversitario = new javax.swing.JLabel();
        etiMinutosAtraso = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salida de Universitario");
        setIconImage(getIconImage());
        setPreferredSize(new java.awt.Dimension(450, 567));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 102));
        jLabel1.setText("Registro de Salida");

        etiFechaActual.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiFechaActual.setForeground(new java.awt.Color(255, 255, 255));

        etiHoraActual.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        etiHoraActual.setForeground(new java.awt.Color(255, 255, 255));

        btnvolverAregistrodesdeSalida.setText("Volver al registro");
        btnvolverAregistrodesdeSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverAregistrodesdeSalidaActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 153, 0));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 102));
        jLabel5.setText("Ingrese su codigo de registro:");

        txtCodigoUniversitario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        txtCodigoUniversitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoUniversitarioActionPerformed(evt);
            }
        });

        etiUniversitario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        etiUniversitario.setForeground(new java.awt.Color(0, 255, 255));

        etiMinutosAtraso.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        etiMinutosAtraso.setForeground(new java.awt.Color(102, 102, 255));
        etiMinutosAtraso.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setText("La fecha actual es:");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("La hora actual es:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiMinutosAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(40, 40, 40)
                        .addComponent(txtCodigoUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnvolverAregistrodesdeSalida)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnvolverAregistrodesdeSalida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(etiFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(etiHoraActual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addComponent(etiUniversitario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiMinutosAtraso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 450, 400));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesdelProyecto/f.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverAregistrodesdeSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverAregistrodesdeSalidaActionPerformed
        FormUniversitarios fun=new FormUniversitarios();//creamos una instancia fm de la clase, para hacer una referencia de otro formulario
        this.dispose();//libera la memoria y cierra el formulario actual
        fun.setVisible(true);//lo hara visible setVisible(true)
    }//GEN-LAST:event_btnvolverAregistrodesdeSalidaActionPerformed

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
            java.util.logging.Logger.getLogger(FormSalidadeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSalidadeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSalidadeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSalidadeUniversitarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSalidadeUniversitarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvolverAregistrodesdeSalida;
    private javax.swing.JLabel etiFechaActual;
    private javax.swing.JLabel etiHoraActual;
    private javax.swing.JLabel etiMinutosAtraso;
    private javax.swing.JLabel etiUniversitario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCodigoUniversitario;
    // End of variables declaration//GEN-END:variables
}
