package com.ifrn.ocorrenciasJoseRicardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasJoseRicardo.model.Usuario;

@Repository
public class UsuarioRepository {
	
	private List<Usuario> usuarios;
	
	public UsuarioRepository() {
		
		usuarios = new ArrayList<Usuario>();
		
		Usuario use1 = new Usuario("João das Quantas", "joaodasquantas@gmail.com", "admin", "123", "Administrador");
		Usuario use2 = new Usuario("Maria da Silva", "mariadasilva@gmail.com", "maria", "123", "Secretária");
	
		usuarios.add(use1);
		usuarios.add(use2);
	}

	public Usuario checarLogin(String login, String senha) {
		Usuario user = null;
		
		for(Usuario usuario:usuarios)
			if(usuario.getLogin().equals(login)&&usuario.getSenha().equals(senha)) {
				user = usuario;
			}
		return user;
	}
	
	public List<Usuario> getAllUsuarios() {
		
		return this.usuarios;
	}

	public void save(Usuario usuario) {
		
			//usuario.setUsuarios(new ArrayList<Usuario>());
			usuarios.add(usuario);
		
	}

	public void update(Usuario usuario) {
			Usuario usuarioNovo = getUsuarioByEmail(usuario.getEmail());
			
			usuarioNovo.setNome(usuario.getNome());
			usuarioNovo.setEmail(usuario.getEmail());
			usuarioNovo.setLogin(usuario.getLogin());
			usuarioNovo.setSenha(usuario.getSenha());
			usuarioNovo.setPapel(usuario.getPapel());
			
		}

	public Usuario getUsuarioByEmail(String email) {
		
		Usuario usuarioBuscado = null;

		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				usuarioBuscado = usuario;
			}
		}
		return usuarioBuscado;
	}

	public void remove(Usuario usuario) {
		
			this.usuarios.remove(usuario);
		
	}
	
	
}
