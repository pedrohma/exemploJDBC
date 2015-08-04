package br.com.peedromiranda.exemploJDBC.persistence;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.peedromiranda.exemploJDBC.entity.Contato;

public class ContatoDao extends ConexaoBD implements ContatoInterface{
	
	String sql = "";

	@Override
	public void salvar(Contato contato) throws Exception {
		
		abrirConexao();
		
		sql = "insert into contato values (null, ?, ?, ?, ?)";
		
		try{
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getTelefone());
			stmt.setString(3, contato.getEmail());
			stmt.setDate(4, (Date) contato.getDataCadastro());
			stmt.executeUpdate();			
		}
		catch(SQLException sql){
			System.out.println("Erro ao salvar contato. -> " + sql.getMessage());
		}
		finally{
			try{
				stmt.close();
				fecharConexao();
			}
			catch(Throwable t){
				System.out.println("Erro ao fechar as operações de inserção. -> " + t.getMessage());
			}
		}
		
	}

	@Override
	public void excluir(Integer idContato) throws Exception {
		abrirConexao();
		
		sql = "delete from contato where idcontato = " + idContato;
		
		try{		
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();			
		}
		catch(SQLException sql){
			System.out.println("Erro ao excluir contato. -> " + sql.getMessage());
		}
		finally{
			try{
				stmt.close();
				fecharConexao();
			}
			catch(Throwable t){
				System.out.println("Erro ao fechar as operações de exclusão. -> " + t.getMessage());
			}
		}
	}

	@Override
	public void alterar(Integer idContato) throws Exception {
		abrirConexao();
		
		sql = "update contato set nome = ?, telefone = ?, email = ? where idcontato = " + idContato;
		
		try{		
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();			
		}
		catch(SQLException sql){
			System.out.println("Erro ao alterar contato. -> " + sql.getMessage());
		}
		finally{
			try{
				stmt.close();
				fecharConexao();
			}
			catch(Throwable t){
				System.out.println("Erro ao fechar as operações de alteração. -> " + t.getMessage());
			}
		}
		
	}

	@Override
	public List<Contato> listarTodos() throws Exception {
		abrirConexao();
		List<Contato> listaContato = new ArrayList<Contato>();
		sql = "select * from contato";
		
		try{		
			Contato contato = new Contato();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setDataCadastro(rs.getDate("dataCadastro"));
				listaContato.add(contato);
			}
			
		}
		catch(SQLException sql){
			System.out.println("Erro ao encontrar a lista de contatos. -> " + sql.getMessage());
		}
		finally{
			try{
				stmt.close();
				fecharConexao();
			}
			catch(Throwable t){
				System.out.println("Erro ao fechar as operações de buscar todos contatos. -> " + t.getMessage());
			}
		}
		return listaContato;
	}
	

	@Override
	public Contato encontrar(Integer idContato) throws Exception {
		
		abrirConexao();
		Contato contato = null;
		sql = "select * from contato where idcontato = " + idContato;
		
		try{		
			
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				contato = new Contato();
				contato.setIdContato(rs.getInt("idcontato"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setDataCadastro(rs.getDate("dataCadastro"));
			}
			
		}
		catch(SQLException sql){
			System.out.println("Erro ao encontrar contato. -> " + sql.getMessage());
		}
		finally{
			try{
				stmt.close();
				fecharConexao();
			}
			catch(Throwable t){
				System.out.println("Erro ao fechar as operações de buscar contato. -> " + t.getMessage());
			}
		}
		return contato;
	}

}
