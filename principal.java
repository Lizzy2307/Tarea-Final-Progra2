package javamysql;

public class principal extends javax.swing.JFrame{
    public principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void AdminActionPerformed(java.awt.event.ActionEvent evt) {
usuario form = new usuario();
form.setVisible(true);
this.dispose();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
ListaDeContactos form= new ListaDeContactos();
form.setVisible(true);
this.dispose();
    }

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    private javax.swing.JButton Admin;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
