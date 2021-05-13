	package com.ifrn.ocorrenciasJoseRicardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasJoseRicardo.model.Aluno;
import com.ifrn.ocorrenciasJoseRicardo.model.Turma;

@Repository
public class TurmaRepository {

	private List<Turma> turmas;

	public TurmaRepository() {

		turmas = new ArrayList<Turma>();

		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos.add(new Aluno("333333", "Lucas Vidal", 2017, "9889-9889", "lucas@gmail.com", null));
		alunos.add(new Aluno("000000", "Amanda Oleiveira", 2000, "9999-5555", "amanda@gmail.com", null));
		alunos.add(new Aluno("111111", "Larissa Santos", 1995, "9889-9889", "lara@gmail.com", null));

		Turma t1 = new Turma("TSI1", "TSI20201", 2020, 1);
		t1.setAlunos(alunos);
		turmas.add(t1);

		Turma t2 = new Turma("BIO2", "BIO19901", 1990, 2);
		t2.setAlunos(new ArrayList<Aluno>());
		turmas.add(t2);

		Turma t3 = new Turma("INF3", "INF20203", 2020, 3);
		t3.setAlunos(new ArrayList<Aluno>());
		turmas.add(t3);

	}

	public List<Turma> getAllTurmas() {

		return this.turmas;
	}

	public void save(Turma turma) {
		turma.setAlunos(new ArrayList<Aluno>());
		turmas.add(turma);
	}

	public Turma getTurmaByCodigo(String codigo) {

		Turma turmaBuscada = null;

		for (Turma turma : turmas) {
			if (turma.getCodigo().equals(codigo)) {
				turmaBuscada = turma;
			}
		}
		return turmaBuscada;
	}

	public void remove(Turma turma) {
		this.turmas.remove(turma);
		
	}

	public void update(Turma turma) {
		Turma turmaNova = getTurmaByCodigo(turma.getCodigo());
		
		turmaNova.setCodigo(turma.getCodigo());
		turmaNova.setNome(turma.getNome());
		turmaNova.setAno(turma.getAno());
		turmaNova.setPeriodo(turma.getPeriodo());
		
	}
	
//************* métodos da API
	
	public List<Turma> getTurmasApi(){
		
		List<Turma> turmaAPI = this.turmas;
		for (int i=0; i<turmas.size(); i++) {
			turmaAPI.get(i).setAlunos(null);
		}
		return turmaAPI;
	}
}
