package br.com.peedromiranda.exemploJDBC.persistence;

import java.util.List;

import br.com.peedromiranda.exemploJDBC.entity.Contato;

public interface ContatoInterface {
	
	public void salvar(Contato contato) throws Exception;
	
	public void excluir(Integer idContato) throws Exception;
	
	public void alterar(Integer idContato) throws Exception;
	
	public List<Contato> listarTodos() throws Exception;
	
	public Contato encontrar(Integer idContato) throws Exception;

}
