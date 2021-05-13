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
import com.ifrn.ocorrenciasJoseRicardo.model.Ocorrencia;
import com.ifrn.ocorrenciasJoseRicardo.model.StatusOcorrencia;
import com.ifrn.ocorrenciasJoseRicardo.repository.AlunoRepository;
import com.ifrn.ocorrenciasJoseRicardo.repository.OcorrenciaRepository;

@Controller
public class OcorrenciaController {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	@GetMapping({"/","/ocorrencia"})
	public String ListOcorrencia(Model model) {
		model.addAttribute("ocorrencias", ocorrenciaRepository.getAllOcorrencias());
		return "/ocorrencia/list-ocorrencia";
	}

	@GetMapping("/ocorrencia/nova")
	public String newOcorrencia(Model model) {
		
		model.addAttribute("ocorrencia", new Ocorrencia());
		model.addAttribute("listarStatus", StatusOcorrencia.values());
		model.addAttribute("alunos", alunoRepository.getAllAlunos());

		return "/ocorrencia/new-ocorrencia";
	}

	@PostMapping("/")
	public String saveOcorrencia(@ModelAttribute Ocorrencia ocorrencia, @RequestParam(required=false) String edit, 
			@RequestParam(required=false) String matricula, RedirectAttributes redirect) {
		System.out.println("id no postMapping antes do if: "+ocorrencia.getId());
		System.out.println("id no postMapping antes do if: "+ocorrencia.getTitulo());
		System.out.println("id no postMapping antes do if: "+ocorrencia.getAluno());
		if(edit==null) {
			Aluno aluno = alunoRepository.getAlunoByMatricula(matricula);
			ocorrencia.setAluno(aluno);
			aluno.addOcorrencia(ocorrencia);
			ocorrenciaRepository.save(ocorrencia);
			redirect.addFlashAttribute("msg3", "Ocorrência criada com sucesso!");
		}else {
			
			Aluno aluno = alunoRepository.getAlunoByMatricula(matricula);
			ocorrencia.setAluno(aluno);
			aluno.addOcorrencia(ocorrencia);
			
			ocorrenciaRepository.update(ocorrencia);
			redirect.addFlashAttribute("msg2", "Ocorrência editada com sucesso!");
			
		}
		
		
		return "redirect:/";
	}

	@GetMapping("/ocorrencia/mostrar/{id}")
	/*@PathVariable("id") => pega o valor escolhido da pagina html enviada com __${ocorrencia.id}__ */
	public String mostraOcorrencia(@PathVariable("id") int id, Model model) {
		
		Ocorrencia oc = ocorrenciaRepository.getOcorrenciaById(id);
		model.addAttribute("ocorrencias", oc);
		
		return "/ocorrencia/show-ocorrencia";
	}
	
	@GetMapping("/ocorrencia/deletar/{id}")
	public String deletarOcorrencia(@PathVariable("id") int id, RedirectAttributes redirect) {
		Ocorrencia ocorrencia = ocorrenciaRepository.getOcorrenciaById(id);
		ocorrenciaRepository.remove(ocorrencia);
		redirect.addFlashAttribute("msg1", "Ocorrência removida com sucesso!");
		return "redirect:/ocorrencia";
	}
	
	@GetMapping("/ocorrencia/editar/{id}")
	public String editarOcorrencia(@PathVariable("id") int id, Model model) {
		model.addAttribute("ocorrencia",ocorrenciaRepository.getOcorrenciaById(id));
		
		model.addAttribute("listarStatus", StatusOcorrencia.values());
		model.addAttribute("alunos",alunoRepository.getAllAlunos());
		return "/ocorrencia/new-ocorrencia";
	}
}
