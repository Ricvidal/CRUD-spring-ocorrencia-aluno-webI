package com.ifrn.ocorrenciasJoseRicardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasJoseRicardo.model.Ocorrencia;

@Repository
public class OcorrenciaRepository {

	private List<Ocorrencia> ocorrencias;
	
	private int contador;

	public OcorrenciaRepository() {

		ocorrencias = new ArrayList<Ocorrencia>();
		
	}

	public List<Ocorrencia> getAllOcorrencias() {

		return this.ocorrencias;
	}
	
	public Ocorrencia getOcorrenciaById(int id) {
		Ocorrencia ocorrenciaBuscada = null;

		for (Ocorrencia ocorrencia : ocorrencias) {
			if (ocorrencia.getId() == id) {
				ocorrenciaBuscada = ocorrencia;
			}
		}
		return ocorrenciaBuscada;
	}

	public void save(Ocorrencia ocorrencia) {
		
		this.contador = contador + 1;
		ocorrencia.setId(contador);
		this.ocorrencias.add(ocorrencia);

	}

	public void remove(Ocorrencia ocorrencia) {
		this.ocorrencias.remove(ocorrencia);
		
	}
	
public void update(Ocorrencia ocorrencia) {
		System.out.println("id "+ocorrencia.getId());
		Ocorrencia novaOcorrencia = getOcorrenciaById(ocorrencia.getId());
		novaOcorrencia.setTitulo(ocorrencia.getTitulo());
		novaOcorrencia.setDescricao(ocorrencia.getDescricao());
		novaOcorrencia.setDataHora(ocorrencia.getDataHora());
		novaOcorrencia.setAluno(ocorrencia.getAluno());
		novaOcorrencia.setStatus(ocorrencia.getStatus());	
	}

	//************* métodos da API
	
		public List<Ocorrencia> getOcorrenciaApi(){
			
			List<Ocorrencia> ocorrenciaAPI = this.ocorrencias;
			for (int i=0; i<ocorrencias.size(); i++) {
				ocorrenciaAPI.get(i).setAluno(null);
			}
			return ocorrenciaAPI;
		}

}
