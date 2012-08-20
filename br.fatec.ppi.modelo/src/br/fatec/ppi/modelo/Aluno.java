
package br.fatec.ppi.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
    @Id
    private int id;
    private String nome;
    private int idade;
    
 
    public Aluno() {}
    
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
    
}
