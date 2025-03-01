package dao;

import java.sql.*;

import model.Usuario;

public class UsuarioDAO extends DAO {
	
	public UsuarioDAO() {
		conectar();
	}
	
	public boolean insertUsuario(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("INSERT INTO usuario (codigo, login, senha, sexo) "
					+ "VALUES ("+usuario.getCodigo()+ ", '" + usuario.getLogin() + "', '"
					+ usuario.getSenha() + "', '" + usuario.getSexo() + "');");
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean updateUsuario(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conn.createStatement();
			String sql = "UPDATE usuario SET login = '" + usuario.getLogin() + "', senha = '"
					+ usuario.getSenha() + "', sexo = '" + usuario.getSexo() + "'"
					+ " WHERE codigo = " + usuario.getCodigo();
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean deleteUsuario(int codigo) {
		boolean status = false;
		try {
			Statement st = conn.createStatement();
			st.executeUpdate("DELETE FROM usuario WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Usuario[] getUsuarios() {
		Usuario[] usuarios = null;
		
		try {
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario");
			if(rs.next()) {
				rs.last();
				usuarios = new Usuario[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++ ) {
					usuarios[i] = new Usuario(rs.getInt("codigo"), rs.getString("login"),
											  rs.getString("senha"), rs.getString("sexo").charAt(0));
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
	
	public Usuario[] getUsuariosMasc() {
		Usuario[] usuarios = null;
		
		try {
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE usuario.sexo LIKE 'M'");
			if(rs.next()) {
				rs.last();
				usuarios = new Usuario[rs.getRow()];
				rs.beforeFirst();
				
				for(int i = 0; rs.next(); i++ ) {
					usuarios[i] = new Usuario(rs.getInt("codigo"), rs.getString("login"),
											  rs.getString("senha"), rs.getString("sexo").charAt(0));
				}
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}
	
	public Usuario getUsuarioById(int codigo) {
		Usuario usuario = null;
		try {
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE codigo = " + codigo);
			if(rs.next()) {
				usuario = new Usuario(rs.getInt("codigo"), rs.getString("login"),
											  rs.getString("senha"), rs.getString("sexo").charAt(0));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}
}
