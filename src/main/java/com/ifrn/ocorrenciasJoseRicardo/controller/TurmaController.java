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

import com.ifrn.ocorrenciasJoseRicardo.model.Turma;
import com.ifrn.ocorrenciasJoseRicardo.repository.TurmaRepository;

/*Essa é a parte central que controla o projeto*/
@Controller
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;

	/*
	 * Entra nesse método ao clicar(action) no link de uma página com esse endereço
	 * mapeando o endereço da barra de navegação
	 */
	@GetMapping("/turma")
	public String listTurma(Model model) {

		/* Exibe o resultado da variável do método da classe TurmaRepository */
		model.addAttribute("turmas", turmaRepository.getAllTurmas());

		/*
		 * Nome e local no diretório, do arquivo html que será exibido no mapeamento
		 * acima
		 */
		return "/turma/list-turma";
	}

	@GetMapping("/turma/nova")
	public String newTurma(Model model) {

		/* Cria um formulário com os campos vazios e envia para a página html */
		model.addAttribute("turma", new Turma());

		return "/turma/new-turma";

	}

	@PostMapping("/turma")
	public String saveTurma(@ModelAttribute Turma turma, @RequestParam(required = false) String edit, 
			RedirectAttributes redirect) {

		if(edit==null) {
			turmaRepository.save(turma);
			redirect.addFlashAttribute("msg3", "Turma criada com sucesso!");
		}else {
			turmaRepository.update(turma);
			redirect.addFlashAttribute("msg2", "Turma editada com sucesso!");
		}
		return "redirect:/turma";
	}

	@GetMapping("/turma/mostrar/{codigo}")
	/*
	 * @PathVariable("codigo") => pega o valor escolhido da pagina html enviada com
	 * __${turma.codigo}__
	 */
	public String mostarTurma(@PathVariable("codigo") String codigo, Model model) {

		model.addAttribute("turma", turmaRepository.getTurmaByCodigo(codigo));

		return "/turma/show-turma";
	}

	@GetMapping("/turma/deletar/{codigo}")
	/*
	 * @PathVariable("codigo") => pega o valor escolhido da pagina html enviada com
	 * __${turma.codigo}__
	 */
	public String deletarTurma(@PathVariable("codigo") String codigo,
		RedirectAttributes redirect) {
		Turma turma = turmaRepository.getTurmaByCodigo(codigo);
		turmaRepository.remove(turma);
		redirect.addFlashAttribute("msg1", "Turma removida com sucesso!");
		
		return "redirect:/turma";
	}
	
	@GetMapping("/turma/editar/{codigo}")
	public String editarTurma(@PathVariable("codigo") String codigo, Model model) {
		model.addAttribute("turma",turmaRepository.getTurmaByCodigo(codigo));
		
		return "/turma/new-turma";
	}

}