package com.aulabd2.aulabd2.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ClienteDAO {
    @Autowired DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirCliente(Cliente cli){
        String sql = "INSERT INTO cliente(nome,email,senha,senhaC)" +
        " VALUES (?,?,?,?)";
        Object[] obj = new Object[4];
        obj[0] = cli.getNome();
        obj[1] = cli.getEmail();
        obj[2] = cli.getSenha();
        obj[3] = cli.getSenhaC();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarClientes() {
    	String sql = "SELECT * FROM cliente";
    	return jdbc.queryForList(sql);
    }
    public List<Map<String,Object>> obterCliente(int id){
		String sql = "SELECT * FROM cliente where id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForList(sql, obj);
	}

    public void atualizarCliente(int id, Cliente cli) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, senha = ?, senhaC = ? WHERE id = ?";
        Object[] obj = new Object[4];
		//primeiro ?
		obj[0] = cli.getNome();
		//segundo ?
		obj[1] = cli.getEmail();
        //terceiro ?
        obj[2] = cli.getSenha();
		//quarto ?
        obj[3] = cli.getSenhaC();

		obj[4] = id;
		jdbc.update(sql, obj);
    }

    public void apagarCliente(int id){
		String sql = "DELETE FROM cliente WHERE id = ?";
		Object[] obj = new Object[1];
		obj[0] = id;
		jdbc.update(sql, obj);
	}

}
