package br.edu.ifsp.database;

import java.sql.ResultSet;

/**
 * Interface padrão de ações realizadas pelo sistema gerenciador de banco de dados
 * @author Hugo
 */

public interface Database {

	public boolean connect();
	
	public ResultSet query(String sql);
	
	public int insert(String sql);
	
	public boolean update(String sql);
	
	public boolean delete(String sql);

	public boolean disconnect();
	
}
