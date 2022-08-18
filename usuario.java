package javamysql;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class usuario extends javax.swing.JFrame {
    Login con= new Login();
 Connection cn=con.getConection();
    
    public usuario() {
        initComponents();
        mostrartabla();
    }

    void mostrartabla(){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("alumno");
    modelo.addColumn("name");
    modelo.addColumn("password");
    tabladatos.setModel(modelo);
    
    String sql="SELECT * FROM usuario";
    
    String datos[]= new String [3];
    Statement st;
    try{
     st=cn.createStatement();
    ResultSet rs= st.executeQuery(sql);
    while(rs.next()){
    datos[0]=rs.getString(1);
    datos[1]=rs.getString(2);
    datos[2]=rs.getString(3);
    modelo.addRow(datos);
    }
    tabladatos.setModel(modelo);
}   catch (SQLException ex){
    }
    }
    
    void limpiar(){
        txtAlumno.setText("");
        txtname.setText("");
        txtpassword.setText("");
        Buscar.setText(null);
    }
    
    
    @SuppressWarnings("unchecked")
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
 principal form= new principal();
                form.setVisible(true);
                this.dispose();        
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
try {
            PreparedStatement pps = cn.prepareStatement("INSERT INTO usuario(alumno, name, password) VALUES (?,?,?)");
            pps.setString(1, txtAlumno.getText());
            pps.setString(2, txtname.getText());
            pps.setString(3, txtpassword.getText());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Guardados");
            mostrartabla();

        } catch (SQLException ex) {
        }
                
    }


    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {
     limpiar();
        

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
int fila=tabladatos.getSelectedRow();
if (fila>=0)
{

    txtAlumno.setText(tabladatos.getValueAt(fila, 0).toString());
    txtname.setText(tabladatos.getValueAt(fila, 1).toString());
    txtpassword.setText(tabladatos.getValueAt(fila, 2).toString());
}
else{
JOptionPane.showMessageDialog(null, "Fila no seleccionada");
}
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
PreparedStatement pps;
     try {
         pps = cn.prepareStatement("UPDATE usuario SET name='"+txtAlumno.getText()+"',name='"+txtname.getText()+"',password='"+txtpassword.getText()+"' WHERE alumno='"+txtAlumno.getText()+"'");
     pps.executeUpdate();
JOptionPane.showMessageDialog(null,"Datos Actualizados");
limpiar();
mostrartabla();
     
     } catch (SQLException ex) {
         java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }

    }

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
   int fila = tabladatos.getSelectedRow();
        String valor = tabladatos.getValueAt(fila, 1).toString();
        if (fila >= 0) {
            try {
                PreparedStatement pps = cn.prepareStatement("DELETE FROM usuario WHERE name='" + valor + "'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dato Eliminado");
                mostrartabla();
            } catch (SQLException ex) {
 java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);             
            }
        }        
    }

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuario().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField Buscar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpassword;

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
