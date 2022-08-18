package javamysql;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListaDeContactos extends javax.swing.JFrame{
   Login con= new Login();
 Connection cn=con.getConection();
    /**
     * Creates new form FrmListaDeContactos
     */
    public ListaDeContactos() {
        initComponents();
        mostrartabla();
    }

    
    void mostrartabla(){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("alumno");
    modelo.addColumn("apellido");
    modelo.addColumn("email");
    modelo.addColumn("telefono");
    modelo.addColumn("nombre");
    tabladatos.setModel(modelo);
    
    String sql="SELECT * FROM contac_list";
    
    String datos[]= new String [5];
    Statement st;
    try{
     st=cn.createStatement();
    ResultSet rs= st.executeQuery(sql);
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    datos[3]=rs.getString(4);
    datos[4]=rs.getString(5);
    modelo.addRow(datos);
    }
    tabladatos.setModel(modelo);
}   catch (SQLException ex){
    }
    }
    
    void limpiar(){
        txtAlumno.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
        txtNombre.setText("");
        Buscar.setText(null);
    }
    
    
    @SuppressWarnings("unchecked")
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                principal form= new principal();
                form.setVisible(true);
                this.dispose();        
    }

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {
        }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
       

        int fila = tabladatos.getSelectedRow();
        String valor = tabladatos.getValueAt(fila, 0).toString();
        if (fila >= 0) {
            try {
                PreparedStatement pps = cn.prepareStatement("DELETE FROM contact_list WHERE alumno='" + valor + "'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dato Eliminado");
                mostrartabla();
            } catch (SQLException ex) {
            }
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        PreparedStatement pps;
        try {
            pps = cn.prepareStatement("UPDATE contac_list SET alumno='"+txtAlumno.getText()+"',apellido='"+txtApellido.getText()+"',email='"+txtEmail.getText()+"',telefono='"+txtTelefono.getText()+"',nombre='"+txtNombre.getText()+"' WHERE alumno='"+txtAlumno.getText()+"'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Datos Actualizados");
            limpiar();
            mostrartabla();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int fila=tabladatos.getSelectedRow();
        if (fila>=0)
        {

            txtAlumno.setText(tabladatos.getValueAt(fila, 0).toString());
            txtApellido.setText(tabladatos.getValueAt(fila, 1).toString());
            txtEmail.setText(tabladatos.getValueAt(fila, 2).toString());
            txtTelefono.setText(tabladatos.getValueAt(fila, 3).toString());
            txtNombre.setText(tabladatos.getValueAt(fila, 4).toString());
        }
        else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        limpiar();

        }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        try{
            PreparedStatement pps= cn.prepareStatement("INSERT INTO contac_list (alumno,apellido,email,telefono,nombre)VALUES(?,?,?,?,?)");
            pps.setString(1,txtAlumno.getText() );
            pps.setString(2, txtApellido.getText());
            pps.setString(3, txtEmail.getText());
            pps.setString(4, txtTelefono.getText());
            pps.setString(5, txtNombre.getText());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos guardados");
    mostrartabla();
    }
      catch (SQLException ex) {
        }
    }
    
    private void txtAlumnoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {
        }

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeContactos().setVisible(true);
            }
        });
    }


    private javax.swing.JTextField Buscar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono; 

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
