
package br.fatec.ppi.modelo.teste;

import br.fatec.ppi.modelo.Aluno;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainQuerry {
   
    public static void main(String[] args) {
    EntityManagerFactory fabricaMotores =  Persistence.createEntityManagerFactory("modelo");
        
        EntityManager motor = 
                fabricaMotores.createEntityManager();
        
        EntityTransaction transacao = motor.getTransaction();
        transacao.begin();
        int op;
        do{
        Scanner in = new Scanner(System.in);
        System.out.print("\b\b Consultas ao banco\n");
        System.out.print("\b 1.Nome\n");
        System.out.print("\b 2.Letras\n");
        System.out.print("\b 3.Idade\n");
        System.out.print("\b 4.Faixa de Idade\n");
        System.out.print("\b 5.Todos \n");
        System.out.print("\b 0.Sair\n");
        System.out.print(" Opcao: ");
        op = in.nextInt();
        switch(op){
            
            case 0:
                break;
            case 1:
                 System.out.print("Digite o nome: ");
                 String nome = in.next();
                 Query pesquisa = 
                 motor.createQuery("SELECT C FROM Aluno C WHERE C.nome= '"+nome+"'");
                 List<Aluno> ListaAluno = pesquisa.getResultList();
                        for(Aluno ListN : ListaAluno){
                            System.out.print("ID: "+ ListN.getId());
                            System.out.println(" Nome : " + ListN.getNome());
                        }
                 
                System.out.println();
                break;
                
                case 2:
                    System.out.print("Digite a(s) letra(s): ");
                    String letras = in.next();
                    Query pesquisa1 = 
                   motor.createQuery("SELECT C FROM Aluno C where C.nome LIKE '%"+letras+"%'");
                   List<Aluno> ListaAluno1 = pesquisa1.getResultList();
                           for(Aluno ListN : ListaAluno1){
                               System.out.print("ID : " + ListN.getId());
                               System.out.println("  Nome : " + ListN.getNome());
                        }
                 
                System.out.print("");
                break;
                case 3:
                    System.out.print("Digite a idade: ");
                    String idade = in.next();
                    Query pesquisa2 = 
                    motor.createQuery("SELECT C FROM Aluno C WHERE C.idade= "+idade+"");
                    List<Aluno> ListaIdade = pesquisa2.getResultList();
                    for(Aluno ListI : ListaIdade){
                        System.out.print("ID: "+ListI.getId());
                        System.out.println("  Idade : " + ListI.getIdade());
                    }
                 System.out.println();
                break;
                    
                case 4:
                    System.out.print("Digite o intervalo da idade: \n inicio: ");
                    int i = in.nextInt();
                    System.out.print(" Fim: ");
                    int f = in.nextInt();
                    Query pesquisa3 = 
                    motor.createQuery("SELECT C FROM Aluno C WHERE C.idade BETWEEN "+i+" AND "+f+"");
                    
                    List<Aluno> LA1 = pesquisa3.getResultList();
                           for(Aluno List : LA1){
                                System.out.print("ID : " + List.getId());
                                System.out.println(" idade : " + List.getIdade());
                           }

                    System.out.println();
                break;
                case 5:
                    Query pesquisa4 = 
                    motor.createQuery("SELECT c FROM Aluno c");
                    List<Aluno> listaAlunos = pesquisa4.getResultList();
                    for(Aluno alunoTmp : listaAlunos){
                        System.out.print("ID: " + alunoTmp.getId());
                        System.out.print(" Nome: " + alunoTmp.getNome());
                        System.out.println(" Idade: " + alunoTmp.getIdade());
                    }
                 System.out.println();
                break;
                default:
                    System.out.print("Opcao invalida!");
               }
        
       } while(op != 0);
               
    transacao.commit();    
}

}
      


