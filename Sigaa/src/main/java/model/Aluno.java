package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;

    private String nome;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();

   

    public Aluno() {}

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	 public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }
}
