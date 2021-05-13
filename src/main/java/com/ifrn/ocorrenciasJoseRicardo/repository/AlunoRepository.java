package com.ifrn.ocorrenciasJoseRicardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasJoseRicardo.model.Aluno;
import com.ifrn.ocorrenciasJoseRicardo.model.Ocorrencia;
//import com.ifrn.ocorrenciasJoseRicardo.model.Turma;
import com.ifrn.ocorrenciasJoseRicardo.model.Turma;

@Repository
public class AlunoRepository {

	private List<Aluno> alunos;

	public AlunoRepository() {

		alunos = new ArrayList<Aluno>();

		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();

	Aluno a0 = new Aluno("333333", "Lucas Vidal", 2017, "9889-9889", "lucas@gmail.com",
				new Turma("TSI1", "TSI20201", 2020, 1), null);

		Aluno a1 = new Aluno("000000", "Amanda Oliveira", 2000, "9898-5555", "amanda@gmail.com",
			new Turma("TSI1", "TSI20201", 2020, 1), null);
		
		a1.setOcorrencias(ocorrencias);

		Aluno a2 = new Aluno("111111", "Larissa Santos", 1995, "9889-9889", "lara@gmail.com",
				new Turma("TSI1", "TSI20201", 2020, 1), null);

		a2.setOcorrencias(new ArrayList<Ocorrencia>());
		a0.setOcorrencias(new ArrayList<Ocorrencia>());

		alunos.add(a0);
		alunos.add(a1);
		alunos.add(a2);
	}

	public List<Aluno> getAllAlunos() {

		return this.alunos;
	}

	public void save(Aluno aluno) {
		aluno.setOcorrencias(new ArrayList<Ocorrencia>());
		alunos.add(aluno);

	}

	public Aluno getAlunoByMatricula(String matricula) {

		Aluno alunoBuscado = null;

		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				alunoBuscado = aluno;
			}
		}
		return alunoBuscado;
	}

	public void remove(Aluno aluno) {
		this.alunos.remove(aluno);
	}

	public void update(Aluno aluno) {

		Aluno novoAluno = getAlunoByMatricula(aluno.getMatricula());
		novoAluno.setMatricula(aluno.getMatricula());
		novoAluno.setNome(aluno.getNome());
		novoAluno.setAnoNascimento(aluno.getAnoNascimento());
		novoAluno.setTelefone(aluno.getTelefone());
		novoAluno.setEmail(aluno.getEmail());
		novoAluno.setTurma(aluno.getTurma());	
	}
	
	//************* métodos da API
	
		public List<Aluno> getAlunosApi(){
			
			List<Aluno> alunoAPI = this.alunos;
			for (int i=0; i<alunos.size(); i++) {
				alunoAPI.get(i).setOcorrencias(null);
				//alunoAPI.get(i).setTurma(null);
			}
			return alunoAPI;
		}

}
