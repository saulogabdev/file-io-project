package br.edu.ifpr.agenda.model.dao;

import br.edu.ifpr.agenda.model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContatoDAO {
    public void salvarSemEndereco(Contato contato) {
        String sqlContato = "INSERT INTO contatos(nome, celular, email) VALUES(?, ?, ?)";
        Connection con = ConnectionFactory.getConnection();
        try {
            PreparedStatement psContato = con.prepareStatement(sqlContato);
            psContato.setString(1, contato.getNome());
            psContato.setString(2, contato.getCelular());
            psContato.setString(3, contato.getEmail());
            psContato.executeUpdate();
            System.out.println("Contato inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvar(Contato contato) {
        Connection con = ConnectionFactory.getConnection();
        String sqlEndereco = "INSERT INTO enderecos (rua, numero, cidade, estado) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement psEndereco =
                con.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            psEndereco.setString(1, contato.getEndereco().getRua());
            psEndereco.setString(2, contato.getEndereco().getNumero());
            psEndereco.setString(3, contato.getEndereco().getCidade());
            psEndereco.setString(4, contato.getEndereco().getEstado());
            psEndereco.executeUpdate();
            System.out.println("Endereço inserido com sucesso!");
            
            ResultSet rs = psEndereco.getGeneratedKeys();
            int idEndereco = 0;

            if(rs.next()) idEndereco = rs.getInt(1);

            String sqlContato = "INSERT INTO contatos(nome, celular, email, id_endereco) VALUES (?, ?, ?, ?)";
            PreparedStatement psContato = con.prepareStatement(sqlContato);
            psContato.setString(1, contato.getNome());
            psContato.setString(2, contato.getCelular());
            psContato.setString(3, contato.getEmail());
            psContato.setInt(4, idEndereco);
            psContato.executeUpdate();
            System.out.println("Contato inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
