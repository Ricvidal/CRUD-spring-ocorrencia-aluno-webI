package com.ifrn.ocorrenciasJoseRicardo.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Ocorrencia {
	
	private int id;
	private String titulo;
	private String descricao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Calendar dataHora;
	
	private StatusOcorrencia status;
	private Aluno aluno;
	
	
	
	
	public Ocorrencia(String titulo, String descricao ,Calendar dataHora, Aluno aluno,StatusOcorrencia status) {
		super();
		
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataHora = dataHora;
		this.aluno = aluno;
		this.status = status;
		
	}
	public Ocorrencia() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public StatusOcorrencia getStatus() {
		return status;
	}
	public void setStatus(StatusOcorrencia status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Ocorrencia [titulo=" + titulo + ", descricao=" + descricao + ", dataHora=" + dataHora + ", aluno="
				+ aluno + ", status=" + status + "]";
	}

	
}
