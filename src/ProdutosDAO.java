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
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/uc11", "ggdDev", "GuiProgramador21@!");
            return true;
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Falha na conexão com o banco de dados. " + e.getMessage());
            return false;
        }
    }
    
    public int cadastrarProduto (ProdutosDTO produto){
        int status;
        try{
            prep = conn.prepareStatement("INSERT INTO produtos(nome, valor) VALUES (?,?)");
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

