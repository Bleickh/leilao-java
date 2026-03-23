/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

    try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);

        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());

        prep.executeUpdate();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
    }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() {
        
        

    String sql = "SELECT * FROM produtos";

    try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();

        listagem.clear();

        while (resultset.next()) {

            ProdutosDTO obj = new ProdutosDTO();

            obj.setId(resultset.getInt("id"));
            obj.setNome(resultset.getString("nome"));
            obj.setValor(resultset.getInt("valor"));
            obj.setStatus(resultset.getString("status"));

            listagem.add(obj);
        }

        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
    }

    return listagem;
}
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {

    String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

    try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();

        listagem.clear();

        while (resultset.next()) {

            ProdutosDTO obj = new ProdutosDTO();

            obj.setId(resultset.getInt("id"));
            obj.setNome(resultset.getString("nome"));
            obj.setValor(resultset.getInt("valor"));
            obj.setStatus(resultset.getString("status"));

            listagem.add(obj);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar vendidos: " + e.getMessage());
    }

    return listagem;
}
        public void venderProduto(int id) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";

        try {
        conn = new conectaDAO().connectDB();
        prep = conn.prepareStatement(sql);

        prep.setInt(1, id);
        prep.executeUpdate();

    }   
        catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
    }
}
    
    
    
        
}

