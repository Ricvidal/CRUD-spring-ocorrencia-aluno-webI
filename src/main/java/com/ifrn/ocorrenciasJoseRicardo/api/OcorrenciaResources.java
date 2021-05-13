package com.ifrn.ocorrenciasJoseRicardo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ifrn.ocorrenciasJoseRicardo.model.Ocorrencia;
import com.ifrn.ocorrenciasJoseRicardo.repository.OcorrenciaRepository;

@RestController
public class OcorrenciaResources {
	
	@Autowired
	private OcorrenciaRepository repository;
	@GetMapping("/api/ocorrencia")
	public List<Ocorrencia> getOcorrencias(){
		
		//return repository.getAlunosApi();
		return repository.getOcorrenciaApi();
	}
	
	@GetMapping("/api/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable("id") int id) {
		Ocorrencia ocorrencia = repository.getOcorrenciaById(id);
		
		if (ocorrencia!=null) {
			return ResponseEntity.ok(ocorrencia);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/api/ocorrencia")	
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ocorrencia createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		repository.save(ocorrencia);
		return ocorrencia;
	}
	
	@PutMapping("/api/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable("id") int id, 
			@RequestBody Ocorrencia ocorrencia) {
		Ocorrencia ocorrenciaEntity = repository.getOcorrenciaById(id);
		
		if (ocorrenciaEntity!=null) {
			repository.update(ocorrencia);
			return ResponseEntity.ok(ocorrencia);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/api/ocorrencia/{id}")
	public ResponseEntity<Ocorrencia> deleteOcorrencia(@PathVariable("id") int id) {
		Ocorrencia ocorrenciaEntity = repository.getOcorrenciaById(id);
		if (ocorrenciaEntity!=null) {
			repository.remove(ocorrenciaEntity);
			return ResponseEntity.ok(ocorrenciaEntity);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
