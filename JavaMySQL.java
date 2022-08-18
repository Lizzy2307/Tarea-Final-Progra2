package javamysql;

public class JavaMySQL {
  private static MySQLManager mySql;
    public static void main(String[] args) {
        mySql = new MySQLManager();
        mySql.getConexion();
        

    }  
}
