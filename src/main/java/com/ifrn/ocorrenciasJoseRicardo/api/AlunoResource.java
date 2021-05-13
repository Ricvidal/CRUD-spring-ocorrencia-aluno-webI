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

import com.ifrn.ocorrenciasJoseRicardo.model.Aluno;
import com.ifrn.ocorrenciasJoseRicardo.repository.AlunoRepository;

@RestController
public class AlunoResource {
	
	@Autowired
	private AlunoRepository repository;
	@GetMapping("/api/aluno")
	public List<Aluno> getAlunos(){
		
		return repository.getAlunosApi();
	}
	
	@GetMapping("/api/aluno/{matricula}")
	public ResponseEntity<Aluno> getAlunoByMatricula(@PathVariable("matricula") String matricula) {
		Aluno aluno = repository.getAlunoByMatricula(matricula);
		
		if (aluno!=null) {
			return ResponseEntity.ok(aluno);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/api/aluno")	
	@ResponseStatus(code = HttpStatus.CREATED)
	public Aluno createAluno(@RequestBody Aluno aluno) {
		repository.save(aluno);
		return aluno;
	}
	
	@PutMapping("/api/aluno/{matricula}")
	public ResponseEntity<Aluno> updateAluno(@PathVariable("matricula") String matricula, 
			@RequestBody Aluno aluno) {
		Aluno alunoEntity = repository.getAlunoByMatricula(matricula);
		
		if (alunoEntity!=null) {
			repository.update(aluno);
			return ResponseEntity.ok(aluno);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/api/aluno/{matricula}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable("matricula") String matricula) {
		Aluno alunoEntity = repository.getAlunoByMatricula(matricula);
		if (alunoEntity!=null) {
			repository.remove(alunoEntity);
			return ResponseEntity.ok(alunoEntity);	
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
