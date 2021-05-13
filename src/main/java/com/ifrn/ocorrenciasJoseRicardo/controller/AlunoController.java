package com.ifrn.ocorrenciasJoseRicardo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifrn.ocorrenciasJoseRicardo.model.Aluno;
import com.ifrn.ocorrenciasJoseRicardo.model.Turma;
import com.ifrn.ocorrenciasJoseRicardo.repository.AlunoRepository;
import com.ifrn.ocorrenciasJoseRicardo.repository.TurmaRepository;

@Controller
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/aluno")
	public String listAluno(Model model) {
		
		model.addAttribute("alunos", alunoRepository.getAllAlunos());
		
		return "/aluno/list-aluno";
	}
	@GetMapping("/aluno/novo")
	
	public String newAluno(Model model) {

		/*Cria um formulário com os campos vazios e envia para a página html*/
		model.addAttribute("aluno", new Aluno());
		
		model.addAttribute("turmas", turmaRepository.getAllTurmas());

		return "/aluno/new-aluno";

	}

	@PostMapping("/aluno")
	public String saveAluno(@ModelAttribute Aluno aluno, @RequestParam String codigo, @RequestParam(required = false) String edit, 
			RedirectAttributes redirect){
		if(edit==null) {
		
		Turma turma = turmaRepository.getTurmaByCodigo(codigo);
		aluno.setTurma(turma);
		turma.addAluno(aluno);
		this.alunoRepository.save(aluno);
		redirect.addFlashAttribute("msg3", "Aluno criado com sucesso!");
		
		}else {
			Turma turma = turmaRepository.getTurmaByCodigo(codigo);
			aluno.setTurma(turma);
			turma.addAluno(aluno);
			this.alunoRepository.update(aluno);
			redirect.addFlashAttribute("msg2", "Aluno editado com sucesso!");
		}
		return "redirect:/aluno";
	}
	/*@GetMapping("/turma/mostrar/{codigo}")*/
	@GetMapping("/aluno/mostrar/{matricula}")
		public String mostarAluno(@PathVariable("matricula") String matricula, Model model) {
			
			model.addAttribute("aluno", alunoRepository.getAlunoByMatricula(matricula));	
			
			return "/aluno/show-aluno";	
	}
	
	@GetMapping("/aluno/deletar/{matricula}")
	/*@PathVariable("codigo") => pega o valor escolhido da pagina html enviada com __${turma.codigo}__ */
	public String deletarAluno(@PathVariable("matricula") String matricula, RedirectAttributes redirect) {
	Aluno aluno = alunoRepository.getAlunoByMatricula(matricula);
	//Turma turma = turmaRepository.getTurmaByCodigo(aluno.getTurma().getCodigo());
	alunoRepository.remove(aluno);
	//turma.
	redirect.addFlashAttribute("msg1", "Aluno removido com sucesso!");
	return "redirect:/aluno";	
}

	@GetMapping("/aluno/editar/{matricula}")
	public String editarALuno(@PathVariable("matricula") String matricula, Model model) {
		model.addAttribute("aluno",alunoRepository.getAlunoByMatricula(matricula));
		model.addAttribute("turmas",turmaRepository.getAllTurmas());
		return "/aluno/new-aluno";
	}
}
