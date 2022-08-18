package javamysql;

import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame{
    public static final String URL= "jdbc:mysql://localhost/isunah_prog2";
public static final String USERNAME= "root";
public static final String PASWORD= "1234";
PreparedStatement ps;
ResultSet rs;


public static Connection getConection(){
Connection con=null;

try{
    Class.forName("com.mysql.jdbc.Driver");
    con=(Connection)DriverManager.getConnection(URL, USERNAME,PASWORD);
} catch (ClassNotFoundException | SQLException e){
    System.out.println(e);
}return con;
}
    /**
     * Creates new form FrmLogin
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void ValidarAdmin(){
        int resultado=0;
        Connection con=getConection();
        try{
            String usuario=txtUsuario.getText();
            String password=String.valueOf(contraseña.getPassword());
            String sql= "SELECT * FROM usuario WHERE name='"+usuario+"'and password='"+password+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            if (rs.next()){
                resultado=1;
                if (resultado==1){
                principal form= new principal();
                form.setVisible(true);
                this.dispose();
                }
            } else {
            JOptionPane.showMessageDialog(null,"Error de inicio de sesion");}
            
        }catch (Exception e){
           JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos");
    }
    }
    
    @SuppressWarnings("unchecked")
  

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
ValidarAdmin();        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtUsuario;

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
