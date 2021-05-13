package com.ifrn.ocorrenciasJoseRicardo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifrn.ocorrenciasJoseRicardo.model.Usuario;
import com.ifrn.ocorrenciasJoseRicardo.repository.UsuarioRepository;

@Controller
public class LoginController {

	@Autowired	
	private UsuarioRepository repository;
	
	@GetMapping("/login")
	public String fazerLogin() {
		
		return "/login/login";
	}
	
	@PostMapping("/login")
	public String processarLogin(@RequestParam("login") String login,
			@RequestParam("senha") String senha,
			HttpSession session){
		
		Usuario usuario = repository.checarLogin(login,senha);
			
		if(usuario!=null) {
			
			session.setAttribute("usuario", usuario);
			
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
}
