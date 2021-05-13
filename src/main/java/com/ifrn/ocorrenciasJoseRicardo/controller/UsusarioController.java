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

import com.ifrn.ocorrenciasJoseRicardo.model.Usuario;
import com.ifrn.ocorrenciasJoseRicardo.repository.UsuarioRepository;

@Controller
public class UsusarioController {
	
	@Autowired	
	private UsuarioRepository repository;
	
	@GetMapping("/usuario")
	public String listUsuario(Model model) {
		
		/* Exibe o resultado da variável do método da classe TurmaRepository */
		model.addAttribute("usuarios", repository.getAllUsuarios());

		/*
		 * Nome e local no diretório, do arquivo html que será exibido no mapeamento
		 * acima
		 */
		
		return "/usuario/listar";
	}
	
	@GetMapping("/usuario/novo")
	public String newUsuario(Model model) {

		/* Cria um formulário com os campos vazios e envia para a página html */
		model.addAttribute("usuario", new Usuario());

		return "/usuario/new-usuario";

	}
	
	@PostMapping("/usuario")
	public String saveUsuario(@ModelAttribute Usuario usuario, @RequestParam(required = false) String edit, 
			RedirectAttributes redirect) {

		if(edit==null) {
			repository.save(usuario);
			redirect.addFlashAttribute("msg3", "Usuario criado com sucesso!");
		}else {
			repository.update(usuario);
			redirect.addFlashAttribute("msg2", "Usuario editado com sucesso!");
		}
		return "redirect:/usuario";
	}
	
	@GetMapping("/usuario/deletar/{email}")
	/*
	 * @PathVariable("codigo") => pega o valor escolhido da pagina html enviada com
	 * __${turma.codigo}__
	 */
	public String deletarUsuarioa(@PathVariable("email") String email,
		RedirectAttributes redirect) {
		Usuario usuario = repository.getUsuarioByEmail(email);
		repository.remove(usuario);
		redirect.addFlashAttribute("msg1", "Usuario removido com sucesso!");
		
		return "redirect:/usuario";
	}
	
	@GetMapping("/usuario/editar/{email}")
	public String editarUsuario(@PathVariable("email") String email, Model model) {
		model.addAttribute("usuario",repository.getUsuarioByEmail(email));
		
		return "/usuario/new-usuario";
	}
	
}
