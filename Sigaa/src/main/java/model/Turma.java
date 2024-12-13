package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne
    private Disciplina disciplina;

    @ManyToOne
    private Periodo periodo;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }


    public Turma() {}

    public Turma(int codigo, Disciplina disciplina) {
        this.codigo = codigo;
        this.disciplina = disciplina;
    }

	public int getCodigo() {
		return codigo;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
		
	
}
