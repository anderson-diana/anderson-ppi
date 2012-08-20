
package br.fatec.ppi.modelo;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory fabricaMotores = 
                Persistence.createEntityManagerFactory("modelo");
        
        EntityManager motor = 
                fabricaMotores.createEntityManager();
        
        EntityTransaction transacao = motor.getTransaction();
        
        transacao.begin();       
  
        int op;
                
        Scanner in = new Scanner(System.in);
                
        do{
            System.out.print("(1)Cadastrar Aluno \n");
            System.out.print("(0)Sair \n");
            System.out.print("Opcao: ");
            
            op = in.nextInt();           
            
            switch (op){
                case 1 :
                    Aluno aluno1 = new Aluno();
                    
                    System.out.print("Id:");
                    aluno1.setId(in.nextInt());
                    System.out.print("Nome: ");
                    in.nextLine();
                    String n = in.nextLine();
                    aluno1.setNome(n);
                    System.out.print("Idade: ");
                    aluno1.setIdade(in.nextInt());
                    motor.persist(aluno1);
                    
                 break;
               case 0 :
                    break;
                default :
                    System.out.print("Opção inválido");
                       
                        }
          }while(op != 0); 
        transacao.commit();  
    }
}
