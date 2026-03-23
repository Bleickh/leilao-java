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
        
        
        //conn = new conectaDAO().connectDB();
        
        
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
    
    
    
        
}

