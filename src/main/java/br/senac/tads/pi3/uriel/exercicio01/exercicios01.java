package br.senac.tads.pi3.uriel.exercicio01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
/**
 *
 * @author uriel.pgoliveira
 */
public class exercicios01 {
    
     private Connection obterConexao() throws SQLException, ClassNotFoundException {
    Connection conn = null;
    // Passo 1: Registrar driver JDBC.
    Class.forName("org.apache.derby.jdbc.ClientDataSource");

    // Passo 2: Abrir a conexão
    conn = DriverManager.getConnection("jdbc:derby://localhost:1527/agendabd;SecurityMechanism=3",
            "app", // usuario
            "app"); // senha
    return conn;
  }
    
    
    public static Scanner teclado = new Scanner(System.in);
    
    /* String connectionUrl = "jdbc:sqlserver://localhost:1433;\" +\n"
            + "      \"databaseName=db1;user=usuarioDB;password=1234";*/
     
     
   

    public void cadastro(){
        PreparedStatement ps = null;
        Connection conn = null;
        String nome,email,telefone,dataNasct;
        
            System.out.println("Digite seu nome: ");
            nome = teclado.nextLine();
            teclado.next();
            
            System.out.println("Digite seu email: ");
            email = teclado.nextLine();
            teclado.next();
            
            System.out.println("Digite seu telefone: ");
            telefone = teclado.nextLine();
            teclado.next();
            
            System.out.println("Digite a data de nascimento (DD/MM/AA): ");
            dataNasct = teclado.nextLine();
            teclado.next();
            
            try {
                    conn = obterConexao();
                    ps = conn.prepareStatement("INSERT INTO TB_PESSOA (NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL) VALUES (?, ?, ?, ?)");
                    ps.setString(1, nome);
                    ps.setString(2, email);
                    ps.setString(3, telefone);
                    ps.setString(4, dataNasct);
                    //stmt.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                    ps.executeUpdate();
                    System.out.println("Registro incluido com sucesso.");
            }
     catch (SQLException ex) 
    {
      Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
    } 
            catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally 
            {
                if (ps != null) {
                    try 
                    {
                        ps.close();
                    }           
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                }
      if (conn != null) 
      {
        try 
        {
          conn.close();
        } 
            catch (SQLException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
                            
        
      }     
        }
           }
    
    
    
    public void modificar(){
        PreparedStatement ps = null;
        Connection conn = null;
        String nome,email,telefone,dataNasct;
        	
        	System.out.println("Digite os dados a serem atualizados: \n");
        	
        	System.out.println("Digite o Id com dados a serem atualizados: ");
        	int id = teclado.nextInt();	
        	
            System.out.println("Digite seu nome: ");
            nome = teclado.nextLine();
            teclado.next();
            
            System.out.println("Digite seu email: ");
            email = teclado.nextLine();
            teclado.next();
            
            System.out.println("Digite seu telefone: ");
            telefone = teclado.nextLine();
            teclado.next();
            
            System.out.println("Digite a data de nascimento (DD/MM/AA): ");
            dataNasct = teclado.nextLine();
            teclado.next();
            
            try {//(NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL) VALUES (?, ?, ?, ?, ?)
                    conn = obterConexao();
                    ps = conn.prepareStatement("UPDA	ENTO = ?, VL_TELEFONE = ?, VL_EMAIL=? WHERE ID_PESSOA = ?");
                    ps.setString(1, nome);
                    ps.setString(2, email);
                    ps.setString(3, telefone);
                    ps.setString(4, dataNasct);
                    ps.setInt(5, id);	
                    ps.executeUpdate();
                    System.out.println("Registro atualizado com sucesso.");
            }
     catch (SQLException ex) 
    {
      Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
    } 
            catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally 
            {
                if (ps != null) {
                    try 
                    {
                        ps.close();
                    }           
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                }
      if (conn != null) 
      {
        try 
        {
          conn.close();
        } 
            catch (SQLException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
                            
        
      }     
        }
           }

    public void excluir(){
        PreparedStatement ps = null;
        Connection conn = null;
                	       	       	
        	System.out.println("Digite o Id com dados a ser deletado: ");
        	int id = teclado.nextInt();	
        	byte opcao;
        	
        	System.out.println("Tem certeza?\n" +
        			"Digite 1 para 'sim', 2 para 'não' e 3 para voltar");
        	opcao = teclado.nextByte();
        	
        	if (opcao==1){
        	
                      
            try {//(NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL) VALUES (?, ?, ?, ?, ?)
                    conn = obterConexao();
                    ps = conn.prepareStatement("DELETE * FROM TB_PESSOA WHERE ID_PESSOA = ?");
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    System.out.println("Registro atualizado com sucesso.\n");
            }
     catch (SQLException ex) 
    {
      Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
    } 
            catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally 
            {
                if (ps != null) {
                    try 
                    {
                        ps.close();
                    }           
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                }
      if (conn != null) 
      {
        try 
        {
          conn.close();
        } 
            catch (SQLException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
                            
        
      }     
        }
           }
        	else if (opcao==2){
            	System.out.println("");
            }
        	else {
        		System.out.println("Opção inválida");
        	}
        	
    }
    
    
    public void listagem(){
        Statement s = null;
        Connection conn = null;
        
        try {
      conn = obterConexao();
      s = conn.createStatement();
      ResultSet resultados = s.executeQuery("SELECT ID_PESSOA, NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL FROM TB_PESSOA");

      DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

      while (resultados.next()) {
        Long id = resultados.getLong("ID_PESSOA");
        String nome = resultados.getString("NM_PESSOA");
        String dataNasct = resultados.getString("DT_NASCIMENTO");
        String email = resultados.getString("VL_EMAIL");
        String telefone = resultados.getString("VL_TELEFONE");
        System.out.println(String.valueOf(id) + ", " + nome + ", " + dataNasct + ", " + email + ", " + telefone);
      }

    } catch (SQLException ex) 
    {
      Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
    } 
            catch (ClassNotFoundException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally 
            {
                if (s != null) {
                    try 
                    {
                        s.close();
                    }           
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                }
      if (conn != null) 
      {
        try 
        {
          conn.close();
        } 
            catch (SQLException ex) 
            {
                Logger.getLogger(exercicios01.class.getName()).log(Level.SEVERE, null, ex);
            }
                            
        
      }     
        }
           }
    
    
    public static void main(String args[]){
       byte cod=0;
       exercicios01 app = new exercicios01();
       /*
         String connectionUrl = "jdbc:sqlserver://192.168.0.1:1433;databaseName=bd1;user=usuario;password=senha";
*/
       
       do {
           
           System.out.println("Bem vindo ao sistema de cadastro!\n"
                   + "Digite 1 para cadastrar\n"
                   + "Digite 2 para listar\n"
                   + "Digite 3 para sair\n");
                    cod = teclado.nextByte();
        
                    if (cod==1)
                    {
                        app.cadastro();
                    }
                    
                    else if (cod==2)
                    {
                        
                    }
            
            
       } while(cod!=3);
                
        
    }
}
