package com.ifrn.ocorrenciasJoseRicardo.model;

import java.util.List;

public class Aluno {
	private String matricula;
	private String nome;
	private int anoNascimento;
	private String telefone;
	private String email;
	private Turma turma;
	private List<Ocorrencia> ocorrencias;
	
	public Aluno(String matricula, String nome, int anoNascimento, String telefone, String email, Turma turma) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.telefone = telefone;
		this.email = email;
		this.turma = turma;
	}
	
	public Aluno(String matricula, String nome, int anoNascimento, String telefone, String email, Turma turma,
			List<Ocorrencia> ocorrencias) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.telefone = telefone;
		this.email = email;
		this.turma = turma;
		this.ocorrencias = ocorrencias;
	}

	public Aluno() {
		super();
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}
	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	public void addOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencias.add(ocorrencia);
	}
	@Override
	public String toString() {
		return this.matricula+" - "+this.nome;
				
	}	
}
