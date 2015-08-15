/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.uriel.exercicio01;
import java.util.Scanner;
/**
 *
 * @author uriel.pgoliveira
 */
public class exercicios01 {
    public static Scanner teclado = new Scanner(System.in);
    
    public static void main(String args[]){
       String nome,email,telefone,dataNasct;
       byte cod=0;
       
       
       
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
