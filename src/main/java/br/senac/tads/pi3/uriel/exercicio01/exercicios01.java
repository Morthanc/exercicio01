/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uriel.exercicio01;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author uriel.pgoliveira
 */
public class exercicios01 {
    
    
    
    public static Scanner teclado = new Scanner(System.in);
    
     String connectionUrl = "jdbc:sqlserver://localhost:1433;\" +\n"
            + "      \"databaseName=db1;user=usuarioDB;password=1234";
     
     
     public boolean conexaoDb() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            Connection conn = DriverManager.getConnection(connectionUrl);

            System.out.println("Conexão obtida com sucesso.");

            PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.info (nome, email, telefone, dataNascto)"
                    + "VALUES (?, ?, ?, ?)");
            ps.setString(1, getNome()); // atribui o valor que usuário coloca a coluna NOME
            

            int result = ps.executeUpdate();
            
            
           return true;
        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | HeadlessException e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
            
            return false;
        }
    }



    
    public static void main(String args[]){
       String nome,email,telefone,dataNasct;
       byte cod=0;
       /*
         String connectionUrl = "jdbc:sqlserver://192.168.0.1:1433;databaseName=bd1;user=usuario;password=senha";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            // Abre a conexão
            Connection conn = DriverManager.getConnection(connectionUrl);
          
            System.out.println("Conexão obtida com sucesso.");
                   
            // Exemplo de UPDATE... pode ser adaptado facilmente para um INSERT ou DELETE
            PreparedStatement ps =conn.prepareStatement(""); // Os pontos de interrogação serão substituídos pelos conteúdos....
            ps.setString(1, txtData.getText()); // desta caixa de texto
            ps.setString(2, txtCodigo.getText()); // e esta caixa nesta ordem.
            int result=ps.executeUpdate();
            }
            
        
        catch (SQLException ex) {
            // Se ocorrem erros de conexão
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception e) {
            // se ocorrerem outros erros
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
        }*/
       
       do {
           
           System.out.println("Deseja realizar o cadastro?\n"
                   + "Digite 1 para sim\n"
                   + "Digite 2 para sair\n");
           cod = teclado.nextByte();
           
           
           
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
            
       } while(cod!=2);
                
        
    }
}
