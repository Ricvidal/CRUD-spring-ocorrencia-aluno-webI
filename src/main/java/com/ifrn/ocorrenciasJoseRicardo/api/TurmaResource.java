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

import com.ifrn.ocorrenciasJoseRicardo.model.Turma;
import com.ifrn.ocorrenciasJoseRicardo.repository.TurmaRepository;

@RestController
public class TurmaResource {
	@Autowired
	private TurmaRepository repository;
	@GetMapping("/api/turma")
	public List<Turma> getTurmas(){
		
		return repository.getTurmasApi();
	}
	
	@GetMapping("/api/turma/{codigo}")
	public ResponseEntity<Turma> getTurmaByCodigo(@PathVariable("codigo") String codigo) {
		Turma turma = repository.getTurmaByCodigo(codigo);
		
		if (turma!=null) {
			return ResponseEntity.ok(turma);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/api/turma")	
	@ResponseStatus(code = HttpStatus.CREATED)
	public Turma createTurma(@RequestBody Turma turma) {
		repository.save(turma);
		return turma;
	}
	
	@PutMapping("/api/turma/{codigo}")
	public ResponseEntity<Turma> updateTurma(@PathVariable("codigo") String codigo, 
			@RequestBody Turma turma) {
		Turma turmaEntity = repository.getTurmaByCodigo(codigo);
		
		if (turmaEntity!=null) {
			repository.update(turma);
			return ResponseEntity.ok(turma);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/api/turma/{codigo}")
	public ResponseEntity<Turma> deleteTurma(@PathVariable("codigo") String codigo) {
		Turma turmaEntity = repository.getTurmaByCodigo(codigo);
		
		if (turmaEntity!=null) {
			repository.remove(turmaEntity);
			return ResponseEntity.ok(turmaEntity);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
