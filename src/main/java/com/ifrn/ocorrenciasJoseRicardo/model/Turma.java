package com.ifrn.ocorrenciasJoseRicardo.model;

import java.util.List;

public class Turma {
	
	private String codigo;
	private String nome;
	private int ano;
	private int periodo;
	private  List<Aluno> alunos;
	
	public Turma(String nome, String codigo, int ano, int periodo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.ano = ano;
		this.periodo = periodo;
		
	}
	
	public Turma(String nome, String codigo, int ano, int periodo, List<Aluno> alunos) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.ano = ano;
		this.periodo = periodo;
		this.alunos = alunos;
	}

	public Turma() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	@Override
	public String toString() {
		return this.nome;
	}
	

}
